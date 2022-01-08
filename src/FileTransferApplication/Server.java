package FileTransferApplication;

import java.io.*;
import java.net.*;
import java.util.Arrays;


public class Server implements ListofFiles{



    public  void listOfFilesGivenDirectory(String address){

        try{
            File file = new File(address);
            File[] files = file.listFiles();

            System.out.println("Currect dir : " + file.getCanonicalPath());

            System.out.println("List of files:-");

            for(int fileInList = 0; fileInList < files.length; fileInList++){
                System.out.println(fileInList+1 + ": " + files[fileInList].getName());
            }

            System.out.println();

        }catch (Exception e){

        }

    }



    public static void main(String[] args){

        try{
            // Initialize the Server socket class
            ServerSocket serverSocket = new ServerSocket(1234);


            System.out.println();
            System.out.println();

            ListofFiles listofFiles = new Server();
            listofFiles.printListofFile("./src/Files");


            System.out.println("A server is waiting connection..........");
            System.out.println();
            System.out.println();



            // boolean variable to stop the server
            boolean isStopped = false;
            while (!isStopped){

                // create client socket object
                Socket clientSocket = serverSocket.accept();
                System.out.println("A Client is Connected: " );

                // print connected client information
                ClientInfo clientInfo = new ClientInfo(clientSocket);


                // create and start client thread
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch (Exception e){
           System.out.println(e.toString());

        }
    }



    @Override
    public void printListofFile(String address) {
        try{
            File file = new File(address);
            File[] files = file.listFiles();

            System.out.println("Currect dir : " + file.getCanonicalPath());

            System.out.println("List of files:-");

            for(int fileInList = 0; fileInList < files.length; fileInList++){
                System.out.println(fileInList+1 + ": " + files[fileInList].getName());
            }

            System.out.println();

        }catch (Exception e){

        }
    }
}
