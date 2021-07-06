package Lesson_6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket socket = null;
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            System.out.println("Connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String str = in.readUTF();
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
