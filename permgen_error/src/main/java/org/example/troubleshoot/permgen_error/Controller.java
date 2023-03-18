package org.example.troubleshoot.permgen_error;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;

public class Controller implements Transport {

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> error()).start();
        return "ok";
    }

    private void error() {
        while (true) {
            Thread thread = new Thread(() -> {
                while (true) {

                }
            });
            thread.start();
        }
    }
}
