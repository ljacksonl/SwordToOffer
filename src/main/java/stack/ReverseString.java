package stack;

import java.util.Stack;

/**
 * @Author Lujs
 * @Date 2022/9/24
 * 翻转输出句子，例如“I am a student.”反转后输出“student. a am I”
 */
public class ReverseString {
    public String reverseSentence(String str){
        String[] s = str.split(" ");
        Stack<String> a = new Stack<>();
        //单词加入栈中
        for (int i = 0; i < s.length; i++) {
            a.push(s[i]);
        }
        StringBuilder splitString = new StringBuilder();
        splitString.append(a.pop() + " ");
        return splitString.toString().trim();
    }
}
