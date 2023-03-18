package org.example.troubleshoot.heap_error;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xms10m -Xmx10m -Xmn10m -XX:PermSize -XX:MaxPermSize
         */
        /**
         * Exception in thread "Thread-1" java.lang.OutOfMemoryError: Java heap space
         * 	at java.base/java.util.Arrays.copyOf(Arrays.java:3689)
         * 	at java.base/java.util.ArrayList.grow(ArrayList.java:238)
         * 	at java.base/java.util.ArrayList.grow(ArrayList.java:243)
         * 	at java.base/java.util.ArrayList.add(ArrayList.java:486)
         * 	at java.base/java.util.ArrayList.add(ArrayList.java:499)
         * 	at org.example.troubleshoot.heap_error.Controller.calculate(Controller.java:20)
         * 	at org.example.troubleshoot.heap_error.Controller.lambda$doTransport$0(Controller.java:13)
         * 	at org.example.troubleshoot.heap_error.Controller$$Lambda$64/0x000000080016f840.run(Unknown Source)
         * 	at java.base/java.lang.Thread.run(Thread.java:834)
         */
        new HttpServer(new Controller()).start();
    }
}
