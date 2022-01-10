package FileTransferApplication;

import java.net.Socket;

public class ClientInfo {

    private Socket socket;

    public ClientInfo(Socket socket){
        this.socket = socket;
        this.info();
    }

    public void info(){
        System.out.println("Hostname : " + socket.getInetAddress().getHostName());
        System.out.println("Address  : " + socket.getInetAddress().toString());
    }
}
