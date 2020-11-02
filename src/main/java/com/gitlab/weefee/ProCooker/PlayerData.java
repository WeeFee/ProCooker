package com.gitlab.weefee.ProCooker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class PlayerData {
    private static final String idCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Path saveLocation = Path.of(System.getProperty("user.home") +
            System.getProperty("file.separator") +
            ".local" +
            System.getProperty("file.separator") +
            "share" +
            System.getProperty("file.separator") +
            "ProCooker");

    /**
     * User save data
     */
    private static String[] saveData = new String[10];

    /**
     * Verifies the save data and ensure that the data is present.
     * @return Result of the verification
     */
    public static boolean verifyData() {
        return false;
    }

    /**
     * Creates a profile in the user's home directory
     */
    public static void createNewPlayerData() {
        // Generate player ID for networking
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            saveData[1] = secureRandom.ints(20, 0, idCharacters.length())
                    .mapToObj(idCharacters::charAt)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Get the current account's username
        saveData[2] = System.getProperty("user.name");

        // Load all other values with 0
        for (int i = 0; i < 7; i++) {
            saveData[i+3] = "0";
        }

        // DEBUG: Print out player ID and username
        System.out.println(saveData[1] + " | " + saveData[2]);

        // Create the hash needed
        saveData[0] = hashData(saveData);

        // Create the save folder
        try {
            Files.createDirectories(saveLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save player data
        if(!savePlayerData()) {
            System.out.println("Error saving player data after creation!");
        }
    }

    /**
     * Saves the player data
     * @return Result of the save
     */
    public static boolean savePlayerData() {
        return false;
    }

    /**
     * Loads the player data
     * @return Result of the load
     */
    public static boolean loadPlayerData() {
        return false;
    }

    private static String hashData(String[] inputArray) {
        if (inputArray.length == 10) {
            StringBuilder hashingString = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                hashingString.append(inputArray[i + 1]);
            }
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA3-256");
                StringBuilder hash = new StringBuilder();
                byte[] hashedBytes = digest.digest(
                        hashingString.toString().getBytes(StandardCharsets.UTF_8));
                for (byte b: hashedBytes) {
                    hash.append(String.format("%02X", b));
                }
                return hash.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "NULL";
    }
}
