package stack;

import java.util.Stack;

/**
 * @Author Lujs
 * @Date 2022/9/24
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    //用于栈的push 与 pop
    Stack<Integer> data = new Stack<>();
    //用于存储最小min
    Stack<Integer> min = new Stack<>();

    public void push(int node){
        data.push(node);
        //空或者新元素较小，则入栈
        if (min.isEmpty() || min.peek() > node){
            min.push(node);
        }else {
            //重复加入栈顶
            min.push(min.peek());
        }
    }

    public void pop(){
        data.pop();
        min.pop();
    }

    public void peek(){
        data.peek();
    }
    public void min(){
        min.peek();
    }
}
