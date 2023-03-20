package org.example.troubleshoot.gc_cms;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

public class Metaspace extends Thread {
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
