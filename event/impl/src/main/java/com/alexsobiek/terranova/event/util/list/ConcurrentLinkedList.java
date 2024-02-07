package com.alexsobiek.terranova.event.util.list;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConcurrentLinkedList<T> {
    private volatile boolean mutex = false;
    private Node<T> head;

    /**
     * Constructor
     */
    public ConcurrentLinkedList() {
    }

    /**
     * Constructor
     * @param head Initial head node
     */
    public ConcurrentLinkedList(Node<T> head) {
        this.head = head;
    }

    private void acquire() {
        while (mutex) Thread.onSpinWait(); // block until mutex is released
        mutex = true;
    }

    private void release() {
        mutex = false;
    }

    private CLLIterator<T> unsafeIterator() {
        return new CLLIterator<>(head);
    }

    /**
     * Loops through each element in the list and calls the consumer
     * @param forEachConsumer Consumer to call
     */
    private void forEachUnsafe(BiConsumer<Runnable, Node<T>> forEachConsumer) {
        CLLIterator<T> iterator = unsafeIterator();
        while (iterator.hasNext()) {
            Node<T> current = iterator.next();
            forEachConsumer.accept(iterator::doBreak, current);
        }
    }

    private Node<T> last() {
        acquire();
        Node<T> current = head;
        while(current.next() != null) current = current.next();
        release();
        return current;
    }

    private void addUnsafe(T value) {
        if (head != null) {
            Node<T> last = last();
            Node<T> newNode = new Node<>(value);
            newNode.previous(last);
            last.next(newNode);
        }
        else head = new Node<>(value);
    }

    /**
     * Adds a value to the linked list
     * @param value Value to add
     * @return LinkedList
     */
    public ConcurrentLinkedList<T> add(T value) {
        acquire();
        addUnsafe(value);
        release();
        return this;
    }

    /**
     * Adds a value before a specified value
     * @param value Value to add
     * @param before Value to add before
     * @return LinkedList
     */
    public ConcurrentLinkedList<T> addBefore(T value, T before) {
        acquire();
        forEachUnsafe((breakFn, current) -> {
            if (current.data().equals(before)) {
                Node<T> newNode = new Node<>(value);
                newNode.next(current);
                newNode.previous(current.previous());
                current.previous(newNode);
                breakFn.run(); // break
            }
        });
        release();
        return this;
    }

    /**
     * Adds a value before a specified value
     * @param value Value to add
     * @param predicate Predicate to test
     * @return LinkedList
     */
    public ConcurrentLinkedList<T> addBefore(T value, Predicate<T> predicate) {
        acquire();
        Node<T> current = head;
        while(current.next() != null) {
            if (predicate.test(current.data())) {
                Node<T> newNode = new Node<>(value);
                newNode.next(current);
                newNode.previous(current.previous());
                current.previous(newNode);
                return this;
            }
            current = current.next();
        }
        addUnsafe(value); // add to the end if predicate is not met
        release();
        return this;
    }

    /**
     * Adds a value after a specified value
     * @param value Value to add
     * @param after Value to add after
     * @return LinkedList
     */
    public ConcurrentLinkedList<T> addAfter(T value, T after) {
        acquire();
        forEachUnsafe((breakFn, current) -> {
            if (current.data().equals(after)) {
                Node<T> newNode = new Node<>(value);
                newNode.next(current.next());
                newNode.previous(current);
                current.next(newNode);
                breakFn.run(); // break
            }
        });
        release();
        return this;
    }

    /**
     * Adds a value after a specified value
     * @param value Value to add
     * @param predicate Predicate to test
     * @return LinkedList
     */
    public ConcurrentLinkedList<T> addAfter(T value, Predicate<T> predicate) {
        acquire();
        forEachUnsafe((breakFn, current) -> {
            if (predicate.test(current.data())) {
                Node<T> newNode = new Node<>(value);
                newNode.next(current.next());
                newNode.previous(current);
                current.next(newNode);
                breakFn.run(); // break
            }
        });
        addUnsafe(value); // add to the end if predicate is not met
        release();
        return this;
    }

    /**
     * Peeks the last element in the queue
     * @return T
     */
    public T peek() {
        acquire();
        T data =  last().data();
        release();
        return data;
    }

    /**
     * Loops through each element in the list and calls the consumer
     * @param forEachConsumer Consumer to call
     */
    public void forEach(Consumer<T> forEachConsumer) {
        acquire();
        forEachUnsafe((ignored, n) -> forEachConsumer.accept(n.data()));
        release();
    }

    /**
     * Removes all elements matching the predicate
     * @param predicate Predicate to test
     */
    public void removeIf(Predicate<T> predicate) {
        acquire();
        forEachUnsafe((breakFn, current) -> {
            if (predicate.test(current.data())) {
                // check if this is the head
                if (current == head) {
                    head = current.next();
                    if (head != null) head.previous(null);
                } else {
                    if (current.previous() != null) current.previous().next(current.next());
                    if (current.next() != null) current.next().previous(current.previous());
                }
            }
        });
        release();
    }

    public void remove(T value) {
        this.removeIf(t -> t.equals(value));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        acquire();
        // TODO: use forEachUnsafe here!
        Node<T> current = head;
        while(current.next() != null) {
            builder.append(current.data()).append(", ");
            current = current.next();
        }
        builder.append(current.data()).append("]");
        release();
        return builder.toString();
    }

    private static class CLLIterator<T> implements Iterator<Node<T>> {
        private Node<T> current = new Node<>(null); // create a dummy node
        private boolean broken = false;

        public CLLIterator(Node<T> head) {
            this.current.next(head);
        }

        public void doBreak() {
            this.broken = true;
        }

        @Override
        public boolean hasNext() {
            return !broken && current != null && current.next() != null;
        }

        @Override
        public Node<T> next() {
            return current = current.next();
        }
    }
}
