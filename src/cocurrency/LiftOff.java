package cocurrency;

/**
 * Created by xuan on 2016/6/28 0028.
 */
public class LiftOff implements Runnable{
    protected int CountDown = 10;     //default 10
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {}
    public LiftOff(int CountDown) {
        this.CountDown = CountDown;
    }

    public String status() {
        return "#" + id + "(" +
                (CountDown > 0 ? CountDown : "LiftOff") +
                ").";
    }

    @Override
    public void run() {
        while (CountDown -- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
