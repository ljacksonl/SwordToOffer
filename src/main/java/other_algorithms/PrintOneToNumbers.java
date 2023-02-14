package other_algorithms;

/**
 * @Author Lujs
 * @Date 2022/10/15
 *  打印从1到最大的n位数
 *  按照顺序从1输出到最大的十进制n位数
 */
public class PrintOneToNumbers {
    public int[] printOneToNumbers(int n){
        //既然是从1开始顺序输出到nnn位数的最大值，一般来说n位数最大就是n个9
        //这样不方便于计算  直接输出到10^n - 1即可
        //找到该n+1位数的最小数字
        int end = 1;
        for (int i = 0; i <= n; i++) {
            end *= 10;
        }
        //从1遍历到n+1位数的最小数字输出
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
