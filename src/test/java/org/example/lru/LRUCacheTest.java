package org.example.lru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    LRUCache<String,Integer> cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache<>(4);
    }

    @Test
    void put() {
        cache.put("One",1);
        cache.put("Two",2);
        cache.put("Three",3);
        cache.put("Four",4);

        Assertions.assertEquals(cache.get("One"), Optional.of(1));

        cache.put("Five",5);
        Assertions.assertTrue(cache.get("Two").isEmpty());
    }

    @Test
    void get() {
        cache.put("One",1);
        cache.put("Two",2);
        cache.put("Three",3);
        cache.put("Four",4);

        Assertions.assertEquals(cache.get("One"), Optional.of(1));
        Assertions.assertTrue(cache.head.k.equals("One"));
    }

    @Test
    void has() {
        cache.put("One",1);
        cache.put("Two",2);
        cache.put("Three",3);
        cache.put("Four",4);

        Assertions.assertTrue(cache.has("One"));
        Assertions.assertTrue(cache.head.k.equals("One"));
    }

    @Test
    void delete() {
        cache.put("One",1);
        cache.put("Two",2);
        cache.put("Three",3);
        cache.put("Four",4);
        cache.delete("One");
        Assertions.assertFalse(cache.has("One"));
    }

    @Test
    public void runMultiThreadTask_WhenPutDataInConcurrentToCache_ThenNoDataLost() throws Exception {
        final int size = 50;
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        Cache<Integer, String> cache = new LRUCache<>(size);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        try {
            IntStream.range(0, size).<Runnable>mapToObj(key -> () -> {
                cache.put(key, "value" + key);
                countDownLatch.countDown();
            }).forEach(executorService::submit);
            countDownLatch.await();
        } finally {
            executorService.shutdown();
        }
        assertEquals(cache.size(), size);
        IntStream.range(0, size).forEach(i -> assertEquals("value" + i, cache.get(i).get()));
    }
}