package other_algorithms;

/**
 * @Author Lujs
 * @Date 2022/10/15
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray {
    public int[] reorderArray(int[] array) {
        //记录变量 i 表示将奇数放好的下一个未知，最开始 i = 0表示没有一个奇数，j 表示数组的下标，对数组进行遍历
        //若遇到偶数则 j++
        //如果遇到奇数，将 j 位置的奇数插入到 i 的位置，然后将 i 后移一位，会涉及【i, j - 1】整体移动，直到整个数组遍历结束
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            //遇到奇数时
            if (array[j] % 2 == 1){
                //先将array[j]赋值
                int tmp = array[j];
                // 将 【i, j-1】数组后移动
                for (int k = j -1; k >= i; --k) {
                    array[k+1] = array[k];
                }
                //将array[j]插入到i++的位置
                array[i++] = tmp;
            }
        }
        return array;
    }
}
