package stack;

import java.util.Stack;

/**
 * @Author Lujs
 * @Date 2022/9/24
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *  例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *  （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int n = pushA.length;
        //辅助栈
        Stack<Integer> s = new Stack<>();
        //遍历入栈的下标
        int j = 0;
        //遍历出栈的数组
        for (int i = 0; i < n; i++) {
            //入栈：栈为空或者栈顶不等于出栈数组
            while (s.isEmpty() || s.peek() != popA[i]){
                s.push(pushA[j]);
                j++;
            }
            //栈顶等于出栈数组
            if (s.peek() == popA[i]){
                s.pop();
            }

        }
        return s.isEmpty();
    }
}
