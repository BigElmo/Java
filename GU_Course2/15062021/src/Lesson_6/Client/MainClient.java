package Lesson_6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            System.out.println("Connected");
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
