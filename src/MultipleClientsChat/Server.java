package MultipleClientsChat;

import java.io.IOException;
import java.net.*;
public class Server{

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer()
    {
        try{
           while (!serverSocket.isClosed()){
               Socket socket = serverSocket.accept();

               ClientHandler clintHandler = new ClientHandler(socket);

               System.out.println("A new Client has Connected");


               Thread thread = new Thread(clintHandler);
               thread.start();
           }
        }
        catch (IOException e){

        }
    }

    public void closeServerSocket(){
        try{
            if(serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ServerSocket serverSocket = null;
        System.out.println("Server is Running.........");

        while (true){
            try {
                serverSocket = new ServerSocket(1234);
                Server server = new Server(serverSocket);
                server.startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
