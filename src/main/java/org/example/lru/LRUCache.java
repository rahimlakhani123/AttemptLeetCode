package org.example.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> implements Cache<K, V> {
    Map<K, LinkedNode<K, V>> internalCache = new HashMap<>();
    LinkedNode<K, V> head;
    LinkedNode<K, V> tail;
    int size;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int size) {
        this.size = size;
    }

    @Override
    public void put(K k, V v) {
        this.lock.writeLock().lock();
        try {
            LinkedNode<K, V> dataNode = new LinkedNode<>(k, v);
            if (internalCache.keySet().size() == this.size) {
                internalCache.remove(tail.k);
            }

            if (head != null) {
                dataNode.next = head;
                dataNode.prev = null;
                head.prev = dataNode;
            }
            if (tail == null)
                tail = dataNode;
            head = dataNode;
            internalCache.put(k, dataNode);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<V> get(K k) {
        this.lock.readLock().lock();
        try {
            var dataNode = internalCache.get(k);
            if (dataNode != null) {
                moveNodeToFirst(dataNode);
                return Optional.of(dataNode.v);
            }
            return Optional.ofNullable(dataNode).map(x -> x.v);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override
    public boolean has(K k) {
        this.lock.readLock().lock();
        try {
            var dataNode = internalCache.get(k);
            if (dataNode == null)
                return false;
            moveNodeToFirst(dataNode);
            return true;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    private void moveNodeToFirst(LinkedNode<K, V> dataNode) {
        if (tail == dataNode) {
            tail = dataNode.prev;
        }
        dataNode.next = head;
        head.prev = dataNode;
        head = dataNode;
    }

    @Override
    public V delete(K k) {
        this.lock.writeLock().lock();
        try {
            tail.prev.next = null;
            tail = head.prev;
            return internalCache.remove(k).v;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public int size() {
        return this.internalCache.size();
    }

    class LinkedNode<K, V> {
        K k;
        V v;
        LinkedNode<K, V> prev;
        LinkedNode<K, V> next;

        public LinkedNode(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            String sb = (prev == null ? "" : "[" + prev.k + "]") +
                    "<-" + k + "->" +
                    (next == null ? "" : "[" + next.k + "]");
            return sb;
        }
    }
}
