package other_algorithms;

/**
 * @Author Lujs
 * @Date 2022/10/26
 * 约瑟夫环问题
 * 圆圈中最后剩下的数
 */
public class JosephusLoop {
    /*
     * 采用递归思想，与通过哈希值来编号分区一样，当有n个人时，在第一轮中报数为m-1的人编号为(m-1)%n。设最后留下的人编号结果为f[n]；
     * 同理已经求得n-1个人情况下最后剩下的人的编号为f[n-1]，则f[n]=(f[n-1]+m)%n，
     * 因为上一轮出列一个人后，下一个人重新从0开始编号，所以n人为第一轮，n-1人为第二轮的情况下，第二轮把每个人原来的编号都减了m，
     * 因此重新加上m就能恢复到上一轮原来的编号，如此递归下去，只剩下一个人的情况即f[1]=0
     * */
    public int function(int n, int m) {
        if (n == 1){
            return 0;
        }
        //递归
        int x = function(n - 1,m);
        //返回最后删除的那个元素
        return (m + x) % n;
    }
    public int LastRemaining_Solution(int n, int m) {
        //没有小朋友的情况
        if (n == 0 || m == 0){
            return -1;
        }
        return function(n,m);
    }
}
