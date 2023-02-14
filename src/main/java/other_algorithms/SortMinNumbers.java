package other_algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Lujs
 * @Date 2022/10/24
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SortMinNumbers {
    public String printMinNumber(int[] numbers) {
        //空数组的情况
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] nums = new String[numbers.length];
        //将数字转成字符
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }
        //按照重载排序
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        //字符串叠加
        for (int i = 0; i < nums.length; i++) {
            res.append(nums[i]);
        }
        return res.toString();
    }
}
