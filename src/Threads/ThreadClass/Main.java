package Threads.ThreadClass;

public class Main {
    public static void main(String[] args)
    {
//        ServerThread thread = new ServerThread("Server1");
//        ServerThread thread1 = new ServerThread("Server2");
//        thread.start();
//        thread1.start();
//
//
//        System.out.println(("\n\n\n\n"));
//        // Set thread using priority
//        ServerThread thread3 = new ServerThread("Server3");
//        ServerThread thread4 = new ServerThread("Server4");
//        thread4.setPriority(Thread.MAX_PRIORITY);
//        thread3.start();
//        thread4.start();


        // Test sleep method in
        ServerThread thread = new ServerThread("Server1");
        thread.start();
    }
}
