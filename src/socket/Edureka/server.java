package socket.Edureka;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class server {

    private Socket socket = null;
    public ServerSocket server = null;
    private DataInputStream in = null;

    public server(int port){

        // starts server and waite for a connection
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a clinet........");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            while(!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch (IOException i){
                    System.out.println(i);
                }
            }


            // close connection
            System.out.println("Closing connection");
            socket.close();
            in.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        server server = new server(5000);
    }
}
