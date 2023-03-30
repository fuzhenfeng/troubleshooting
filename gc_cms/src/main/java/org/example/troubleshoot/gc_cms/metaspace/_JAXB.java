package org.example.troubleshoot.gc_cms.metaspace;

import org.example.troubleshoot.gc_cms._GC;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * "Thread-4380" #4396 prio=5 os_prio=31 cpu=3.80ms elapsed=0.08s tid=0x00007f8c57bf5800 nid=0x323203 waiting for monitor entry  [0x000070011e69a000]
 *    java.lang.Thread.State: BLOCKED (on object monitor)
 * 	at org.example.troubleshoot.gc_cms.metaspace._JAXB.put(_JAXB.java:27)
 * 	- waiting to lock <0x000000061fd2fab0> (a org.example.troubleshoot.gc_cms.metaspace._JAXB)
 * 	at org.example.troubleshoot.gc_cms.metaspace._JAXB.lambda$main$0(_JAXB.java:13)
 * 	at org.example.troubleshoot.gc_cms.metaspace._JAXB$$Lambda$14/0x0000000800067040.run(Unknown Source)
 * 	at java.lang.Thread.run(java.base@11.0.16.1/Thread.java:834)
 */
public class _JAXB implements _GC {

    public static void main(String[] args) {
        _JAXB j = new _JAXB();
        int i = 0;
        while (i < 10000) {
            new Thread(() -> j.put()).start();
            i++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Map<String, String> tables = new HashMap<String, String>();

    public synchronized void put() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tables.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        put();
    }
}
