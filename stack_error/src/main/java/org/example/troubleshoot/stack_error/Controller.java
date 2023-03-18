package org.example.troubleshoot.stack_error;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;

import java.util.concurrent.locks.ReentrantLock;

public class Controller implements Transport {

    private ReentrantLock lock = new ReentrantLock(false);

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> error()).start();
        return "ok";
    }

    private void error() {
        error();
    }
}
