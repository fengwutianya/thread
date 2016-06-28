/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadSync implements Runnable {
    Timer timer = new Timer();
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ThreadSync sync = new ThreadSync();
        Thread t1 = new Thread(sync);
        Thread t2 = new Thread(sync);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Timer {
    private static int num = 0;
    public /*synchronized */void add(String name) {
        synchronized(this) {        //lock the current class
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            System.out.println(name + ": you are the " + num + " one to use the timer.");
        }
    }
}
