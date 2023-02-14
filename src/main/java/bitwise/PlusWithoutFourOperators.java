package bitwise;

/**
 * @Author Lujs
 * @Date 2022/10/8
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 不用加减乘除做加法
 *
 */
public class PlusWithoutFourOperators {
    //位运算中两数进行异或运算可以提供两数加和后二进制非进位信息，位运算中的两数进行与运算的结果可以提供两数加和后的二进制进位信息。
    //step1:异或查看两个数进行加法操作后的结果
    //step2:与运算计算出想对应的位置的进位结果，然后左移一位
    //b代表的是两数相加是否有进位，有的话就继续，没有的话就结束得出相加后的答案
    //比如a = 5 ,b = 7.先做异或操作 101 ^ 111 = 010
    //然后作与运算 101 & 111 =101,再左移一位等于1010
    //重复运算得结果
    static int temp;
    public static int plus(int a, int b) {
        while (b != 0){
            temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int plus = plus(5, 7);
        System.out.println(plus);
    }
}
