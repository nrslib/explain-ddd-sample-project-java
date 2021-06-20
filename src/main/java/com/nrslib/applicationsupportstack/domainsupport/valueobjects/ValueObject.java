package com.nrslib.applicationsupportstack.domainsupport.valueobjects;

import lombok.Getter;

import java.util.Objects;

public abstract class ValueObject<T> {
    @Getter
    private final T value;

    public ValueObject(T value) {
        Objects.requireNonNull(value);

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
