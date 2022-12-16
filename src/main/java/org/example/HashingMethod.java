package org.example;

@FunctionalInterface
public interface HashingMethod<T> {
    int hash(T key);
}

