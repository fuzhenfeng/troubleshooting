package org.example.troubleshoot.heap_error;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;

import java.util.ArrayList;
import java.util.List;

public class Controller implements Transport {

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> error()).start();
        return "ok";
    }

    private void error() {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}
