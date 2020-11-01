package com.gitlab.weefee.ProCooker;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.CreateParams;
import de.jcm.discordgamesdk.activity.Activity;

import java.time.Instant;

/**
 * Internal Discord GameSDK library
 * @author Evie Viau
 * @version 2.5.6
 */
public class Discord {

    /**
     * Core Discord GameSDK object.
     * Not thread safe! Do not use outside of the main thread!
     */
    public static Core core;

    /**
     * Connects to a running Discord client.
     */
    public static void connectToDiscord() {
        // Set the default parameters and add client ID
        try (CreateParams params = new CreateParams()) {
            params.setClientID(771802892121931806L);
            System.out.println("Connecting to Discord!");
            params.setFlags(CreateParams.getDefaultFlags());
            try {
                core = new Core(params);
                System.out.println("Connected to Discord!");
            } catch (Exception e) {
                System.out.println("Failed to connect to Discord!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Update the Discord client's activity.
     *
     * @param details What the player is currently doing
     * @param state The player's current party status
     * @param largeImageKey Keyname of an asset to display
     * @param largeImageText Hover text for the large image
     * @param smallImageKey Keyname of an asset to display
     * @param smallImageText Hover text for the small image
     * @param time Optional - Pass 1 object for a "elapsed" timer and 2 objects for a "remaining" timer (For remaining, the second object must include the time to countdown to)
     */
    public static void updateActivity(String details, String state, String largeImageKey, String largeImageText, String smallImageKey, String smallImageText, Instant... time) {
        System.out.println("Updating Discord activity!");
        try (Activity activity = new Activity()) {
            activity.setDetails(details);
            activity.setState(state);

            activity.assets().setLargeImage(largeImageKey);
            activity.assets().setLargeText(largeImageText);

            activity.assets().setSmallImage(smallImageKey);
            activity.assets().setSmallText(smallImageText);

            if (time.length == 1) {
                activity.timestamps().setStart(time[0]);
            } else if (time.length == 2) {
                activity.timestamps().setEnd(time[1]);
            }

            core.activityManager().updateActivity(activity);
        }
    }
}
