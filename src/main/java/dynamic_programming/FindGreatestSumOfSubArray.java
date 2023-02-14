package dynamic_programming;

import java.util.Arrays;

/**
 * @Author Lujs
 * @Date 2022/10/4
 * 连续子数组的最大和(二)
 * 如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 在动态规划的基础上，再增加四个变量：（1）保存当前遍历位置子串首尾位置；（2）最大和子串首尾位置。
 * [1,-2,3,10,-4,7,2,-5]
 */
public class FindGreatestSumOfSubArray {
    public int[] findGreatestSumOfSubArray(int[] array) {
        //动态规划
        int result = array[0];
        int currentMax = array[0];
        //当前遍历位置子串首尾位置
        int start_tmp = 0; int end_tmp = 1;
        //最大的子串首尾位置
        int start = 0; int end = 1;
        if (array == null || array.length == 0){
            return null;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (currentMax+array[i] < array[i]){
                currentMax = array[i];
                start_tmp = i;
                end_tmp = i+1;
            }else {
                currentMax = currentMax+array[i];
                end_tmp++;
            }
            if (currentMax > result || (currentMax == result) && (end_tmp - start_tmp) > (end - start)){
                result = currentMax;
                start = start_tmp;
                end = end_tmp;
            }
        }
        return Arrays.copyOfRange(array,start,end);
    }
}
