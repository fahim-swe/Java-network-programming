package IO_Stream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStream {

    public static void main(String[] args){
        byte[] array = new byte[100];

        try{

            InputStream input = new java.io.FileInputStream("output.txt");


            System.out.println("Available bytes in the file: " + input.available());


            int i = input.read();
            while (i != -1){
                System.out.print((char) i);

                // Reads next byte from the file
                i = input.read();
            }

//            System.out.println("Input Stream After Skipping 5 bytes");
//            input.skip(5);
//            i = input.read();
//            while (i != -1){
//                System.out.print((char) i);
//                i = input.read();
//            }
//            // Close the input stream
//            input.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
