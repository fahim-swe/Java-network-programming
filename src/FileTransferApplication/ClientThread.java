package FileTransferApplication;

import java.io.*;
import java.net.Socket;
import java.util.zip.InflaterOutputStream;

public class ClientThread extends Thread{

    private Socket socket;
    private BufferedReader reader;
    private BufferedInputStream fileReader;
    private BufferedOutputStream out;


    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;

    }

    @Override
    public void run() {


        try{
            // create the buffer reader
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // create the output buffer reader
            out = new BufferedOutputStream(socket.getOutputStream());

            // read the filename
            String fileName = reader.readLine();


            System.out.println("file name: " + fileName + " has been requested by " + socket.getInetAddress().getHostAddress());
            File file = new File("./src/Files/" + fileName);

            if(!file.exists())
            {
                System.out.printf("Status   : Requested file doesn't Exits in Server");
                byte code = (byte) 0;
                out.write(code);

            }
            else {
                // if the file exits send code 1 and send the file
                out.write((byte)1);


                // create a buffered input stream variable
                fileReader = new BufferedInputStream(new FileInputStream(file));

                byte[] buffer = new byte[1024];

                // Convert BufferedInputStream to byte array
                int nRead;
                byte[] data = new byte[16384];

                while ((nRead = fileReader.read(data, 0, data.length)) != -1) {
                    out.write(data, 0, nRead);
                    out.flush();
                }

                System.out.printf("Status   : File Downloaded Successfully");
                closeConnection();

            }


        }catch (Exception e){
            System.out.println(e.toString());
            closeConnection();
        }
        super.run();
    }

    private void closeConnection(){
        try{
            if(out != null){
                out.close();
            }
            if(reader != null){
                reader.close();
            }
            if(fileReader != null){
                fileReader.close();
            }
            if(socket != null){
                socket.close();
            }

            System.out.println();
            System.out.println();
        }catch (Exception e){

        }
    }
}
