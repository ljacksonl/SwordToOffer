package other_algorithms;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/10/26
 * 和为S的两个数字
 * 升序数组中找到和为S的两个数字
 * 输入一个递增排序的数组和一个数字sum，在数组中查找两个数，使得他们的和正好是sum，如果有多对数字的和等于sum，即随机输出一个。
 */
public class SumOfTwoIntsInArray {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        //升序数组
        //双指针
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            //相加等于sum，找到目标
            if (array[left] + array[right] == sum) {
                res.add(array[left]);
                res.add(array[right]);
            //和太大，缩小右边
            } else if (array[left] + array[right] > sum) {
                right--;
            //和太小，扩大左边
            } else {
                left++;
            }
        }
        return res;
    }
}
