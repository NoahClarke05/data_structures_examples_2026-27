package CAs.ca1.utils;

public class DynamicArrayString {
    private static final int EXPANSION_MULTIPLIER = 2;
    private int size = 0;
    private String [] data = new String[10];

    private void ensureCapacity(){
        if(size == data.length){
            String [] temp = new String[data.length*EXPANSION_MULTIPLIER];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
    }

    public int size(){
        return size;
    }

    public String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of array");
        }
        return data[index];
    }

    public int indexOf(String target){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(target)){
                return i;
            }
        }

        return -1;
    }

    public void add(String value){
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        ensureCapacity();

        data[size] = value;
        size++;
    }

    private void validateIndex(int index){
        if(index < 0 | index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of list");
        }
    }

    public void add(int index, String value){
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        validateIndex(index);

        ensureCapacity();

        System.arraycopy(data, index, data, index+1, (size-index));

        data[index] = value;
        size++;
    }

    public String set(int index, String value){
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        validateIndex(index);

        String prev_value = data[index];

        data[index] = value;

        return prev_value;
    }
}
