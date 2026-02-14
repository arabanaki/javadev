package chatgpt.domain;

public class CounterModel {
    private final int min;
    private final int max;
    private int value;

    public CounterModel(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be <= max");
        }
        this.min = min;
        this.max = max;
        this.value = min;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = min;
    }

    public void next() {
        value++;
        if (value > max) {
            value = min;
        }
    }
}
