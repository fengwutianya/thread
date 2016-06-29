package cocurrency;

/**
 * Created by xuan on 2016/6/29 0029.
 */
public class EvenGenerator extends IntGenerator{
    private int currentValue = 0;

    @Override
    public int next() {
        ++currentValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
