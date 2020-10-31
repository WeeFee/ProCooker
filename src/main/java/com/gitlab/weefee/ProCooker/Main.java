package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;

import java.io.File;
import java.time.Instant;

/**
 * Main class
 */
public class Main {
    /**
     * Cached OS int
     */
    public static int OS;

    /**
     * Main runnable class
     * @param args Start up arguments
     */
    public static void main(String[] args) {
        // Do any operating system specific methods here, check java doc for more information about getOS()
        // Caches the result in OS for future use.
        switch (OSDetection.getOS()) {
            case 0 -> {
                System.out.println("Discord GameSDK not supported on this system! Sorry! (Skipping initialization)");
                OS = 0;
            }
            case 1 -> {
                Core.init(new File("lib/discord_game_sdk.dll"));
                OS = 1;
            }
            case 2 -> {
                Core.init(new File("lib/discord_game_sdk.dylib"));
                OS = 2;
            }
            case 3 -> {
                Core.init(new File("lib/discord_game_sdk.so"));
                OS = 3;
            }
        }
        // Connect to Discord client
        Discord.connectToDiscord();

        // FIXME: Remove Discord activity test once main menu is created
        Discord.updateActivity("Hanging Out",
                "In the Main Menu",
                "null",
                "null",
                "null",
                "null",
                Instant.now());

        // Main game loop
        while (true) {
            Discord.core.runCallbacks();
        }
    }
}
