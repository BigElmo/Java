package Lesson_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Server runs at " + serverSocket.getLocalPort());
            socket = serverSocket.accept();
            System.out.println(socket + " connected");
            System.out.println("Type /exit to close connection");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread readThread = new Thread(()->{
                try{
                    while (true){
                        out.writeUTF(sc.nextLine());
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            });
            readThread.setDaemon(true);
            readThread.start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/exit")) {
                    System.out.println("Disconnected");
                    out.writeUTF("/exit");
                    break;
                }
                System.out.println(str);
                out.writeUTF("echo " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
