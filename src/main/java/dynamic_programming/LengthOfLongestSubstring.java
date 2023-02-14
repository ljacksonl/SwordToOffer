package dynamic_programming;

import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/5
 *  最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring (String s) {
        //记录窗口内非重复的字符及其下标
        HashMap<Character, Integer> mp = new HashMap<>();
        //统计 最长不含重复字符的子字符串的长度
        int res = 0;
        //dp[i]表示以下标i结尾的字符串最长不含重复子串的长度
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 1;
            //哈希表中没有，说明不重复
            if (!mp.containsKey(s.charAt(i-1))){
                //前一个加1
                dp[i] = dp[i -1] + 1;
            }else {
                //遇到重复字符
                // 计算当前字符与上一次出现时的距离
                //如果map中存在当前的元素，一开始的想法是 dp[i]=i-map.get(array[i]),
                // 但是这样想有点问题，如果当前的字符串是abba的时候,按照刚才的思路dp[0]=1 dp[1]=2 dp[2]=1 dp[3]=3
                //但是dp[3]是错误的，因为中间存在了重复的字符。所以要加一种情况。
                dp[i] = Math.min(dp[i - 1] + 1, i - mp.get(s.charAt(i - 1)));
            }
            //加入哈希表
            mp.put(s.charAt(i -1),i);
            //维护最大值
            res = Math.max(res,dp[i]);
        }
        return  res;
    }
}
