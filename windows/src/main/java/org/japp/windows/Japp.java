package org.japp.windows;

import org.japp.common.AppUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

public class Japp {
    /**
     * @return true if the app is restarted as admin.
     */
    public static boolean elevateApplication() {
        if(AppUtils.hasAdminRights())
            return false;

        try {
            File file = File.createTempFile("Elevate", ".dat");

            FileChannel channel = new FileOutputStream(file).getChannel();
            channel.transferFrom(Channels.newChannel(Japp.class.getClassLoader().getResourceAsStream("Elevator")), 0, 199552);
            channel.close();

            Runtime.getRuntime().exec(String.format("%s javaw -jar %s",
                    file.getPath(),
                    Japp.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().substring(1)));
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
