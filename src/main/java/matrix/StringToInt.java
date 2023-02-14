package matrix;

/**
 * @Author Lujs
 * @Date 2022/10/12
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略
 * 第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
 * 去掉无用的前导空格
 */
public class StringToInt {
    public int strToInt(String str) {
        //先处理空串
        if (str.isEmpty()) {
            return 0;
        }
        int res = 0;
        int index = 0;
        int n = str.length();
        //去掉前导的空格，如果有
        while (index < n) {
            if (str.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }
        //如果去掉空格后为空
        if (index == n) {
            return 0;
        }
        int sign = 1;
        //处理第一个符号是正负号的情况
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        //去掉符号就什么都没有了
        if (index == n) {
            return 0;
        }
        while (index < n) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE) % 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }
}
