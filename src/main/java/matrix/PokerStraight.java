package matrix;

import java.util.HashSet;

/**
 * @Author Lujs
 * @Date 2022/10/12
 * 扑克牌顺子
 * 判断一组牌（以数组的形式）是不是顺子，其中大小王可以作为癞子变成任何数（用0表示），A为1，J为11，Q为12，K为13
 */
public class PokerStraight {
    public boolean isContinuous(int[] numbers) {
        //如果五张牌max - min < 5，而且不存在重复的牌。那么它一定是顺子
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number == 0){
                continue;
            }
            //包含相同牌则直接返回，否则加入
            if (!set.contains(number)){
                set.add(number);
            }else {
                return false;
            }
            //每次遍历记录最大值，最小值
            max = StrictMath.max(max,number);
            min = StrictMath.min(min,number);
        }
        return max - min < 5;
    }
}
