package com.gitlab.weefee.ProCooker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class mainMenu {
    private JButton playButton;
    private JButton quitButton;
    private JButton onlineButton;
    private JLabel proCookerLabel;

    private void createUIComponents() {
        // Set up any custom fonts
        Font mainFont = null;
        try {
            mainFont = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResource("/fonts/ARCO.ttf").openStream());
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsEnvironment.registerFont(mainFont);

        // Set font sizes
        Font mainMenu = Objects.requireNonNull(mainFont).deriveFont(45f);

        proCookerLabel.setFont(mainMenu);
    }
}
