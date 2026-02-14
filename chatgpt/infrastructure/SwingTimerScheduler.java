package chatgpt.infrastructure;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SwingTimerScheduler implements TickScheduler {
    private final Timer timer;

    public SwingTimerScheduler(int delayMillis, ActionListener actionListener) {
        this.timer = new Timer(delayMillis, actionListener);
    }

    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }

    @Override
    public boolean isRunning() {
        return timer.isRunning();
    }
}
