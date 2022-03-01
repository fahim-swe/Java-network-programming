package IO_Stream;



import java.io.*;

public class FileOutputStream {

    public static void main(String[] args){

        // Current Directory
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory);

        try{
            java.io.FileOutputStream fos = new java.io.FileOutputStream(userDirectory + "/src/IO_Stream/text.txt");


            String s = "Learn Java Programming File";

            byte b[] = s.getBytes();
            fos.write(b);


            // Java Programming
            fos.write(b, 6, s.length()-6); // "Java Programming"
            fos.close();

        }catch(Exception e){System.out.println(e);}

    }
}
