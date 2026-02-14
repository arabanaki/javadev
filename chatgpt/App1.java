import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class App1 {
    private int count = 1;
    private final JLabel numberLabel;
    private final Timer timer;
    private final JButton runButton;
    private final JButton stopButton;

    public App1() {
        JFrame frame = new JFrame("Counter 1-10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        numberLabel = new JLabel("1", SwingConstants.CENTER);
        numberLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        runButton = new JButton("Run");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        timer = new Timer(500, e -> updateCount());

        runButton.addActionListener(e -> startCounting());
        stopButton.addActionListener(e -> stopCounting());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(runButton);
        buttonPanel.add(stopButton);

        frame.add(numberLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void startCounting() {
        count = 1;
        numberLabel.setText(String.valueOf(count));
        timer.start();
        runButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopCounting() {
        timer.stop();
        runButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    private void updateCount() {
        count++;
        if (count > 10) {
            count = 1;
        }
        numberLabel.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App1::new);
    }
}
