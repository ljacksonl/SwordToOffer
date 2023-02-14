package algorithm;

/**
 * @Author Lujs
 * @Date 2022/9/24
 * 数字序列中某一位的数字
 * 数字以 0123456789101112131415... 的格式作为一个字符序列，
 * 在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，以此类题，请你输出第 n 位对应的数字。
 */
public class FindNthDigit {



    public int findNthDigit(int n){
        if (n < 0){
            return -1;
        }
        int digits = 1;
        while (true){
            //digists 位 有多少个数
            long number = countOfIntegers(digits);
            if (n < number * digits){
                return digitAtIndex(n,digits);
            }
            n -= digits * number ;
            digits++;
        }
    }

    //剩下的数字序列和位数
    private int digitAtIndex(int n ,int digits){
        //属于开始的beginNumber的第几个数
        long number = beginNumber(digits) + n / digits;
        System.out.println("number.."+number);
        int indexFromRight = digits - n % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number = number / 10;
        }
        return (int) (number % 10);
    }

    //digits位数的第一个是多少，例如1位数的开头是 0 ，二位数的开头是10，三位数是100
    private long beginNumber(int digits){
        if (digits == 1){
            return 0;
        }
        return (long)Math.pow(10,digits-1);
    }



    //digits位数 有多少个数，例如一位数有10个，二位数有90个，三位数有900个
    private long countOfIntegers (int digits){
        if (digits == 1){
            return 10;
        }
        long count = (int) Math.pow(10, digits - 1);
        System.out.println(" count ->" + count);
        return 9 * count;
    }
}
