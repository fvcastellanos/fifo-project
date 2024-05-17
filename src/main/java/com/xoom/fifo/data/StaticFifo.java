package com.xoom.fifo.data;

import java.util.Arrays;

public class StaticFifo<T> implements Fifo<T> {

    private static final int DEFAULT_SIZE = 10;
    private static final int ROOT_INDEX = 0;

    private int index;

    private Object[] container;

    public StaticFifo(int size) {

        index = 0;
        container = new Object[size];
    }

    public StaticFifo() {

        index = 0;
        container = new Object[DEFAULT_SIZE];
    }

    @Override
    public T pop() {

        if (isEmpty()) {

            throw new RuntimeException("Array is empty");
        }

        var value = container[ROOT_INDEX];

        var newContainer = new Object[container.length];

        System.arraycopy(container, ROOT_INDEX + 1, newContainer, ROOT_INDEX, index);

        container = newContainer;
        index--;

        return (T) value;
    }

    @Override
    public void push(T value) {

        if (index == container.length) {

            throw new RuntimeException("Not enough slots");
        }

        container[index] = value;
        index++;
    }

    @Override
    public int count() {
        return index - ROOT_INDEX;
    }

    @Override
    public boolean isEmpty() {

        return index - ROOT_INDEX == 0;
    }

    @Override
    public void clear() {

        index = 0;
    }

    @Override
    public void print() {
        System.out.print("[ ");

        Arrays.stream(container)
                .forEach(item -> System.out.print(item + ", "));

        System.out.println(" ]");
    }
}
