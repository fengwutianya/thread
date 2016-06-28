package learnSynchronized;

/**
 * Created by xuan on 2016/6/27 0027.
 */
public class SyncCodeBlock {
    public static void main(String[] args) {
        SyncRunnable sr = new SyncRunnable();
        Thread t1 = new Thread(sr, "A");
        Thread t2 = new Thread(sr, "B");
        t1.start();
        t2.start();
    }
}

class SyncRunnable implements Runnable {
    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
