package e_maps.utils;

import java.util.Objects;

public class mapUtils<K, V> {
    private final static int INITIAL_SIZE = 103;
    private Object[] map = new Object[INITIAL_SIZE];

    private int count = 0;

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        Objects.requireNonNull(key, "Key cannot be null");
        int slot = hashFunction(key);
        //adding when the slot is empty
        if (map[slot] == null) {
            Entry<K, V> newEntry = new Entry<>(key, value);
            map[slot] = newEntry;
            count++;
            return null;
        }
        //replacing if the slot already has data
        Entry<K, V> original = (Entry<K, V>) map[slot];

        if (!key.equals(original.key)) {
            throw new IllegalStateException("Key collision occurred");
        }

        V oldValue = original.value;
        original.value = value;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        Objects.requireNonNull(key);

        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }

        Entry<K, V> entry = (Entry<K, V>) map[slot];
        return entry.value;
    }

    public V remove(K key) {
        int slot = hashFunction(key);
        V removed = get(key);

        map[slot] = null;

        return removed;
    }

    public int count(){
        return count;
    }

    @SuppressWarnings("unchecked")
    public K[] getKeys(){
        Object [] keys = new Object[count];
        int keyCount = 0;

        int slotIndex = 0;
        while(keyCount != count && slotIndex < map.length){
            if(map[slotIndex] != null){
                Entry<K, V> currentEntry = (Entry<K, V>) map[slotIndex];
                K currentKey = currentEntry.key;
                keys[keyCount] = currentKey;
                keyCount++;
            }
            slotIndex++;
        }
        return (K[]) keys;
    }

    private int hashFunction (K key){
        Objects.requireNonNull(key, "Key cannot be null");

        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % map.length;

        return hash;
    }
}