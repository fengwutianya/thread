package cocurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Created by xuan on 2016/6/29 0029.
 */
public class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int var = generator.next();
            if (var % 2 != 0) {
                System.out.println(var + "not even!");
            }
            generator.cancel();
        }
    }
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Ctrl-c to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
