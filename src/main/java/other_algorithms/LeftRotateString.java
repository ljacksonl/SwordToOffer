package other_algorithms;

/**
 * @Author Lujs
 * @Date 2022/10/26
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public String leftRotateString(String str, int n) {
        //把字符串看成AB 即转换后为BA
        if (str.isEmpty() || str.length() == 0){
            return "";
        }
        int m = str.length();
        n = n % m;
        StringBuilder res = new StringBuilder();
        //先遍历后面的，放到前面
        for (int i = n; i < m; i++) {
            res.append(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
