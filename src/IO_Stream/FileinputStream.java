package IO_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileinputStream {

    public static void main(String[] args)
    {
        String userDirectory = System.getProperty("user.dir");
        FileInputStream fis;

        {
            try {
                fis = new FileInputStream(userDirectory + "/src/IO_Stream/text.txt");

                int x;
                while ((x = fis.read()) != -1){
                    System.out.print((char) x);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
