package b_lists.utils;


public class LinkBasedQueue<E>{
    private Node<E> first;
    private Node<E> last;

    private int numElements;

    private static class Node<E>{
        private E data;
        private LinkBasedQueue.Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkBasedQueue() {
        first = null;
        last = null;
    }
    public void enqueue(E element) {
        Node<E> newNode = new Node<E> (element);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        numElements++;
    }


    public E dequeue() {
        if(isEmpty()){
            throw new QueueEmptyException("Queue is empty");
        }else{
            E data = first.data;
            first = first.next;
            numElements--;
            if(numElements == 0) {
                last = null;
            }
            return data;
        }
    }
    public int size() {
        return numElements;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public E peek(){
        if(isEmpty()){
            throw new QueueEmptyException("Queue is empty");
        }
        return first.data;
    }

}
