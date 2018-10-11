package com.company;

/*
*
* 1.2.6 如果字符串 s 中的字符循环移动任意位置之后能够得到另一个字符串 t，那么 s 就被称为 t 的回环变位
* （circular rotation）。例如，ACTGACG 就是 TGACGAC 的一个回环变位，反之亦然。判定这个
* 条件在基因组序列的研究中是很重要的。编写一个程序检查两个给定的字符串 s 和 t 是否互为回环变位。
* 提示：答案只需要一行用到 indexOf()、length() 和字符串连接的代码。
1.2.6 A string s is a circular rotation of a string t if it matches when the
characters are circularly shifted by any number of positions; e.g., ACTGACG is
a circular shift of TGACGAC, and vice versa. Detecting this condition is important
in the study of genomic sequences. Write a program that checks whether two given strings
 s and t are circular
* */

public class Main {

    public static boolean checkoutIsCircularRotation(String s, String t){

        return ((s.length() == t.length()) && (t + t).contains(s));
    }

    public static void main(String[] args) {
	// write your code here
        String s = "ACTGACG";
        String t = "TGACGAC";

        boolean ret = checkoutIsCircularRotation(s, t);
        System.out.println("ret = " + ret);
    }
}
