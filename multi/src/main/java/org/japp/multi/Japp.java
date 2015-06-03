package org.japp.multi;

import org.japp.common.AppUtils;

public class Japp {
    public static boolean elevateApplication() {
        switch(AppUtils.DETECTED_OS)
        {
            case WINDOWS:
                return org.japp.windows.Japp.elevateApplication();
            case LINUX:
                return org.japp.linux.Japp.elevateApplication();
            case MAC:
                return org.japp.mac.Japp.elevateApplication();

            default:
                return false;
        }
    }
}
