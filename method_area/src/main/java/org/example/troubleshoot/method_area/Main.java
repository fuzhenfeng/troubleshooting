package org.example.troubleshoot.method_area;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xms10m -Xmx10m -Xmn10m -XX:PermSize=1M -XX:MaxPermSize=1M
         */
        /**
         * todo
         * Caused by:java.lang.OutOfMemoryError:PermGen space
         */
        new HttpServer(new Controller()).start();
    }
}
