package org.example.lru;

import java.util.Optional;

public interface Cache<K, V> {
    void put(K k, V v);

    Optional<V> get(K k);

    boolean has(K k);

    V delete(K k);

    int size();
}
