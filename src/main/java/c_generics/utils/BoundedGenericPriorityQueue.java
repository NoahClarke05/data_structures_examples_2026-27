package c_generics.utils;

public class BoundedGenericPriorityQueue<T extends Comparable<T>> extends GenericPriorityQueue<T>{
    private int maxSize = 10;

    public BoundedGenericPriorityQueue(int maxSize){
        this.maxSize = maxSize;
    }

    public void enqueue(T element){
        super.validateForNull(element);

        if(isFull()){
            throw new IllegalStateException("Cannot add to a full Queue");
        }

        super.enqueue(element);
    }

    public boolean isFull(){
        return super.size == maxSize;
    }
}
