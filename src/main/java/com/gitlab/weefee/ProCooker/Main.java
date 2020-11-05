/* SPDX-License-Identifier: GPL-3.0-or-later */

package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

/**
 * Main class
 */
public class Main {
    /**
     *
     */
    public static final String version = "0.1-SNAPSHOT";

    /**
     *
     */
    public static JFrame mainWindow = new JFrame("ProCooker");

    /**
     * Main runnable class
     * @param args Starting arguments
     */
    public static void main(String[] args) {
        // Do any operating system specific methods here, check java doc for more information about getOS()
        // Caches the result in OS for future use.
        switch (OSDetection.detectOS()) {
            case 0 -> {
                System.out.println("Discord GameSDK not supported on this system! Sorry! (Skipping initialization)");
                System.out.println("Running on unknown system architecture or operating system. Be warned!");
            }
            case 1 -> {
                Core.init(new File("lib/discord_game_sdk.dll"));
            }
            case 2 -> {
                Core.init(new File("lib/discord_game_sdk.dylib"));
            }
            case 3 -> {
                Core.init(new File("lib/discord_game_sdk.so"));
            }
        }

        // Connect to Discord client
        Discord.connectToDiscord();

        // Set up the Swing window
        JFrame.setDefaultLookAndFeelDecorated(false); // "true" causes issues on certain desktop environments with the CSD buttons suddenly becoming unpressable after resizing
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1280, 720);

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
        Font loadingFont = Objects.requireNonNull(mainFont).deriveFont(45f);

        // Load ingredients
        Database ingredients = new Database(Main.class.getResource("/ingredients/").toExternalForm().substring(5));

        // Set up the main menu panel
        JPanel mainMenuPanel = new JPanel();
        BorderLayout mainMenuLayout = new BorderLayout();
        mainMenuPanel.setLayout(mainMenuLayout);

        // Set loading text
        JLabel loadingText = new JLabel("Loading Profile...");
        loadingText.setFont(loadingFont);
        loadingText.setHorizontalAlignment(SwingConstants.CENTER);
        
        mainMenuPanel.add(loadingText);

        // Make the window visible
        mainWindow.add(mainMenuPanel);
        mainWindow.setVisible(true);

        // Check if player data is present, load if passed
        if (!PlayerData.verifyData()) {
            System.out.println("Data missing, creating new profile");
            loadingText.setText("No Profile Found, Creating New Profile...");
            PlayerData.createNewPlayerData();
        } else {
            System.out.println("Data found, loading profile");
            loadingText.setText("Profile Found, Loading Data...");
            if (!PlayerData.loadPlayerData()) {
                System.err.println("Cannot load data!!! Panic!!!");
                System.exit(1);
            }
        }

        loadingText.setText("Connecting to ProCooker online services...");

        // Print out game version
        System.out.println("Game Version: " + version);

        boolean networked = true;

        // Check if the ProCooker services are available
        if (!Networking.checkStatus()) {
            System.out.println("ProCooker services are not available!");
            loadingText.setText("ProCooker services are not available, continuing in offline mode...");
            networked = false;
        }

        Discord.updateActivity("Hanging Out",
                "In the Main Menu",
                "logo",
                "ProCooker " + version,
                "net" + networked,
                "Connected to ProCooker Services as " + PlayerData.getSaveData(2) + "!",
                Instant.now());

        // Set up audio object for music and sound effects
        Audio mainMenuSounds = new Audio();

        // Play background music
        Clip mainMenuClip = mainMenuSounds.getBGM("menu");
        mainMenuClip.loop(Clip.LOOP_CONTINUOUSLY);
        mainMenuClip.start();

        // Get the clicking sound ready
        Clip clickSoundClip = mainMenuSounds.getSFX("click");

        // DEBUG: Test save data edit
        PlayerData.editSaveData(4, "peepee");
        PlayerData.savePlayerData();

        String currentWeekly;

        if (networked) {
            // Get the current weekly challenge
            currentWeekly = Networking.getWeeklyInfinite();

            System.out.println("Current weekly challenge: " + currentWeekly);
        }

        // Menu loop
        while (true) {
            Discord.core.runCallbacks();
        }
    }
}
