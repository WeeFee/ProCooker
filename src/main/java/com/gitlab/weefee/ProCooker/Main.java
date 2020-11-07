/* SPDX-License-Identifier: GPL-3.0-or-later */

package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

/**
 * Main class.
 */
public class Main {
    /**
     * Game Version
     */
    public static final String version = "0.1-SNAPSHOT";

    /**
     * Main game window
     */
    public static JFrame mainWindow = new JFrame("ProCooker");

    /**
     * Current round counter
     */
    public static int currentRound = 1;

    /**
     * Network feature flag switch
     */
    public static boolean networked = true;

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
        Database ingredients = new Database("./ingredients/");

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

        // Check if the ProCooker services are available
        if (!Networking.checkStatus()) {
            System.out.println("ProCooker services are not available!");
            loadingText.setText("ProCooker services are not available, continuing in offline mode...");
            networked = false;
        }

        Discord.updateActivity("Cooking up a storm",
                "Competing",
                "logo",
                "ProCooker " + version,
                "net" + networked,
                "Connected to ProCooker Services as " + PlayerData.getSaveData(2) + "!");

        // Create main menu
        JLabel menuName = new JLabel("ProCooker"); // dialogue of the game's events, judge speech, etc.

        JButton start = new JButton("BEGIN"); // button to begin the game
        JButton exit = new JButton("EXIT"); // button to exit the game

        JPanel actions = new JPanel();
        actions.setLayout(new FlowLayout());
        actions.add(start);
        actions.add(exit);
        actions.setBorder(BorderFactory.createTitledBorder("Actions"));

        JTextField syncCode= new JTextField(PlayerData.getSaveData(1));
        JButton syncDown = new JButton("DOWNLOAD CLOUD SAVE");
        JButton syncUp = new JButton("UPLOAD SAVE TO CLOUD");

        JPanel options = new JPanel();
        options.setLayout(new FlowLayout());
        options.add(syncCode);
        options.add(syncDown);
        options.add(syncUp);
        options.setBorder(BorderFactory.createTitledBorder("Cloud Options"));

        //Rules section
        JPanel rules = new JPanel();
        rules.setLayout(new GridLayout(25, 0));

        JLabel ruling = new JLabel("You're a chef tasked with creating a 3-round dinner with only 4 ingredients per meal.");
        JLabel ruling2 = new JLabel("Certain ingredients taste better or worse when paired with others. Find the best combinations in order to take home the crown of best ProCooker,");
        JLabel ruling3 = new JLabel("as long as you can defeat the great evil known as the computer player.");

        rules.add(ruling);
        rules.add(ruling2);
        rules.setBorder(BorderFactory.createTitledBorder("Rules"));

        //Text Box section
        JPanel title = new JPanel();
        title.add(menuName);
        title.setBorder(BorderFactory.createTitledBorder("By Alcide Viau and Allan Yang"));

        JPanel frame = new JPanel();

        frame.setLayout(new BorderLayout());
        frame.add(title, BorderLayout.NORTH);
        frame.add(rules, BorderLayout.CENTER);

        JPanel optionsActions = new JPanel();
        optionsActions.add(actions, BorderLayout.NORTH);
        optionsActions.add(options, BorderLayout.SOUTH);
        frame.add(optionsActions, BorderLayout.SOUTH);

        Main.mainWindow.getContentPane().removeAll();
        Main.mainWindow.add(frame);
        Main.mainWindow.setVisible(true);

        // Set up audio object for music and sound effects
        Audio mainMenuSounds = new Audio();

        // Play background music
        Clip mainMenuClip = mainMenuSounds.getBGM("menu");
        mainMenuClip.loop(Clip.LOOP_CONTINUOUSLY);
        mainMenuClip.start();

        // Get the clicking sound ready
        Clip clickSoundClip = mainMenuSounds.getSFX("click");

        String currentWeekly;

        if (networked) {
            // Get the current weekly challenge
            currentWeekly = Networking.getWeeklyInfinite();

            System.out.println("Current weekly challenge: " + currentWeekly);
        }

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookingGame cookingGame = new CookingGame();
                CookingGUI cookingGUI = new CookingGUI();
                cookingGame.setGUI(cookingGUI.CookingGUI(cookingGame));
                Controller controller = new Controller(cookingGame, cookingGUI.ingredientList, cookingGUI.reset, cookingGUI.cookNow, clickSoundClip);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        syncDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Networking.downloadCloudData(syncCode.getText());
            }
        });

        syncUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Networking.uploadCloudData(syncCode.getText());
            }
        });

        // Callback loop
        while (true) {
            Discord.core.runCallbacks();
        }
    }
}
