/* SPDX-License-Identifier: GPL-3.0-or-later */

package com.gitlab.weefee.ProCooker;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Networking class for Cloud Saves, Leaderboards, etc.
 */
public class Networking {
    /**
     * Internal http request client.
     */
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(30))
            .build();

    /**
     * Upload the player save game to the cloud service.
     * @param playerID ID of the player to upload save data for.
     * @return Indication if the upload was successful.
     */
    public static boolean uploadCloudData(String playerID) {
        StringBuilder postBody = new StringBuilder();
        // Convert the save file to a single string
        for (int i = 0; i < 10; i++) {
            postBody.append(PlayerData.getSaveData(i));
            postBody.append(",");
        }

        // Prepare the http request
        HttpRequest dataUpload = HttpRequest.newBuilder()
                // Set the save file as the POST body
                .POST(HttpRequest.BodyPublishers.ofString(postBody.toString()))
                .uri(URI.create("https://services.procooker.gq/cloudData/" + playerID + "/"))
                // Provide verification that the request is coming from the game
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            // Send the request to the server
            HttpResponse<String> response = httpClient.send(dataUpload, HttpResponse.BodyHandlers.ofString());

            // Return the result of the request
            return response.statusCode() == 200;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Downloads a user's cloud save data.
     * @param playerID ID of the player to download save data for.
     * @return Indication if the download was successful.
     */
    public static boolean downloadCloudData(String playerID) {
        // Prepare the http request
        HttpRequest dataRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://services.procooker.gq/cloudData/" + playerID + "/"))
                // Provide verification that the request is coming from the game
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            // Send the request to the server
            HttpResponse<String> response = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());

            // Ensure that the server processed the request correctly and sent the save data.
            if (response.statusCode() != 200) {
                return false;
            }

            // Split the response's body into an array
            String[] body = response.body().split(",");

            // Edit the current save data to the received data
            for (int i = 0; i < 10; i++) {
                PlayerData.editSaveData(i, body[i]);
            }

            // Force a save of the player's data
            PlayerData.savePlayerData();

            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Gets the leaderboard top 5
     * @param leaderboardEntry
     * @return
     */
    public static String[] getLeaderboard(String leaderboardEntry) {
        HttpRequest dataRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://services.procooker.gq/leaderboard/" + leaderboardEntry + "/"))
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return null;
            }

            // DEBUG: Print out received data
            System.out.println(response.body());

            return response.body().split(",");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param playerID
     * @param leaderboardEntry
     * @param score
     * @return
     */
    public static boolean uploadLeaderboard(String playerID, String leaderboardEntry, String score) {
        String postBody = playerID + "|" + score;

        HttpRequest dataUpload = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(postBody))
                .uri(URI.create("https://services.procooker.gq/leaderboard/" + leaderboardEntry + "/"))
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(dataUpload, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Get the current weekly challenge from the server.
     * @return The current weekly challenge.
     */
    public static String getWeeklyInfinite() {
        HttpRequest dataRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://services.procooker.gq/weekly/"))
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return null;
            }

            return response.body();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return
     */
    public static boolean checkStatus() {
        HttpRequest dataRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://services.procooker.gq/"))
                .setHeader("User-Agent", "ProCooker")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return false;
            }

            // Print out received server version
            System.out.println("Server Version: " + response.body());

            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
