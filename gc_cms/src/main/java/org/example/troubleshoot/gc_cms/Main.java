package org.example.troubleshoot.gc_cms;


import com.fuzhenfeng.http.HttpServer;

public class Main {
    public static void main(String[] args) {
        try {
            new HttpServer(new Controller(), 8081).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
