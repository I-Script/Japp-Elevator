package org.japp.mac;

import org.japp.common.AppUtils;

import java.io.File;
import java.io.PrintWriter;

public class Japp {
    /**
     * @return true if the app is restarted as admin.
     */
    public static boolean elevateApplication() {
        if(AppUtils.hasAdminRights())
            return false;

        try {
            File executor = File.createTempFile("Executor",".sh");
            PrintWriter writer = new PrintWriter(executor, "UTF-8");

            writer.println("#!/bin/bash");
            writer.println();
            writer.println("java $*");
            writer.close();
            executor.setExecutable(true);

            File elevator = File.createTempFile("Elevator",".sh");
            writer = new PrintWriter(elevator, "UTF-8");
            writer.println("#!/bin/bash");
            writer.println();
            writer.println(String.format("osascript -e \"do shell script \\\"%s $*\\\" with administrator privileges\"",
                    executor.getPath()));
            writer.close();
            elevator.setExecutable(true);

            Runtime.getRuntime().exec(String.format("%s -cp %s Main param",
                    elevator.getPath(),
                    Japp.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
