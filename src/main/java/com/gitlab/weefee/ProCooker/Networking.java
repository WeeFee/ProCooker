package com.gitlab.weefee.ProCooker;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Networking {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(30))
            .build();

    public static void uploadCloudData() {

    }

    public static boolean downloadCloudData(String playerID) {
        HttpRequest dataRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://services.procooker.gq/cloudData/" + playerID))
                .setHeader("User-Agent", "ProCooker")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(dataRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return false;
            }

            // DEBUG: Print out received data
            System.out.println(response.body());

            String[] body = response.body().split(",");

            for (int i = 0; i < 10; i++) {
                PlayerData.editSaveData(i, body[i]);
            }

            PlayerData.savePlayerData();

            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
