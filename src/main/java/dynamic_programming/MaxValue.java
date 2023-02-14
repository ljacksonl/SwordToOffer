package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/5
 * 礼物的最大价值
 */
public class MaxValue {
    //由于只能方向向右或者向下，因此第m行第n列的值只能来自于m-1行n列或者m行n-1列再加上grid[m][n],
    // 所以可知maxSum[i][j] = Math.max(maxSum[i - 1][j], maxSum[i][j - 1]) + grid[i - 1][j - 1];
    public int maxValue (int[][] grid) {
        int m = grid.length;int n = grid[0].length;
        int [][] maxSum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxSum[i][j] = Math.max(maxSum[i-1][j],maxSum[i][j-1]) + grid[i-1][j-1];
            }
        }
        return maxSum[m][n];
    }
}
