package org.example.troubleshoot.gc_cms;

import com.fuzhenfeng.http.Dispatch;
import com.fuzhenfeng.http.HttpReq;
import com.fuzhenfeng.http.HttpResp;

import java.lang.reflect.Constructor;

public class Controller implements Dispatch {

    @Override
    public HttpResp happyCall(HttpReq httpReq) {
        String uri = httpReq.getRealmName();
        uri = "org.example.troubleshoot.gc_cms." + uri.substring(1, uri.length());
        try {
            Class<?> aClass = Class.forName(uri);
            if(!Thread.class.isAssignableFrom(aClass)) {
                return new HttpResp(200,"can not instant");
            }
            Constructor<?> constructor = aClass.getConstructor(null);
            Object instance = constructor.newInstance(null);
            System.out.println(aClass.getName() + " start");
            ((Thread) instance).start();
        } catch (Exception e) {
            return new HttpResp(200,"can not found");
        }
        return new HttpResp(200,"ok");
    }
}
