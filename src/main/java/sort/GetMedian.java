package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Lujs
 * @Date 2022/10/8
 * 数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
    //数据流是源源不断地插入，考虑在增加数据的同时将其有序化，这个过程就让我们想到了插入排序
    ArrayList<Integer> list = new ArrayList<>();
    public void insert(Integer num){
        if (list.isEmpty()){
            //val中没有数据，直接加入
            list.add(num);
        }else {
            int i = 0;
            //遍历找到插入点
            for (; i < list.size(); i++) {
                if (num <= list.get(i)){
                    break;
                }
            }
            //插入相应位置
            list.add(i,num);
        }
    }
    public Double getMedian() {
        int n = list.size();
        //奇数个数字
        if (n % 2 ==1){
            return (double)list.get(n / 2);
        }else {
            //偶数个数字
            double a= list.get(n /2);
            double b = list.get(n/2 -1);
            return (a+b)/2;
        }
    }
}
