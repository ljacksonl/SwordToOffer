package other_algorithms;

/**
 * @Author Lujs
 * @Date 2022/10/13
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 题目意思是:b[i]的值是数组a中除了下标i以外的元素的积
 * 思路是b[i]的值可以用a数组中i左边（left）的乘积乘以i右边的乘积（right）得出
 */
public class MultiplyWithoutItself {
    public int[] multiply(int[] A) {
        //对角线将正方形分成左右边的下三角和上三角，先求下三角部分，此时先使B[i]等于对角线1左侧连乘的部分，左半部分从上往下，从左到右一行一行相乘
        int[] B = new int[A.length];
        B[0] = 1;
        //先乘左边，从左到右
        for (int i = 1; i < A.length; i++) {
            //每多一位由数组B左边的元素多乘一个前面A的元素
            B[i] = B[i - 1] * A[i -1];
        }
        int temp = 1;
        for (int i = A.length - 1; i >= 0 ; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;

    }
}
