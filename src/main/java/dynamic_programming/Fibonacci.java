package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/4
 * 斐波那契数列，
 * F(n)=F(n−1)+F(n−2)
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 2){
            return n;
        }
        int f = 0; int g = 1;
        for (int i = 0; i < n; i++) {
            f = f + g;
            g = f - g;  //已经求和过的f减去g，会得到求和前的f，赋值给g
        }
        return f;

    }
}
