package org.example.troubleshoot.permgen_error;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xms10m -Xmx10m -Xmn10m -XX:PermSize -XX:MaxPermSize
         */
        /**
         *
         */
        new HttpServer(new Controller()).start();
    }
}
