package com.haibin.algorithm.array;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    //其实规定了是重复一次的，多次的不算
//  可以将两个字符串想像成两个连续的滑动窗口，并假设这个滑动窗口最大是字符串长度的一半，
//    通过比较两个窗口的内容是否相同，不相同的时候不断从左向右平移，完了之后，
//         还是不相同，这时候就将窗口的大小调小一点，
//         直到找到一个相同的，这个时候窗口的长度×2就是最大字符串的大小。
    public static int solve (String a) {
        // write code here
        if(a == null || a.length() <= 1){
            return 0;
        }
        char[] chars = a.toCharArray();
        int maxlen = chars.length/2; //单个窗口最大长度
        for(int len = maxlen; len>=1; len--){
            //a.length()-len-len减两次
            for(int index=0; index<=a.length()-len-len; index++){
                if(judge(chars, index, len)){
                    return len*2;
                }
            }
        }
        return 0;
    }

    static boolean judge(char[] chars, int s, int len){
        for(int i=s; i<s+len; i++){
            if(chars[i] != chars[i+len]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str = "abddabc";
        System.out.println(solve(str));
    }
}
