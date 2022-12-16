package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hashtable<S,T> {
    private final HashingMethod<T> hashMethod;
    private final ExtractKey<S,T> extractMethod;
    private final S[] table;
    private final int length;

    public Hashtable(int size, Class<S> c, HashingMethod<T> hashMethod, ExtractKey<S,T> extract) {

        @SuppressWarnings("unchecked")
        final S[] a = (S[]) Array.newInstance(c, size);
        this.table = a;
        this.length=size;
        this.hashMethod = hashMethod;
        this.extractMethod = extract;
    }
    public int performHash(T key) {
        return hashMethod.hash(key) % this.length;
    }

    public boolean insert(S data) {
        int index = performHash(this.extractMethod.extract(data));
        if(this.table[index] == null) {
            this.table[index] = data;
            return true;
        }
        //handle collision
        return false;
    }
    public S get(T key) {
        return table[this.performHash(key)];
    }

    public S remove(T key) {
        int index = this.performHash(key);
        S tmp = table[index];
        table[index] = null;
        return tmp;
    }

    public void print() {
        for(int i = 0; i < length; i++) {
            if(table[i] == null) System.out.println("" + i + ":\tNULL");
            else System.out.println("" + i + ":\t" + table[i].toString());
        }
    }
}
