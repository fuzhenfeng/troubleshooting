package org.example.troubleshoot.method_area;

import io.netty.handler.codec.http.FullHttpRequest;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.example.troublesheeting.Transport;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Controller implements Transport {

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> error()).start();
        return "ok";
    }

    private void error() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
