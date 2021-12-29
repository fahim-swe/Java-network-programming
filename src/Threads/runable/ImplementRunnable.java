package Threads.runable;

public class ImplementRunnable implements Runnable{

    private int threadIndex;
    public ImplementRunnable(int index){
        this.threadIndex = index;
    }

    @Override
    public void run() {
        int clientName = 1;
        while (clientName != 100){
            System.out.println("Server" + this.threadIndex +" sent data to client: " + clientName);
            clientName++;
        }
    }


    public void start()
    {
        Thread thread = new Thread(this);
        thread.start();
    }
}
