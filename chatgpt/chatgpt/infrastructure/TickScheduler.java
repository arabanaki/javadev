package chatgpt.infrastructure;

public interface TickScheduler {
    void start();

    void stop();

    boolean isRunning();
}
