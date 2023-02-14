package algorithm;

/**
 * @Author Lujs
 * @Date 2022/9/24
 * 统计数字在升序数组中出现的次数
 */
public class GetCountOfK {
    //二分查找
    private int bisearch(int[] data, double k){
        int left = 0;
        int right = data.length - 1;
        //二分左右界
        while (left <= right){
            int mid = (left + right) / 2;
            if (data[mid] < k){
                left = mid + 1;
            }else if (data[mid] > k){
                right = mid - 1;
            }
        }
        return left;
    }

    int GetNumberOfK(int[] array ,int k){
        //分别查找k+0.5和k-0.5应该出现的位置，中间的部分就全是k
        return bisearch(array,k+ 0.5) - bisearch(array,k - 0.5);
    }
}
