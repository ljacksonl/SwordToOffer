package algorithm;

/**
 * @Author Lujs
 * @Date 2022/9/24
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumber {
    public int minNumberInRotateArray(int[] array){
        if (array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high){
            int mid = low + high;
            //最小的数字在mid右边
            if (array[mid] > array[high]){
                low = mid + 1;
            //无法判断，一个一个试
            }else if (array[mid] == array[high]){
                high--;
            //最小数字要么是mid要么在mid左边
            }else {
                high = mid;
            }
        }
        return array[low];
    }
}
