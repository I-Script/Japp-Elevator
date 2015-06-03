package org.japp.multi.test;

import org.japp.multi.Japp;

public class Main {
    public static void main(String[] args) {
        if(Japp.elevateApplication()) return;

        System.out.println("Application now launched as administrator.");
    }
}
