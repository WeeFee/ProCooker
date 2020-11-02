package com.gitlab.weefee.ProCooker;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PlayerData {

    private static final String idCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * User save data
     */
    private static String[] saveData;

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
        String[] saveDataPreHashed = new String[10];

        // Generate player ID for networking
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            saveDataPreHashed[0] = secureRandom.ints(20, 0, idCharacters.length())
                    .mapToObj(idCharacters::charAt)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Get the current account's username
        saveDataPreHashed[1] = System.getProperty("user.name");

        // Load all other values with 0
        for (int i = 0; i < 8; i++) {
            saveDataPreHashed[i+2] = "0";
        }

        // DEBUG: Print out player ID and username
        System.out.println(saveDataPreHashed[0] + " | " + saveDataPreHashed[1]);
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
}
