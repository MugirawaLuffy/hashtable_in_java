package org.example;

public interface ExtractKey<S,T> {
    public T extract(S data);
}
