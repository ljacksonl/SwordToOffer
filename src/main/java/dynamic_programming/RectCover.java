package dynamic_programming;

/**
 * @Author Lujs
 * @Date 2022/10/5
 * 矩形覆盖
 */
public class RectCover {
    /*
     * 依然是斐波那契数列，设长为水平方向，宽为竖直方向，第一次若摆放为2*1，则剩余摆放方式有rectCover(n-1)种（因为竖直方向还有n-1层）；
     * 第一次若摆放为1*2，剩余摆放方式为rectCover(n-2)（因为竖直方向还有n-2层），如此递归
     * */
    public int rectCover(int target) {
        if (target <= 2){
            return target;
        }
        int dpi_2 = 1;
        int dpi_1 = 2;
        int res = 0;
        for (int i = 3; i < target; i++) {
            res = dpi_1 + dpi_2;
            dpi_2 = dpi_1;
            dpi_1 = res;
        }
        return res;
    }

}
