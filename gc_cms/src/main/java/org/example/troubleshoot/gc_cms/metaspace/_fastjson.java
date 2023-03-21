package org.example.troubleshoot.gc_cms.metaspace;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.example.troubleshoot.gc_cms._GC;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 1 https://zhuanlan.zhihu.com/p/365292971
 * 2 https://www.lmlphp.com/user/10643/article/item/422636/
 * todo 无法复现
 */
public class _fastjson implements _GC {
    public static void main(String[] args) {
        new _fastjson().run();
    }
    @Override
    public void run() {
        while (true) {
            Custom custom = new Custom();
            custom.setName("xxx");
            SerializeConfig serializeConfig = new SerializeConfig();
//            serializeConfig.put(Custom.class, new CustomSerializer());
            serializeConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
            JSON.toJSONString(custom, serializeConfig);
        }
    }
    class Custom {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    class CustomSerializer implements ObjectSerializer {

        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {

        }
    }
}
