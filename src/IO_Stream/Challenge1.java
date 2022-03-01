package IO_Stream;

// You have a source file source1.txt
// create a file named source2.txt and copy source1.txt
// combine these two file and make a file called combine.txt

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.*;
import java.io.FileOutputStream;

public class Challenge1 {
    public static void main(String arg[])
    {
        String userDirectory = System.getProperty("user.dir");

        try (FileInputStream file = new FileInputStream(userDirectory + "/src/IO_Stream/source1.txt")) {

            FileOutputStream fos = new FileOutputStream(userDirectory + "/src/IO_Stream/source2.txt");

            int b;

            while ( (b = file.read()) != -1)
            {
                fos.write(b);
            }
            file.close();
            fos.close();

            FileInputStream fis1 = new FileInputStream(userDirectory + "/src/IO_Stream/source1.txt");
            FileInputStream fis2 = new FileInputStream(userDirectory + "/src/IO_Stream/source2.txt");

            fos = new FileOutputStream(userDirectory + "/src/IO_Stream/destination.txt");

            SequenceInputStream sis = new SequenceInputStream(fis1, fis2);

            while ((b = sis.read()) != -1){
                fos.write(b);
            }

            fos.close();
            sis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
