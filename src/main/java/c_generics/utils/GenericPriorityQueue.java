package c_generics.utils;

import c_generics.utils.GenericQueue;

public class GenericPriorityQueue<T extends Comparable<T>> extends GenericQueue<T> {

    public void enqueue(T element) {
        validateForNull(element);

        GenericQueue.Node<T> current = first;
        GenericQueue.Node<T> prev = null;

        Node<T> newNode = new Node<>(element);

        if (element.compareTo(first.data) < 0) {

            if(isEmpty()){
                first = newNode;
                last = newNode;
            }else {
                newNode.next = first;
                first = newNode;
            }
            size++;
        }

        if (element.compareTo(last.data) >= 0) {

            last.next = newNode;
            last = newNode;

            size++;
        }

        while(current.next != null) {
            if(newNode.data.compareTo(current.data) < 0){
                newNode.next = current;
                prev.next = newNode;
                break;
            }else {
                prev = current;
                current = current.next;
            }
        }
        size++;
    }
}
