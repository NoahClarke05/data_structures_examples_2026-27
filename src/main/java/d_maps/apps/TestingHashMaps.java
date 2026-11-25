package d_maps.apps;

import d_maps.utils.HashMap;

public class TestingHashMaps {
    static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(i, "String " + i);
        }

        System.out.println("Display map contents:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Key: " + i + ", Value = " + map.get(i));
        }
    }
}
