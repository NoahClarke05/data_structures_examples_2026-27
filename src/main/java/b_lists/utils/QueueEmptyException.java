package b_lists.utils;

public class QueueEmptyException extends IllegalArgumentException{
    public QueueEmptyException(String message){
        super(message);
    }
}
