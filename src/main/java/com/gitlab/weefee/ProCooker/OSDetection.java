package com.gitlab.weefee.ProCooker;

/**
 * Internal OS and feature flag detection library
 */
public class OSDetection {
    /**
     * Detects the running operating system.
     *
     * @return 0 = Unsupported, 1 = Windows, 2 = MacOS, 3 = Linux
     */
    public static final int getOS() {
        System.out.println("Current system architecture: " + System.getProperty("os.arch"));
        System.out.println("Current operating system: " + System.getProperty("os.name"));
        if (!System.getProperty("os.arch").toLowerCase().equals("amd64")) {
            return 0;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            return 1;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("dar")) {
            return 2;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("lin")) {
            return 3;
        } else {
            return 0;
        }
    }
}
