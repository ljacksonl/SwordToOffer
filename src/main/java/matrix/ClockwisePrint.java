package matrix;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/10/10
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwisePrint {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        //将顺时针输出的矩阵元素都存放在结果列表里
        ArrayList<Integer> res = new ArrayList<>();
        //先排除特殊情况
        if (matrix.length == 0){
            return res;
        }
        //左边界
        int left = 0;
        //右边界
        int right = matrix[0].length -1;
        //上边界
        int up = 0;
        //下边界
        int down = matrix.length - 1;
        //直到边界重合
        while (left <= right && up <= down){
            //上边界的从左到右
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);
            }
            //上边界向下,因为第一层已经遍历完了，少了一层
            up++;
            if (up > down){
                break;
            }
            //右边界的从上到下
            for (int i = up; i < down; i++) {
                res.add(matrix[i][right]);
            }
            //右边界向左,同理,右边界少了一层
            right--;
            if (left > right){
                break;
            }
            //下边界的从右到左
            for (int i = right; i >= left ; i--) {
                res.add(matrix[down][i]);
            }
            //下边界向上一层
            down--;
            if (up > down){
                break;
            }
            //左边界的从下到上
            for (int i = down; i >= up ; i--) {
                res.add(matrix[i][left]);
            }
            //左边界向右一层
            left++;
            if (left > right){
                break;
            }
        }
        return res;
    }
}
