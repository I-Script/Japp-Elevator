package org.japp.winsows.test;

import org.japp.windows.Japp;

public class Main {
    public static void main(String[] args) {
        if(Japp.elevateApplication()) return;

        System.out.println("Application now launched as administrator.");
    }
}
