package org.example.troubleshoot.gc_cms.metaspace;

import org.example.troubleshoot.gc_cms._GC;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * https://zhuanlan.zhihu.com/p/339053809
 * 全局变量进行缓存可能发生内存泄露
 */
public class _ConfigService implements _GC {
    private static final List<String> namespaces = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            namespaces.add(UUID.randomUUID().toString());
        }
    }
}
