/**
 *
 This is an implementation of a Double Ended Queue (Deque) using linked lists.

 **/

public class LinkedListDeque<T> implements Deque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        IntNode(T i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;


    /**
     * Creates an empty LinkedListDeque
     */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** Creates a deep copy of other */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode(null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        for (int c = 0; c < other.size(); c++) {
            this.addLast((T) other.get(c));
        }

    }



    /**
     * Adds an item to the front of the list.
     */
    @Override
    public void addFirst(T x) {
        sentinel.next = new IntNode(x, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        if (size == 0) {
            sentinel.prev = sentinel.next;
        }
        size += 1;
    }

    /**
     * Adds an item to the end of the list.
     */
    @Override
    public void addLast(T x) {
        size += 1;
        IntNode p = sentinel.prev;
        sentinel.prev = new IntNode(x, sentinel);
        sentinel.prev.prev = p;
        sentinel.prev.prev.next = sentinel.prev;
    }

    /**
     * Retrieves the front item from the list.
     */

    public T getFirst() {
        return sentinel.next.item;
    }

    /**
     * Returns the item at index i, where 0 is the first item
     */
    @Override
    public T get(int i) {
        IntNode p = sentinel;
        for (int c = 0; c <= i; c++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int i) {
        IntNode p = sentinel.next;
        return helperGetRecursive(p, i);
    }

    private T helperGetRecursive(IntNode p, int i) {
        if (i == 0) {
            return p.item;
        }
        if (p == sentinel) {
            return null;
        }
        return helperGetRecursive(p.next, (i - 1));
    }


    /**
     * Returns the number of items in the list using a cache.
     */
    @Override
    public int size() {
        return size;
    }



    @Override
    public T removeFirst() {
        if (!this.isEmpty()) {
            T p = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return p;
        }
        return null;
    }
    @Override
    public T removeLast() {
        if (!this.isEmpty()) {
            T p = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return p;
        }
        return null;
    }

    @Override
    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            System.out.println(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }




}
