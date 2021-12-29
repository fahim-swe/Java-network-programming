package Threads.runable;

public class Main {
    public static void main(String[] args){
        ImplementRunnable runnable1 = new ImplementRunnable(1);
        ImplementRunnable runnable2 = new ImplementRunnable(2);
        ImplementRunnable runnable3 = new ImplementRunnable(3);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);


        thread1.start();
        thread2.start();
        runnable3.start();



    }
}
