package IO_Stream;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStream {
    public static void main(String args[]){
        String data = "This is file Output output stream";

        try{
            OutputStream out = new java.io.FileOutputStream("output.txt");

            // converts the string into bytes
            byte[] dataBytes = data.getBytes();

            // Write data to the output stream
            out.write(dataBytes);
            System.out.println("Data is written to the file Successfully");
        }catch (Exception e){

        }
    }
}
