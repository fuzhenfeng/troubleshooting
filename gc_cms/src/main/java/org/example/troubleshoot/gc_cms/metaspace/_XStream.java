package org.example.troubleshoot.gc_cms.metaspace;

import com.thoughtworks.xstream.XStream;
import org.example.troubleshoot.gc_cms._GC;

import java.util.ArrayList;

/**
 * https://www.51cto.com/article/662175.html
 * todo 无法复现
 */
public class _XStream implements _GC {

    @Override
    public void run() {
        while (true) {
            Province p1 = new Province();
            p1.setName("xx");

            ArrayList<Province> provinceList = new ArrayList<>();
            provinceList.add(p1);

            XStream xStream = new XStream();
            xStream.toXML(provinceList);
        }
    }

    class Province {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
