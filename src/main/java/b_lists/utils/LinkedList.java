package b_lists.utils;

public class LinkedList {
    private Node first;
    private int size;

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(String element){
        Node newNode = new Node(element);
        if(size == 0){
            first = newNode;
        }else {

            Node current = first;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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

    public void add(String element, int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds");
        }
        Node newNode = new Node(element);
        if(index==0){
            if (first != null){
                newNode.next = first;
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
}
