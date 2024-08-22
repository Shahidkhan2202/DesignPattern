package org.example;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    // Constructor
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation
    void push(int x) {
        // Always enqueue to q1
        q1.add(x);
    }

    // Pop operation
    int pop() {
        if (q1.isEmpty()) {
            return -1;  // Stack is empty
        }

        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // The last element is the one to be popped (top of stack)
        int poppedElement = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        stack.push(4);
        System.out.println(stack.pop());  // Output: 4
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.pop());  // Output: -1
    }
}
