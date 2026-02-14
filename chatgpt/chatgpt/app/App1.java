package chatgpt.app;

import javax.swing.SwingUtilities;

import chatgpt.ui.MainWindow;

public class App1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().show());
    }
}
