package org.example.troubleshoot.gc;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        new HttpServer(new Controller()).start();
    }
}
