package other_algorithms;

import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/15
 * 数组中出现次数超过一半的数字
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfTimes {
    //遍历一次数组统计各个元素出现的次数，找到出现次数大于数组长度一半的那个数字。
    public int MoreThanHalfNum_Solution(int [] array) {
        //哈希表统计每个数字出现的次数
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            //统计频率
            if (!mp.containsKey(array[i])){
                mp.put(array[i],1);
            }else {
                mp.put(array[i],mp.get(array[i])+1);
            }
            //一旦有个数大于长度一半的情况即可返回
            if (mp.get(array[i]) > array.length/2){
                return array[i];
            }
        }
        return 0;
    }

}
