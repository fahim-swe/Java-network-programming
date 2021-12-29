package Threads.ThreadClass;

public class testingSleep {
    public static void main(String[] args)
    {
        int second = 1;
        try{
            while (second <= 100){
                Thread.sleep(1000); // Like a timmer
                System.out.println("second: " + second);
                second++;
            }
        }
        catch (Exception e){

        }
    }
}
