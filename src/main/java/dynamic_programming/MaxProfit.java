package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/4
 *  买卖股票的最好时机(一)
 *  就是查找数组中某两个元素差值的最大。
 *   [7, 1, 5, 3, 6, 4]
 */
public class MaxProfit {
    //贪心算法
    public int maxProfit (int[] prices) {
        int len = prices.length;
        int minPrices = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            //寻找最低点
            if (prices[i]< minPrices){
                minPrices = prices[i];
            }else if (prices[i] - minPrices > ans){
                //更新答案（最大利润）
                ans = prices[i] - minPrices;
            }
        }
        return ans;
    }
}
