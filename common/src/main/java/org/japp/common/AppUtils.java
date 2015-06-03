package org.japp.common;

import java.util.Locale;
import java.util.prefs.Preferences;

public final class AppUtils {
    public enum OSType {
        WINDOWS, MAC, LINUX, OTHER
    }

    /**
     * @return the detected OsType.
     */
    public static final OSType DETECTED_OS = getOperatingSystemType();

    private static OSType getOperatingSystemType() {
        String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

        if ((os.contains("mac")) || (os.contains("darwin"))) {
            return OSType.MAC;
        } else if (os.contains("win")) {
            return OSType.WINDOWS;
        } else if (os.contains("nux")) {
            return OSType.LINUX;
        } else
            return OSType.OTHER;
    }

    /**
     * @return true if the application was launched as admin.
     */
    public static boolean hasAdminRights() {
        try{
            Preferences prefs = Preferences.systemRoot();
            prefs.put("foo", "bar");
            prefs.remove("foo");
            prefs.flush();
            return true;
        } catch(Exception e){
            return false;
        }
    }
}