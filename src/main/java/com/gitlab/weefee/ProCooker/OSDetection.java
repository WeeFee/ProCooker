/* SPDX-License-Identifier: GPL-3.0-or-later */

package com.gitlab.weefee.ProCooker;

/**
 * Internal OS and feature flag detection library
 */
public class OSDetection {

    /**
     * Cached OS int
     */
    private static int OS;

    /**
     * Get cached OS result, remember to call detectOS() first.
     *
     * @return Cached OS result, 0 = Unsupported, 1 = Windows, 2 = macOS, 3 = Linux
     */
    public static int getOS() {
        return OS;
    }

    /**
     * Detects the running operating system.
     *
     * @return 0 = Unsupported, 1 = Windows, 2 = macOS, 3 = Linux
     */
    public static final int detectOS() {
        System.out.println("Current system architecture: " + System.getProperty("os.arch"));
        System.out.println("Current operating system: " + System.getProperty("os.name"));
        if (!System.getProperty("os.arch").toLowerCase().equals("amd64")) {
            OS = 0;
            return 0;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            OS = 1;
            return 1;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("dar")) {
            OS = 2;
            return 2;
        } else if (System.getProperty("os.name").toLowerCase().startsWith("lin")) {
            OS = 3;
            return 3;
        } else {
            OS = 0;
            return 0;
        }
    }
}
