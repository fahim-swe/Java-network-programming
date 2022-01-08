package FileTransferApplication;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void listofFiles(String address){
        try{
            File file = new File(address);
            File[] files = file.listFiles();
            System.out.println("List of files:-");

            for(int fileInList = 0; fileInList < files.length; fileInList++){
                System.out.println(fileInList+1 + ": " + files[fileInList].getName());
            }

            System.out.println();
        }
        catch (Exception e){

        }

    }
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        System.out.println("------------------------------------------------------------");
        System.out.println("------------Welcome to Jave Networking Programming----------");
        System.out.println("------------------------------------------------------------");
        System.out.println();




        try{
            Socket socket = new Socket("localhost", 1234);
            listofFiles("./src/Files");
            System.out.println();

            System.out.println("Print enter a file name: ");
            fileName = reader.readLine();

            InputStream inputStream = socket.getInputStream();
            BufferedInputStream input = new BufferedInputStream(inputStream);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(fileName);

            int code = input.read();
            if(code == 1){
                System.out.println("Found");
                BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("/home/fahim/" + fileName));
                System.out.println(outputFile.toString());
                // Convert BufferedInputStream to byte array
                int nRead;
                byte[] data = new byte[16384];

                while ((nRead = input.read(data, 0, data.length)) != -1) {
                    outputFile.write(data, 0, nRead);
                    outputFile.flush();
                }

                System.out.println();
                System.out.println("File: " + fileName + " was successfully download in your Pc");

            }
            else{
                System.out.println("File if not present on the computer");
            }

        }
        catch (Exception e){

        }
    }






}
