package sort;

/**
 * @Author Lujs
 * @Date 2022/10/7
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007 即P % 1000000007
 */
public class InversePairsInArray {
    //统计逆序对的总数
    int count = 0;

    public int inversePairs(int num[]) {
        mergeSort(num, 0, num.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int start, int end) {
        //归并排序，先分治
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            //合并操作
            merge(nums, start, mid, end);
        }

    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= end) {
            //较小的值放在temp第一个位置
            if (nums[p1] <= nums[p2]) {
                temp[p++] = nums[p1++];
            } else {
                //此时就是nums[p1]>nums[p2]的时候，组成逆序对
                //数量是mid-p1+1
                count = count + mid - p1 + 1;
                temp[p++] = nums[p2++];
            }
        }
        //剩下的值放在temp后面
        while (p1 <= mid) {
            temp[p++] = nums[p1++];
        }
        while (p2 <= end) {
            temp[p++] = nums[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }
}
