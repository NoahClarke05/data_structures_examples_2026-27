package c_generics.utils;

public class GenericPriorityQueue<T extends Comparable<T>> extends GenericQueue<T>{
    public void enqueue(T element){
        super.validateForNull(element);

        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else if(newNode.data.compareTo(first.data) < 0){
            newNode.next = first;
            first = newNode;
        }else if(newNode.data.compareTo(last.data) >= 0){
            last.next = newNode;
            last = newNode;
        }else{
            Node<T> current = first.next;
            Node<T> prev = first;

            // While we aren't at the last node, move on and check
            while(current.next != null){
                // If we find something smaller than us
                if(newNode.data.compareTo(current.data) < 0){
                    // Add the new element here
                    newNode.next = current;
                    prev.next = newNode;
                    // Stop looking for where to put it
                    break;
                }else {
                    // Otherwise move to next node in queue
                    prev = current;
                    current = current.next;
                }
            }
        }
        // We have put the new element into queue (it will always go somewhere,
        // whether that's the start, middle or end.
        // Increase size to reflect that there's an extra element there
        size++;
    }
}
