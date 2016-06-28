/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadWithRunnable {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i);
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run: " + i);
        }
    }
}
