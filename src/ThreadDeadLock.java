/**
 * Created by xuan on 2016/6/27 0027.
 */
public class ThreadDeadLock implements Runnable{
    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized(o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized(o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock td1 = new ThreadDeadLock();
        ThreadDeadLock td2 = new ThreadDeadLock();

        td1.flag = 1;
        td2.flag = 0;

        new Thread(td1).start();
        new Thread(td2).start();
    }
}
