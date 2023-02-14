package sort;

import java.util.Arrays;

/**
 * @Author Lujs
 * @Date 2022/10/7
 * 归并排序
 * 将两个有序的数列合并成一个大的有序的序列。通过递归，层层合并，即为归并。先分而治之，最后合并
 */
public class MergeSort {
    //归并排序，时间复杂度为O(N*logN)，空间复杂度为O(N)
    public static void mergeSort(int[] arr,int start,int end){
        //先分治
        //分治结束的条件
        if (start >= end){
            return;
        }
        //中位数 保证不溢出的写法
        int mid = start + ((end - start) >> 1);
        //开始递归排序
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    //合并算法
    public static void merge(int[] arr,int start,int mid ,int end){
        //将arr的[start,middle] 和 [middle + 1, end] 区间合并
        int[] tmp = new int[end - start +1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= end){
            if (arr[p1] > arr[p2]){
                tmp[p++] = arr[p2++];
            } else {
                tmp[p++] = arr[p1++];
            }
        }
        while (p1 <= mid){
            tmp[p++] = arr[p1++];
        }
        while (p2 <= end){
            tmp[p++] = arr[p2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i+start] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,6,1,3,7,9,8,5};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
