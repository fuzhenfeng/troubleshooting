package org.example.troublesheeting;

import io.netty.handler.codec.http.FullHttpRequest;

public interface Transport {

    String doTransport(FullHttpRequest request);
}
