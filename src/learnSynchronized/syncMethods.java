package learnSynchronized;

/**
 * Created by xuan on 2016/6/27 0027.
 */
public class syncMethods {
    public static void main(String[] args) {
        MethodsSynced ms = new MethodsSynced();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ms.syncMethod1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ms.syncMethod2();
            }
        });
        t2.start();
        t1.start();
    }
}

class MethodsSynced {
    public synchronized void syncMethod1() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println("sync method 1: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void syncMethod2() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(700);
                System.out.println("---sync method 2---: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
