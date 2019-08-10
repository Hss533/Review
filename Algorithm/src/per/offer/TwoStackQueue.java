package per.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 在入队的时候，要保证stack2是空的
 * 在出队的时候，要保证stack1是空的
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());//是为了清空stack
        }
        return result;
    }

    public static void main(String[] args) {

        TwoStackQueue test = new TwoStackQueue();
        for (int i = 1; i < 10; i++)
            test.push(i);
        for (int i = 1; i < 10; i++)
            System.out.println(test.pop());
    }
}
