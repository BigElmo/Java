package Lesson_7.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MainServ {
    private static final Logger LOGGER = LogManager.getLogger(MainServ.class);
    private Vector<ClientHandler> clients;

    public MainServ() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
//            System.out.println("Сервер запущен!");
            LOGGER.info("Сервер запущен!");
            while (true) {
                socket = server.accept();
//                System.out.println("Клиент подключился!");
                LOGGER.info("Клиент подключился!");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
//            e.printStackTrace();
            LOGGER.debug(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
//                e.printStackTrace();
                LOGGER.debug(e.getMessage());
            }
            try {
                server.close();
            } catch (IOException e) {
//                e.printStackTrace();
                LOGGER.debug(e.getMessage());
            }
            AuthService.disconnect();
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void privateMsg(String from, String to, String msg) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(from) || o.getNick().equals(to)) {
                if (!AuthService.isInBlacklist(o.getNick(), from)) {
                    o.sendMsg(msg);
                }
            }
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String from, String msg) {
        for (ClientHandler o : clients) {
            if (!AuthService.isInBlacklist(o.getNick(), from))
            o.sendMsg(msg);
        }
    }
}
