package d_maps.utils;

import java.util.Objects;

public class HashMap<K, V> {
    private final static int INITIAL_SIZE = 103;
    private Object [] map = new Object[INITIAL_SIZE];

    private int count = 0;

    private static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value){
        Objects.requireNonNull(key, "Key cannot be null");
        int slot = hashFunction(key);
        if(map[slot] == null) {
            Entry<K, V> newEntry = new Entry<>(key, value);
            map[slot] = newEntry;
            count++;
            return null;
        }
        Entry<K, V> original = (Entry<K, V>) map[slot];

        if(!key.equals(original.key)){
            throw new IllegalStateException("Key collision occurred");
        }

        V oldValue = original.value;
        original.value = value;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public V get(K key){
        Objects.requireNonNull(key, "Key cannot be null");

        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }

        Entry<K, V> entry = (Entry<K, V>) map[slot];
        return entry.value;
    }

    public int count(){
        return count;
    }

    private int hashFunction(K key){
        Objects.requireNonNull(key, "Key cannot be null");

        int hash = key.hashCode();
        hash = Math.abs(hash);

        return hash;
    }
}
