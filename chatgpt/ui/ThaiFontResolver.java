package chatgpt.ui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public final class ThaiFontResolver {
    private ThaiFontResolver() {
    }

    public static Font getThaiCapableFont(int style, int size) {
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
}
