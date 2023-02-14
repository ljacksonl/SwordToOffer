package bitwise;

/**
 * @Author Lujs
 * @Date 2022/10/10
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumHarder {
    /*
     * 利用逻辑与的短路特性实现递归终止。当n=0时，执行到判断n>0时直接返回false，不会再进行与号后面的运算，最后那一轮的result会返回0。
     * 当n>0时，利用递归执行与号后面的累加求和。
     * */
    public int sum_Solution(int n) {
        //通过与运算判断n是否为正数，以结束递归
        boolean flag = (n > 1) && ((n += sum_Solution(n -1 )) > 0);
        return n;
    }
}
