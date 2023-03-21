package org.example.troubleshoot.gc_cms;

import org.example.troubleshoot.gc_cms.metaspace._ConfigService;
import org.example.troubleshoot.gc_cms.metaspace._XStream;
import org.example.troubleshoot.gc_cms.metaspace._fastjson;


public class Metaspace extends Thread {
    @Override
    public void run() {
//        new _XStream().run();
//        new _ConfigService().run();
        new _fastjson().run();
    }
}
