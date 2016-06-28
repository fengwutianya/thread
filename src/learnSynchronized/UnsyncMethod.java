package learnSynchronized;

/**
 * Created by xuan on 2016/6/27 0027.
 */
public class UnsyncMethod {
    public static void main(String[] args) {
        MethodUnsync mu = new MethodUnsync();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mu.syncMethod();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mu.unsyncMethod();
            }
        });
        t1.start();
        t2.start();
    }
}

class MethodUnsync {
    public synchronized void syncMethod() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println("sync method" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void unsyncMethod() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("unsync method--------" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
