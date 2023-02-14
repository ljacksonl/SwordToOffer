package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/4
 * 连续子数组的最大和
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 * [1,-2,3,10,-4,7,2,-5] 返回 8
 */
public class BiggestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int result = 0;
        int currentMax = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            currentMax = Math.max(currentMax+array[i],array[i]);
            result = Math.max(result + currentMax,result);
        }
        return result;
    }
}
