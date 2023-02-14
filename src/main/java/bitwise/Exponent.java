package bitwise;

/**
 * @Author Lujs
 * @Date 2022/10/9
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * base和exponent不等于0，不得使用库函数，同时不需要考虑大数问题。
 */
public class Exponent {
    public double power(double base, int exponent) {
        //处理负数次方
        if (exponent < 0){
            exponent = - exponent;
            base = 1 / base;
        }
        double res = 1.0;
        //累乘
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }

}
