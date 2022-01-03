package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String args[]){
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            boolean stop = false;

            while (!stop){
                System.out.println("Waiting for clients.......");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is Connected");

                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
