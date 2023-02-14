package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lujs
 * @Date 2022/10/3
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 原理图：https://uploadfiles.nowcoder.net/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
 */
public class StringDictionarySort {

    public static void main(String[] args) {
        permutation("abc");
    }

    public static ArrayList<String> permutation(String str){
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0){
            return result;
        }
        recur(str,"",result);
        System.out.println(result.toString());
        return result;
    }

    public static void recur(String str, String cur, ArrayList<String> result){
        if (str.length() == 0){
            if (!result.contains(cur)){
                result.add(cur);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            recur(str.substring(0,i)+str.substring(i+1,str.length()),cur+str.charAt(i),result);
            System.out.println(str.length());
            System.out.println("str..."+str.substring(0,i)+str.substring(i+1,str.length()));
            System.out.println("cur..."+cur+str.charAt(i));
        }
    }
}
