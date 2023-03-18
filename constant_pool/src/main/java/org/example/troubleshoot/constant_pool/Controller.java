package org.example.troubleshoot.constant_pool;

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
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
