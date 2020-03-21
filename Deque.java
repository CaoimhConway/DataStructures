/**
Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue.
 Double-ended queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends (either its front or its back).
 */

public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    T get(int i);
    int size();
    default boolean isEmpty() {
        return (size() == 0);
    }
    T removeFirst();
    T removeLast();
    void printDeque();
}
