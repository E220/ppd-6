package program;

public class Timer {
    private long tick;

    public void start() {
        this.tick = System.nanoTime();
    }
    public double measure() {
        return (System.nanoTime() - this.tick) / 1000.0;
    }

    public void print(double diff) {
        System.out.println(diff + "ms");
    }
}
