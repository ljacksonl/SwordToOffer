package bitwise;

/**
 * @Author Lujs
 * @Date 2022/10/9
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 二进制中1的个数
 * 因负数用补码表示，故不能用连除法
 */
public class IntToBinaryCount {
    public int NumberOf1(int n) {
        int res = 0;
        //遍历二进制的32位，通过移位0-31次实现。
        for (int i = 0; i < 32; i++) {
            //将移位后的1与数字进行位与运算，结果为1就记录一次。
            if ((n & (1 << i)) != 0){
                res++;
            }
        }
        return res;
    }
}
