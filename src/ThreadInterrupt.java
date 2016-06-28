import java.util.Date;

/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        thread.interrupt();
    }
}

class MyThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("===" + new Date() + "===");
            try {
                sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
