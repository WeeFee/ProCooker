package com.gitlab.weefee.ProCooker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PlayerData {
    private static final String idCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String fileSeparator = System.getProperty("file.separator");

    private static final Path saveLocation = Path.of(System.getProperty("user.home") +
            fileSeparator +
            ".local" +
            fileSeparator +
            "share" +
            fileSeparator +
            "ProCooker");

    /**
     * User save data
     */
    private static String[] saveData = new String[10];

    /**
     *
     * @param position
     * @param value
     */
    public static void editSaveData(int position, String value) {
        if (position == 0) {
            return;
        }
        saveData[position] = value;
    }

    /**
     *
     * @param position
     * @return
     */
    public static String getSaveData(int position) {
        return saveData[position];
    }

    /**
     * Verifies that the data is present.
     * @return Result of the verification
     */
    public static boolean verifyData() {
        File saveFile = new File(saveLocation + fileSeparator + "save");
        return saveFile.exists();
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
        try {
            BufferedWriter savefileWriter = new BufferedWriter(new FileWriter(saveLocation + fileSeparator + "save"));
            // Create the hash needed
            saveData[0] = hashData(saveData);
            for (int i = 0; i < 10; i++) {
                savefileWriter.write(saveData[i]);
                savefileWriter.newLine();
            }
            savefileWriter.flush();
            savefileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Loads the player data
     * @return Result of the load
     */
    public static boolean loadPlayerData() {
        try {
            BufferedReader savefileReader = new BufferedReader(new FileReader(saveLocation + fileSeparator + "save"));
            String currentLine;
            for (int i = 0; i < 10; i++) {
                currentLine = savefileReader.readLine();
                saveData[i] = currentLine;
            }
            savefileReader.close();
            return saveData[0].equals(hashData(saveData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param inputArray
     * @return
     */
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
