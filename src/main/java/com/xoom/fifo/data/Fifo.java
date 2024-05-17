package com.xoom.fifo.data;

public interface Fifo<T> {

    T pop();
    void push(T value);
    int count();
    boolean isEmpty();
    void clear();
    void print();
}
