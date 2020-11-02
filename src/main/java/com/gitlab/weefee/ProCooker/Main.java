package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

/**
 * Main class
 */
public class Main {
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

        // Check if player data is present, load if passed
        if (!PlayerData.verifyData()) {
            System.out.println("Data missing, creating new profile");
            PlayerData.createNewPlayerData();
        } else {
            System.out.println("Data found, loading profile");
            if (!PlayerData.loadPlayerData()) {
                System.err.println("Cannot load data!!! Panic!!!");
                System.exit(1);
            }
        }

        // FIXME: Remove Discord activity test once main menu is created
        Discord.updateActivity("Hanging Out",
                "In the Main Menu",
                "null",
                "null",
                "null",
                "null",
                Instant.now());

        // Set up audio object for music and sound effects
        Audio mainMenuSounds = new Audio();

        // Play background music
        Clip mainMenuClip = mainMenuSounds.getBGM("menu");
        mainMenuClip.loop(Clip.LOOP_CONTINUOUSLY);
        mainMenuClip.start();

        // Get the clicking sound ready
        Clip clickSoundClip = mainMenuSounds.getSFX("click");

        // Menu loop
        while (true) {
            Discord.core.runCallbacks();
        }
    }
}
