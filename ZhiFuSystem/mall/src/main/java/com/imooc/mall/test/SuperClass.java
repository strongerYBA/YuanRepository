package com.imooc.mall.test;

import java.util.Scanner;

/**
 * @ClassName SuperClass
 * @Author Administrator
 * @Date 2020/3/6 21:33
 */
public  class SuperClass {
//public static void main(String[] args) {
//    String st = "afdasd\\dafda\\aaa";
//    System.out.println(st.substring(st.lastIndexOf("\\")+1));
//    char ch = (char)2+'A';
//    int in = (int)'A';
//    int b = (int)'B';
//    int i = (int)'a';
//    int one = (int)'0';
//    int two = (int)'2';
//    System.out.println(ch);
//    System.out.println(in);
//    System.out.println(b);
//    System.out.println(i);
//    System.out.println(one);
//    System.out.println(two);
//    StringBuffer buffer = new StringBuffer();
//
//}
//import java.util.Scanner;

    /**
     * Created by Administrator on 2015/12/22.
     */
//    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = getCommonStrLength(sc.next(),sc.next());
        System.out.println(len);
    }
    static int getCommonStrLength(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        String min = null;
        String max = null;
        String target = null;
        min = len1 <= len2 ? str1 : str2;
        max = len1 > len2 ? str1 : str2;
        //最外层：min子串的长度，从最大长度开始
        for (int i = min.length(); i >= 1; i--) {
            //遍历长度为i的min子串，从0开始
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                //遍历长度为i的max子串，判断是否与target子串相同，从0开始
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k,k + i).equals(target)) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }
}

