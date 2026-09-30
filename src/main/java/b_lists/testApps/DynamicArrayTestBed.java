package b_lists.testApps;

import b_lists.utils.DynamicArray;

import java.util.Random;

public class DynamicArrayTestBed {
    static void main(String[] args) {
        DynamicArray myList = new DynamicArray();
        Random rg = new Random();

        for (int i = 0; i < 10; i++) {
            myList.add(rg.nextInt(100));
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        int removed = myList.remove(10);
        System.out.println("Value removed: " + removed);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }

}
