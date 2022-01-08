package MultipleClientsChat;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUserName;



    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            this.clientUserName = bufferedReader.readLine();


            clientHandlers.add(this);

            broadcastMessage("SERVER: " + clientUserName + " has entered the chat!");
        }
        catch (Exception e){
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }



    @Override
    public void run() {

        String messageFromClient;
        while (socket.isConnected()){
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);

            } catch (IOException e) {
                e.printStackTrace();
                closeEveryThing(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend){
        for(ClientHandler clientHandler: clientHandlers){
            try{
                if(!clientHandler.clientUserName.equals(this.clientUserName)){
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            }
            catch (Exception e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClintHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUserName + " has left the chat!");
    }


    public void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClintHandler();

        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedReader.close();
            }
            if(socket != null){
                socket.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
