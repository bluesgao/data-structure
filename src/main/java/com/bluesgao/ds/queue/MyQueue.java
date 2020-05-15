package com.bluesgao.ds.queue;

import java.util.Stack;

/**
 * 用2个栈实现队列功能
 */
class MyQueue {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("---------1-------");

        MyQueue q = new MyQueue();
        for (int i = 0; i < 10; i++) {
            q.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(q.pop());
        }

        System.out.println("----------------");
    }
}