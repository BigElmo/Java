package Lesson_7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MainServ serv;
    private Socket socket;
    private String nick;
    DataInputStream in;
    DataOutputStream out;

    public ClientHandler(MainServ serv, Socket socket) {
        try {
            this.serv = serv;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String currentNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if (currentNick != null) {
                                    if (!serv.isNickBusy(currentNick)) {
                                        sendMsg("/authok");
                                        nick = currentNick;
                                        serv.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Пользователь уже авторизован!");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            System.out.println("Client " + str);
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (str.startsWith("/blacklist")) {
                                    String[] tokens = str.split(" ");
                                    if (tokens[1].equals(nick)) {
                                        out.writeUTF("Нельзя добавить себя в чёрный список!");
                                    } else if (serv.isNickBusy(tokens[1])) {
                                        if (!AuthService.isInBlacklist(nick, tokens[1])) {
                                            AuthService.addToBlackList(nick, tokens[1]);
                                        }
                                        out.writeUTF(tokens[1] + " занесён в чёрный список");
                                    } else {
                                        out.writeUTF(tokens[1] + " не авторизован");
                                    }
                                }
                                if (str.startsWith("/w")) {
                                    String[] keys = str.split(" ");
                                    if (serv.isNickBusy(keys[1])) {
                                        String newMsg = str.substring(keys[0].length() + keys[1].length() + 2);
                                        serv.privateMsg(nick, keys[1], nick + " : " + newMsg);
                                    } else {
                                        out.writeUTF("Получатель не найден");
                                    }
                                }
                            } else {
                                serv.broadcastMsg(nick,nick + " : " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        serv.unsubscribe(ClientHandler.this);
                    }

                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
