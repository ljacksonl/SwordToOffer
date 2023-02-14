package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/6
 * 把数字翻译成字符串
 * 一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 现在给一串数字，返回有多少种可能的译码结果
 */
public class IntTransformString {
    //其实有点像简化成“跳台阶”问题，就是可以是一步或者两步，只不过需要加些条件来处理而已
    public int solve (String nums) {
        //0-9, 0的情况
        //dp[i]表示以nums[i]结尾的字符串的译码结果的个数
        int[] dp = new int[nums.length()];
        //初始化
        dp[0] = nums.charAt(0) == '0' ? 0 : 1;
        if (nums.length() == 1){
            return dp[0];
        }
        //加一位数
        if (nums.charAt(1) != '0'){
            dp[1] = dp[0];
        }
        int a = Integer.parseInt("" + nums.charAt(0) + nums.charAt(1));
        //一个两位数
        if (a >= 10 && a <= 26){
            dp[1] ++;
        }
        for (int i = 2; i < nums.length(); i++) {
            if (nums.charAt(i) == '0'){
                if (nums.charAt(i - 1) == '0'){
                    return 0;
                }else if (nums.charAt(i - 1) > '2'){
                    return 0;
                }else {
                    return dp[i] = 0; //10 或者 20的情况
                }
            }else {
                dp[i] = dp[i -1];
            }
            int tmp = Integer.parseInt("" + nums.charAt(i - 1) + nums.charAt(i));
            if (tmp >= 10 && tmp <= 26){
                dp[i] = dp[i] + dp[i -2];
            }
        }
        return dp[nums.length() -1];
    }
}
