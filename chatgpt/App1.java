import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class App1 {
    private static final String CLICK_TEXT = "\u0E04\u0E25\u0E34\u0E4A\u0E01";
    private static final String HELLO_WORLD_TH = "\u0E2A\u0E27\u0E31\u0E2A\u0E14\u0E35\u0E0A\u0E32\u0E27\u0E42\u0E25\u0E01";

    private int count = 1;
    private final JLabel numberLabel;
    private final Timer timer;
    private final JButton runButton;
    private final JButton stopButton;
    private final Font thaiFont;

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
        thaiFont = getThaiCapableFont(Font.PLAIN, 18);
        JButton clickButton = new JButton(CLICK_TEXT);
        clickButton.setFont(thaiFont.deriveFont(14f));
        stopButton.setEnabled(false);

        timer = new Timer(500, e -> updateCount());

        runButton.addActionListener(e -> startCounting());
        stopButton.addActionListener(e -> stopCounting());
        clickButton.addActionListener(e -> showThaiInfoDialog(frame));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(runButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(clickButton);

        frame.add(numberLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private Font getThaiCapableFont(int style, int size) {
        String[] preferredFonts = {"Noto Sans Thai", "Tahoma", "Leelawadee UI", "TH Sarabun New", Font.DIALOG};
        String[] availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String preferredFont : preferredFonts) {
            for (String availableFont : availableFonts) {
                if (availableFont.equalsIgnoreCase(preferredFont)) {
                    return new Font(availableFont, style, size);
                }
            }
        }

        return new Font(Font.DIALOG, style, size);
    }

    private void showThaiInfoDialog(JFrame frame) {
        JLabel messageLabel = new JLabel(HELLO_WORLD_TH);
        messageLabel.setFont(thaiFont);
        JOptionPane.showMessageDialog(frame, messageLabel, "Info", JOptionPane.INFORMATION_MESSAGE);
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
