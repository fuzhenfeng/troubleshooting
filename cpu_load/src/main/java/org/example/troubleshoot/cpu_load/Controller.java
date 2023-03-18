package org.example.troubleshoot.cpu_load;

import io.netty.handler.codec.http.FullHttpRequest;
import org.example.algorithm.BST;
import org.example.algorithm.FileOperation;
import org.example.troublesheeting.Transport;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Controller implements Transport {

    private ReentrantLock lock = new ReentrantLock(false);

    @Override
    public String doTransport(FullHttpRequest request) {
        new Thread(() -> calculate()).start();
        return "ok";
    }


    private void calculate() {
        if(lock.tryLock()) {
            try {
                System.out.println("lock");
                for (int i = 0; i < 10000; i++) {
                    doCalculate();
                }
                System.out.println("start calculate");
            } finally {
                lock.unlock();
                System.out.println("unlock");
            }
        } else {
            System.out.println("calculate...");
        }
    }

    private void doCalculate() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BST<String, Integer> map = new BST<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }
}
