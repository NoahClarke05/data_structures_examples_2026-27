package b_lists.utils;

import java.util.NoSuchElementException;

public class GenericQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(T element){
        validateForNull(element);

        Node<T> newNode = new Node<>(element);

        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException("Cannot peek at empty Queue");
        }

        return first.data;
    }

    public T dequeue(){
        if(first == null){
            throw new NoSuchElementException("Cannot remove from empty Queue");
        }

        T removed = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }

        size--;
        return removed;
    }

    private void validateForNull(T target) {
        if(target == null){
            throw new IllegalArgumentException("Nulls are not permitted in the Queue");
        }
    }
}
