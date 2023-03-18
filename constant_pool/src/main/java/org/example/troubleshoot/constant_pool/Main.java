package org.example.troubleshoot.constant_pool;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xms10m -Xmx10m -Xmn10m -XX:PermSize=1M -XX:MaxPermSize=1M
         */
        /**
         * todo
         * Exception in thread "main" java.lang.OutOfMemoryError:PermGen space
         */
        new HttpServer(new Controller()).start();
    }
}
