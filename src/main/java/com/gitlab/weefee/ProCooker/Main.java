package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;

import java.io.File;
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
                System.out.println("Running on unknown system architecture or operating system.");
            }
            case 1 -> {
                Core.init(new File("lib/discord_game_sdk.dll"));
                System.out.println("Running on Windows");
            }
            case 2 -> {
                Core.init(new File("lib/discord_game_sdk.dylib"));
                System.out.println("Running on macOS");
            }
            case 3 -> {
                Core.init(new File("lib/discord_game_sdk.so"));
                System.out.println("Running on Linux");
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
