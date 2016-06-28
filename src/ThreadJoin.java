/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadJoin {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("t1");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("I am the main thread.");
        }
    }
}

class MyThread2 extends Thread {
    MyThread2(String s) {
        super(s);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
