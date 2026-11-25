package c_generics.apps;

import c_generics.utils.GenericPriorityQueue;

import java.util.Random;

public class TestGenericPriorityQueueWithInts {
    static void main(String[] args) {
        Random randomGenerator = new Random();
        GenericPriorityQueue<Integer> intQueue = new GenericPriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            intQueue.enqueue(i);
        }

        displayQueue(intQueue);
        System.out.println("Now filling with random data");

        // Fill with random values

        for (int i = 0; i < 10; i++) {
            intQueue.enqueue(randomGenerator.nextInt(100));
        }

        displayQueue(intQueue);
    }

    private static void displayQueue(GenericPriorityQueue<Integer> intQueue) {
        while(!intQueue.isEmpty()) {
            int value = intQueue.dequeue();
            System.out.println("Next element: " + value);
        }
    }
}
