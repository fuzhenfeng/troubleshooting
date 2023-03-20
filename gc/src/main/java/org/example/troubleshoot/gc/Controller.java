package org.example.troubleshoot.gc;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.troublesheeting.Transport;

import java.lang.reflect.Constructor;
import java.util.concurrent.locks.ReentrantLock;

public class Controller implements Transport {

    private ReentrantLock lock = new ReentrantLock(false);

    @Override
    public String doTransport(FullHttpRequest request) {
        String uri = request.uri();
        try {
            Class<?> aClass = Class.forName(uri);
            if(!Thread.class.isAssignableFrom(aClass)) {
                return "can not instant";
            }
            Constructor<?> constructor = aClass.getConstructor(null);
            Object instance = constructor.newInstance(null);
            System.out.println(aClass.getName() + " start");
            ((Thread) instance).start();
        } catch (Exception e) {
            return "can not found";
        }
        return "ok";
    }
}
