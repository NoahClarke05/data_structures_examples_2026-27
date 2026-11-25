package c_generics.apps;

import c_generics.utils.GenericPriorityQueue;

import java.util.Random;

public class TestGenericPriorityQueueWithStrings {
    static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random randomGenerator = new Random();
        GenericPriorityQueue<String> stringQueue = new GenericPriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            stringQueue.enqueue(i + "");
        }

        displayQueue(stringQueue);
        System.out.println("Now filling with random data");

        // Fill with random values

        for (int i = 0; i < 10; i++) {
            stringQueue.enqueue(alphabet.charAt(randomGenerator.nextInt(26)) + "");
        }

        displayQueue(stringQueue);
    }

    private static void displayQueue(GenericPriorityQueue<String> intQueue) {
        while(!intQueue.isEmpty()) {
            String value = intQueue.dequeue();
            System.out.println("Next element: " + value);
        }
    }
}
