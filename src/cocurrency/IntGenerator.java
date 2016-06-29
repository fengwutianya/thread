package cocurrency;

/**
 * Created by xuan on 2016/6/29 0029.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public void cancel() {
        this.canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
    public abstract int next();
}
