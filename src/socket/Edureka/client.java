package socket.Edureka;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.net.*;
import java.io.*;

public class client {

    // initialize of socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port number
    public client(String address, int port)
    {

        // establish a connection
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);


            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream()) ;

        }
        catch (UnknownHostException e){
            System.out.println(e);
        }
        catch (IOException i){
            System.out.println((i));
        }

        // String to read message from input tab
        String line = "";
        while(!line.equals("Over")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            }
            catch (IOException i){
                System.out.println(i);
            }
        }


        // close the connection
        try{
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i){
            System.out.println((i));
        }
    }


    public static void main(String args[]){
        client client = new client("127.0.0.1", 5000);
    }
}
