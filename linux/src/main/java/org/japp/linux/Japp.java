package org.japp.linux;

import org.japp.common.AppUtils;

public class Japp {
    /**
     * @return true if the app is restarted as admin.
     */
    public static boolean elevateApplication() {
        if(AppUtils.hasAdminRights())
            return false;

        try {
            Runtime.getRuntime().exec(String.format("gksudo java -jar %s",
                    Japp.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().substring(1)));
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
