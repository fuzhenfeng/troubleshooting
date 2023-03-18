package org.example.troubleshoot.cpu_load;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;

public class Controller implements Transport {

    @Override
    public String doTransport(FullHttpRequest request) {
        return "hello world.";
    }
}
