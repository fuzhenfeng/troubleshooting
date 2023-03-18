package org.example.troubleshoot.stack_error;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xss128k
         */
        /**
         * Exception in thread "Thread-0" java.lang.StackOverflowError
         * 	at org.example.troubleshoot.permgen_error.Controller.error(Controller.java:19)
         */
        new HttpServer(new Controller()).start();
    }
}
