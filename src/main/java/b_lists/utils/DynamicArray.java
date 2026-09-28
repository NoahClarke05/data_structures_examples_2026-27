package b_lists.utils;

public class DynamicArray {
    private static final int EXPANSION_MULTIPLIER = 2;
    private int size = 0;
    private int [] data = new int[10];

    private void ensureCapacity(){
        if(size == data.length){
            int [] temp = new int[data.length*EXPANSION_MULTIPLIER];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
    }

    public void add(int value){
        ensureCapacity();

        data[size] = value;
        size++;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of array");
        }
        return data[index];
    }

    public int size(){
        return size;
    }

    public int indexOf(int target){
        for (int i = 0; i < size; i++) {
            if(data[i] == target){
                return i;
            }
        }

        return -1;
    }
}
