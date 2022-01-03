package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String arg[]){
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Connected");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = input.readLine();
            System.out.println(clientInput);

            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
