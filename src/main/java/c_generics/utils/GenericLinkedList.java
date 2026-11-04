package c_generics.utils;

public class GenericLinkedList<T> {
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

    //add to the end
    public void add(T element){
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

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //add in the middle
    public void add(T element, int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node<T> newNode = new Node<>(element);
        if(index==0){
            if (!isEmpty()){
                newNode.next = first;
            }else{
                last = newNode;
            }

            first = newNode;
        }else {

            Node<T> prev = null;
            Node<T> current = first;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            newNode.next = current;
            prev.next = newNode;
        }
        size++;
    }

    public int indexOf(T target){
        validateForNull(target);

        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(target)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public void validateForNull(T target){
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node<T> prev = null;
        Node<T> current = first;

        if(index == 0){
            first = current.next;

        }else{
            for (int i = 0; i < index; i++) {
                T removed = current.data;
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
        }
        size--;
    }

    public boolean remove(T target) {
        validateForNull(target);
        int index = indexOf(target);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }
}
