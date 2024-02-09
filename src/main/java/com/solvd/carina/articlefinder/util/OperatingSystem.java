package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public enum OperatingSystem {
    WINDOWS(
            "Windows",
            "Microsoft Windows",
            List.of("win")),
    MAC(
            "macOS",
            "Macintosh Operating System",
            List.of("mac")
    ),
    LINUX(
            "Linux",
            "GNU/Linux",
            List.of("nix", "nux", "aix")
    ),
    OTHER(
            "Other",
            "Unknown Operating System",
            null
    );

    private static final Logger LOGGER = LogManager.getLogger(OperatingSystem.class);

    private final String simpleName;
    private final String formalName;
    private final List<String> informalIdentifiers;

    OperatingSystem(String simpleName, String formalName, List<String> informalIdentifiers) {
        this.simpleName = simpleName;
        this.formalName = formalName;
        this.informalIdentifiers = informalIdentifiers;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getFormalName() {
        return formalName;
    }

    public List<String> getInformalIdentifiers() {
        List<String> listOfIds = null;

        if (BooleanUtils.isEmptyOrNullCollection(informalIdentifiers)) {
            LOGGER.warn(
                    "The list of informal identifiers is empty or null, returning collection with a single empty string."
            );

            listOfIds = List.of(StringConstants.EMPTY_STRING);
        } else {
            listOfIds = informalIdentifiers;
        }

        return listOfIds;
    }

    public String getFirstInformalId() {
        String firstInformalId = StringConstants.EMPTY_STRING;

        if (BooleanUtils.isEmptyOrNullCollection(informalIdentifiers)) {
            LOGGER.warn(
                    "The list of informal identifiers is empty or null, an empty string."
            );
        } else {
            firstInformalId = informalIdentifiers.get(0);
        }

        return firstInformalId;
    }


    public static OperatingSystem getOperatingSystem() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (isWindows(osName)) {
            return WINDOWS;
        } else if (isMac(osName)) {
            return MAC;
        } else if (isLinux(osName)) {
            return LINUX;
        } else {
            return OTHER;
        }
    }

    public static String getCurrentOperatingSystemString() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static boolean isWindows(String osName) {
        return osName.contains("win");
    }
    public static boolean isMac(String osName) {
        return osName.contains("mac");
    }
    public static boolean isLinux(String osName) {
        return osName.contains("nix")
                || osName.contains("nux")
                || osName.contains("aix");
    }
}
