package org.example.lru;

public class Main {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(4);

        cache.put("One", 1);
        cache.put("Two", 2);
        cache.put("Three", 3);
        cache.put("Four", 4);


        cache.get("One");
        cache.put("Five", 5);

        System.out.println(cache);
    }
}
