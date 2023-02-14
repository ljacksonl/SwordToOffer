package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/4
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorsII {
    //对于最后一级台阶，我们可以由倒数第二级台阶跳1步，也可以由倒数第三级太极跳两步，
    // 即f(n)=f(n−1)+f(n−2)+...+f(n−(n−1))+f(n−n)
    // =f(0)+f(1)+f(2)+...+f(n−1)f(n)
    // =f(n-1)+f(n-2)+...+f(n-(n-1))+f(n-n)=f(0)+f(1)+f(2)+...+f(n-1)f(n)
    // =f(n−1)+f(n−2)+...+f(n−(n−1))+f(n−n)=f(0)+f(1)+f(2)+...+f(n−1)，
    // 因为f(n−1)=f(n−2)+f(n−3)+...+f((n−1)−(n−2))+f((n−1)−(n−1))f(n-1)
    // =f(n-2)+f(n-3)+...+f((n-1)-(n-2))+f((n-1)-(n-1))f(n−1)
    // =f(n−2)+f(n−3)+...+f((n−1)−(n−2))+f((n−1)−(n−1))，
    // 经整理得f(n)=f(n−1)+f(n−1)=2∗f(n−1)f(n)=f(n-1)+f(n-1)=2*f(n-1)f(n)=f(n−1)+f(n−1)=2∗f(n−1)，因此每级台阶方案数是前面一级台阶方案数的2倍。
    public int jumpFloorII(int target) {
        int[] dp = new int[target + 1];
        //初始化前面两个
        dp[0] = 1;
        dp[1] = 1;
        //依次乘2
        for (int i = 0; i <= target; i++) {
            dp[i] = 2 * dp[i -1];
        }
        return dp[target];
    }
}
