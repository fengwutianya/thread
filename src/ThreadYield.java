/**
 * Created by xuan on 2016/6/26 0026.
 */
public class ThreadYield {
    public static void main(String[] args) {
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        MyThread3 t1 = new MyThread3("t1");
        MyThread3 t2 = new MyThread3("------t2-----");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t2.setPriority(Thread.NORM_PRIORITY - 3);
        t1.start();
        t2.start();
    }
}

class MyThread3 extends Thread {
    MyThread3(String s) {
        super(s);
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
            if (i % 10 == 0) {
                yield();
            }
        }
    }
}
