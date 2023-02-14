import java.util.Arrays;

/**
 * @Author Lujs
 * @Date 2022/7/21
 */
public class TestCopyOfRange {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int[] headHalf = Arrays.copyOfRange(array, 0, 4);
        int[] tailHalf = Arrays.copyOfRange(array, 4, array.length);

        String a = "abc";
        System.out.println(a.substring(0, 0));
        System.out.println(a.charAt(0));
    }
}
