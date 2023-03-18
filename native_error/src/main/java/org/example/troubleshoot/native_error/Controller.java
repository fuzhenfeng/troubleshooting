package org.example.troubleshoot.native_error;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Controller implements Transport {

    private static final int _1MB = 1024 * 1024;

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> error()).start();
        return "ok";
    }

    private void error() {
        try {
            Field unsafedField = Unsafe.class.getDeclaredFields()[0];
            unsafedField.setAccessible(true);
            Unsafe unsafe = (Unsafe) unsafedField.get(null);
            while (true) {
                unsafe.allocateMemory(_1MB);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
