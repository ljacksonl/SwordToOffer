package sort;

import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/7
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicatedIntInArray {
    public int duplicate (int[] numbers) {
        //哈希表记录重复
        HashMap<Integer, Integer> mp = new HashMap<>();
        //遍历数组
        for (int i = 0; i < numbers.length; i++) {
            //如果没有出现过就加入哈希表
            if (!mp.containsKey(numbers[i])){
                mp.put(numbers[i],1);
                //否则就是重复数字
            }else {
                return numbers[i];
            }
        }
        return -1;
    }
}
