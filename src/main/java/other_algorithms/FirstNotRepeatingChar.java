package other_algorithms;

import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/15
 * 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        //统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            mp.put(str.charAt(i),mp.getOrDefault(str.charAt(i),0) + 1);
        }
        //判断第一个只出现一次的字符
        for (int i = 0; i < str.length(); i++) {
            if (mp.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
