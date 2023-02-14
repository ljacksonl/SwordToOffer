package other_algorithms;

import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/27
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstCharNotDuplicated {
    private StringBuilder s = new StringBuilder();
    private HashMap<Character,Integer> mp = new HashMap<>();
    public void Insert(char ch){
        s.append(ch);
        mp.put(ch,mp.getOrDefault(ch,0)+1);
    }
    public char FirstAppearingOnce(){
        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return '#';
    }
}
