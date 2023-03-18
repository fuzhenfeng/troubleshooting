package org.example.troubleshoot.native_error;

import org.example.troublesheeting.HttpServer;

public class Main {
    public static void main(String[] args) {
        /**
         * -Xmx20M -XX:MaxDirectMemorySize=10
         */
        /**
         * Exception in thread "Thread-1" Exception in thread "Thread-0" java.lang.OutOfMemoryError
         * 	at java.base/jdk.internal.misc.Unsafe.allocateMemory(Unsafe.java:618)
         * 	at jdk.unsupported/sun.misc.Unsafe.allocateMemory(Unsafe.java:460)
         * 	at org.example.troubleshoot.native_error.Controller.error(Controller.java:25)
         * 	at org.example.troubleshoot.native_error.Controller.lambda$doTransport$0(Controller.java:15)
         * 	at java.base/java.lang.Thread.run(Thread.java:834)
         */
        new HttpServer(new Controller()).start();
    }
}
