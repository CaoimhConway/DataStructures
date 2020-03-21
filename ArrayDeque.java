/**
 *
 This is an implementation of a Double Ended Queue (Deque) using arrays

 **/

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.size];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        for (int c = 0; c < other.size; c++) {
            this.addLast((T) other.get(c));
        }
    }


    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            a[i] = items[increment(nextFirst)];
            nextFirst = increment(nextFirst);
        }
        nextFirst = (a.length - 1);
        nextLast = size;
        items = a;
    }

    private void checkResize(int sizeCheck, int itemsLength) {
        if (itemsLength > 16) {
            if (((float) sizeCheck / itemsLength) < .25) {
                resize(itemsLength / 2);
            }
        }
        if (sizeCheck == itemsLength) {
            resize(size * 2);
        }

    }
    private int increment(int num) {
        num = ((num + 1) % items.length);
        return num;
    }

    private int decrement(int num) {
        num = (Math.floorMod((num - 1), items.length));
        return num;
    }

    @Override
    public void addLast(T x) {
        checkResize(size, items.length);
        items[nextLast] = x;
        size += 1;
        nextLast = increment(nextLast);
    }

    @Override
    public void addFirst(T x) {
        checkResize(size, items.length);
        size += 1;
        items[nextFirst] = x;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1; //change this
        }

    }

    @Override
    public T get(int i) {
        return items[increment(nextFirst + i)]; //change this
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T x = items[increment(nextFirst)]; // mod arith
        items[increment(nextFirst)] = null;
        if (size > 0) {
            size -= 1;
        }
        nextFirst = increment(nextFirst);
        checkResize(size, items.length);
        return x;
    }
    @Override
    public T removeLast() {
        T x = items[decrement(nextLast)]; //mod arithmetic
        items[decrement(nextLast)] = null;
        if (size > 0) {
            size -= 1;
        }
        nextLast = decrement(nextLast); //check this
        checkResize(size, items.length);
        return x;
    }



    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }


}
