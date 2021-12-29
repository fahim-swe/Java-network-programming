package socket;

import java.io.*;
import java.net.*;

public class LocalPortScanner {
    public static void main(String[] agrs){
        int port = 1;
        while(port <= 65535){
            try {
                ServerSocket serverSocket;
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Port : " + port + " is open");
            }
            port++;
        }
    }
}
