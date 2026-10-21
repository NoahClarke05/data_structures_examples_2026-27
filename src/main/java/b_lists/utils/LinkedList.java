package b_lists.utils;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    //add to the end
    public void add(String element){
        Node newNode = new Node(element);
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

    public String get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //add in the middle
    public void add(String element, int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node newNode = new Node(element);
        if(index==0){
            if (!isEmpty()){
                newNode.next = first;
            }else{
                last = newNode;
            }

            first = newNode;
        }else {

            Node prev = null;
            Node current = first;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            newNode.next = current;
            prev.next = newNode;
        }
        size++;
    }

    public int indexOf(String target){
        validateForNull(target);

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(target)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public static void validateForNull(String target){
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node prev = null;
        Node current = first;

        if(index == 0){
            first = current.next;

        }else{
            for (int i = 0; i < index; i++) {
                String removed = current.data;
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
        }
        size--;
    }

    public boolean remove(String target) {
        validateForNull(target);
        int index = indexOf(target);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }
}
