/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadWithThread extends Thread{   //extends the Thread class
    /*
    *overriding the run() method
     */
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run: " + i);
        }
    }
    public static void main(String[] args) {
        ThreadWithThread t = new ThreadWithThread();
        System.out.println("priority: " + t.getPriority());
        t.start();      //start the new thread

        //what the main thread do
        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i);
        }
    }
}
