package MultipleClientsChat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String username;

    public static ArrayList<String> userCode = new ArrayList<>();

    private String security_code;

    public Client(Socket socket, String username, String code){
        try{
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.username = username;

            this.security_code = code;
            userCode.add(this.security_code);
        }
        catch (Exception e){
//            e.printStackTrace();
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }


    public void sendMessage()
    {
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);



            while (socket.isConnected()){
                String messageToSent = scanner.nextLine();
                bufferedWriter.write(username + ": " + messageToSent);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch (Exception e){
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                String msgFromGroupChat;
                while (socket.isConnected()){
                    try {
                        msgFromGroupChat = bufferedReader.readLine();

                        if(msgFromGroupChat.contains(security_code)){
                            for(int i = 0; i < msgFromGroupChat.length(); i++){
                                if(msgFromGroupChat.charAt(i) == '#'){
                                    break;
                                }
                                else{
                                    System.out.print(msgFromGroupChat.charAt(i));
                                }
                            }
                            System.out.println();
                        }
                        if(msgFromGroupChat.contains("#0000")){
                            for(int i = 0; i < msgFromGroupChat.length(); i++){
                                if(msgFromGroupChat.charAt(i) == '#'){
                                    break;
                                }
                                else{
                                    System.out.print(msgFromGroupChat.charAt(i));
                                }
                            }
                            System.out.println();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                        closeEveryThing(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }


    public void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
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


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the chat: ");
        String username = scanner.nextLine();


        System.out.println("Enter your Security code: ");
        Scanner scanner2 = new Scanner(System.in);
        String code = scanner2.nextLine();

        System.out.println("For Sending A specific user, Use Specific Code: ####");
        System.out.println("For Sending sms to all user, Use Code : #0000");


        Socket socket = null;
        try {
            socket = new Socket("localhost", 1234);
            Client client = new Client(socket, username, code);
            client.listenForMessage();
            client.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
