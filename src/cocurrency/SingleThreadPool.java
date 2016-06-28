package cocurrency;

import java.util.concurrent.*;

/**
 * Created by xuan on 2016/6/28 0028.
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
