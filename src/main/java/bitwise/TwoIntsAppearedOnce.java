package bitwise;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Lujs
 * @Date 2022/10/10
 * 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class TwoIntsAppearedOnce {
    public int[] FindNumsAppearOnce(int[] array) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            //统计每个数出现的频率
            if (!mp.containsKey(array[i])){
                mp.put(array[i],1);
            }else {
                mp.put(array[i],mp.get(array[i])+1);
            }
        }
        //再次遍历数组
        for (int i = 0; i < array.length; i++) {
            //找到频率为1的两个数
            if (mp.get(array[i]) == 1){
                res.add(array[i]);
            }
        }
        //整理次序
        if (res.get(0) < res.get(1)){
            return new int[] {res.get(0), res.get(1)};
        }else {
            return new int[]{res.get(1),res.get(0)};
        }
    }
}
