package stack;

import java.util.Stack;

/**
 * @Author Lujs
 * @Date 2022/9/12
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStacksAsQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node){
            stack1.push(node);
        }

        public int pop(){
            if (stack1.isEmpty()&&stack2.isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
}
