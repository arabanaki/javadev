package chatgpt.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import chatgpt.application.CounterService;
import chatgpt.i18n.Messages;
import chatgpt.infrastructure.SwingTimerScheduler;
import chatgpt.infrastructure.TickScheduler;

public class MainWindow {
    private final CounterService counterService;
    private final TickScheduler tickScheduler;

    private final JFrame frame;
    private final JLabel numberLabel;
    private final JButton runButton;
    private final JButton stopButton;
    private final Font thaiFont;

    public MainWindow() {
        this.counterService = new CounterService(1, 10);

        frame = new JFrame(Messages.WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        numberLabel = new JLabel("1", SwingConstants.CENTER);
        numberLabel.setFont(new Font("SansSerif", Font.BOLD, 60));

        thaiFont = ThaiFontResolver.getThaiCapableFont(Font.PLAIN, 18);

        runButton = new JButton(Messages.RUN_BUTTON);
        stopButton = new JButton(Messages.STOP_BUTTON);
        JButton clickButton = new JButton(Messages.CLICK_BUTTON_TH);
        clickButton.setFont(thaiFont.deriveFont(14f));
        stopButton.setEnabled(false);

        tickScheduler = new SwingTimerScheduler(500, e -> updateCount());

        runButton.addActionListener(e -> startCounting());
        stopButton.addActionListener(e -> stopCounting());
        clickButton.addActionListener(e -> showThaiInfoDialog());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(runButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(clickButton);

        frame.add(numberLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void startCounting() {
        int startValue = counterService.startFromBeginning();
        numberLabel.setText(String.valueOf(startValue));
        tickScheduler.start();
        runButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopCounting() {
        tickScheduler.stop();
        runButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    private void updateCount() {
        int nextValue = counterService.moveToNextValue();
        numberLabel.setText(String.valueOf(nextValue));
    }

    private void showThaiInfoDialog() {
        JLabel messageLabel = new JLabel(Messages.HELLO_WORLD_TH);
        messageLabel.setFont(thaiFont);
        JOptionPane.showMessageDialog(frame, messageLabel, Messages.INFO_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }
}
