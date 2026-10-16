package CAs.ca1.testApps;

import CAs.ca1.utils.DynamicArray;

public class DynamicArrayTestBed {
    public static void main(String[] args) {
        DynamicArray myList = new DynamicArray();

        String[] values = {"Apple", "Banana", "Cherry", "Date"};
        for (String value : values) {
            myList.add(value);
        }

        printList("Initial list", myList);

        System.out.println("----------------------------------");
        System.out.println("Adding \"Grape\" at position 1");
        myList.add(1, "Grape");
        printList("After add(int index, String value)", myList);

        System.out.println("----------------------------------");
        System.out.println("size(): " + myList.size());
        System.out.println("get(2): " + myList.get(2));
        System.out.println("indexOf(\"Date\"): " + myList.indexOf("Date"));

        System.out.println("----------------------------------");
        System.out.println("set(3, \"Elderberry\"): " + myList.set(3, "Elderberry"));
        printList("After set(index, value)", myList);

        System.out.println("----------------------------------");
        System.out.println("Removing item at position 0");
        myList.remove(0);
        printList("After remove(index)", myList);

        System.out.println("----------------------------------");
        myList.add("Banana");
        myList.add("Banana");
        printList("Before removeAll(\"Banana\")", myList);
        System.out.println("removeAll(\"Banana\"): " + myList.removeAll("Banana"));
        printList("After removeAll(value)", myList);

        System.out.println("----------------------------------");
        DynamicArray otherList = new DynamicArray();
        otherList.add("Fig");
        otherList.add("Grape");
        otherList.add("Honeydew");
        System.out.println("Joining another list into the current one");
        myList.join(otherList);
        printList("After join(otherList)", myList);

        System.out.println("----------------------------------");
        System.out.println("Clearing the list");
        myList.clear();
        printList("After clear()", myList);

        System.out.println("----------------------------------");
        myList.add("Alpha");
        myList.add("Alpha");
        myList.add("Bravo");
        myList.add("Bravo");
        myList.add("Charlie");
        printList("Before deduplicate()", myList);
        printArray("After deduplicate()", myList.deduplicate());
    }

    private static void printList(String label, DynamicArray list) {
        System.out.print(label + ": [");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
        System.out.println("]");
    }

    private static void printArray(String label, String[] values) {
        System.out.print(label + ": [");
        boolean first = true;
        for (String value : values) {
            if (value == null) {
                continue;
            }
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(value);
            first = false;
        }
        System.out.println("]");
    }
}
