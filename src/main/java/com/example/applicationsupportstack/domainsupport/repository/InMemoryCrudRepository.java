package com.example.applicationsupportstack.domainsupport.repository;

import com.example.applicationsupportstack.domainsupport.aggregate.AggregateRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.HashMap;
import java.util.Optional;

public abstract class InMemoryCrudRepository<K, V> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public HashMap<K, V> keyToValue = new HashMap<>();

    public void save(V value) {
        var key = getKey(value);
        var cloned = deepClone(value);
        keyToValue.put(key, cloned);

        if (value instanceof AggregateRoot) {
            var root = (AggregateRoot) value;
            for (var event : root.domainEvents()) {
                applicationEventPublisher.publishEvent(event);
            }
            root.clearDomainEvents();
        }
    }

    public Optional<V> find(K key) {
        if (!keyToValue.containsKey(key)) {
            return Optional.empty();
        }

        var target = keyToValue.get(key);
        var cloned = deepClone(target);

        return Optional.of(cloned);
    }

    public void delete(V value) {
        var key = getKey(value);
        keyToValue.remove(key);
    }

    protected abstract K getKey(V value);

    protected abstract V deepClone(V value);
}
