package Threads.ThreadClass;

public class ServerThreadSleep extends Thread{

    public ServerThreadSleep(String threadName)
    {
        this.setName(threadName);
    }



    @Override
    public void run() {
        try {
            int clientNumber = 1;
            while (clientNumber != 100){
                System.out.println(this.getName() + "is running client " + clientNumber);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        super.run();
    }
}
