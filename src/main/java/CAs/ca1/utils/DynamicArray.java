package CAs.ca1.utils;

public class DynamicArray {
    /**
     * This class has 3 private variables which it sets up initially
     * EXPANSION_MULTIPLIER the number the array will be expanded by
     * size is the current size of the array
     * data is the array itself, which starts at a max length of 10.
     */
    private static final int EXPANSION_MULTIPLIER = 2;
    private int size = 0;
    private String [] data = new String[10];

    private void ensureCapacity(){
        /**
         * This method ensures that the array has enough capacity to hold the new element.
         */
        if(size == data.length){
            String [] temp = new String[data.length*EXPANSION_MULTIPLIER];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
    }

    public int size(){
        /**
         * This method returns the current size of the array
         * @return int - current size of the array
         */
        return size;
    }

    public String get(int index){
        /**
         * This method returns the data at the given index position
         * @param int index - index position you want the data of
         * @throws IndexOutOfBoundsException - If index position is not in array
         * @return String - data at the given index position in the array
         */
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of array");
        }
        return data[index];
    }

    public int indexOf(String target){
        /**
         * This method returns the index position of the given target data
         * @param String target - The target data you want the index position of
         * @return int - Index position of the target data in the array
         */
        for (int i = 0; i < size; i++) {
            if(data[i].equalsIgnoreCase(target)){
                return i;
            }
        }

        return -1;
    }

    public void add(String value){
        /**
         * This method adds the given value to the end of the list
         * @param String value - The value to be added
         * @throws IllegalArgumentException - If value is null
         */
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        ensureCapacity();

        data[size] = value;
        size++;
    }

    private void validateIndex(int index){
        /**
         * This method validates an index position to ensure it is in the array
         * @param int index - The index position
         * @throws IndexOutOfBoundsException - If index position is not in array
         */
        if(index < 0 | index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of list");
        }
    }

    private void validateInsertIndex(int index){
        /**
         * This method also validates an index position, but allows the index to be the same as the size
         * This allows for insertions into an empty list
         * @param int index - The index position
         * @throws IndexOutOfBoundsException - If index position is not in array
         */
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of list");
        }
    }

    public void add(int index, String value){
        /**
         * This method adds the given value into a specific index position
         * @param int index - The index position you want to insert the value at
         * @param String Value - The value you want to add
         * @throws IllegalArgumentException - If value is null
         */
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        validateInsertIndex(index);

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

    public String remove(int index){
        validateIndex(index);
        String removedValue = data[index];
        System.arraycopy(data, index+1, data, index, (size-index-1));
        size--;
        return removedValue;
    }

    public int removeAll(String value){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
    
    public String[] deduplicate(){
        int size = 0;
        String [] dedup = new String[10];

        for (int i = 0; i < this.size; i++) {
            String value = this.get(i);

            boolean seen = false;

            for (int j = 0; j < size; j++) {
                if (dedup[j].equals(value)) {
                    seen = true;
                    break;
                }
            }

            if (!seen) {
                dedup[size] = value;
                size++;
            }
        }
        return dedup;
    }

    public void join(DynamicArray list){
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }
}