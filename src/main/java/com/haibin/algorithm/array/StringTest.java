package com.haibin.algorithm.array;

public class StringTest {
    public static String solve (String s, String t) {
        // write code here
        int sLength = s.length();
        int tLength = t.length();
        int temp = 0;
        if(sLength > tLength){
            t = add_zero(t,sLength - tLength);
        }else{
            s = add_zero(s,tLength - sLength);
        }
        int length = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(length >= 0){
            int add = Integer.valueOf(t.charAt(length) - '0') + Integer.valueOf(s.charAt(length)-'0') + temp;
            if(add >= 10){
                sb.insert(0,add%10);
                temp = 1;
            }else{
                sb.insert(0,add);
                temp = 0;
            }
            length--;
        }
        if (temp == 1){
            sb.insert(0,temp);
        }

        return sb.toString();

    }

    public static String add_zero(String str,int length){
        StringBuilder sb = new StringBuilder(str);
        while(length > 0){
            sb.insert(0,0);
            length--;
        }
        return sb.toString();
    }

    public static void main(String[] args){
       // solve("1","99");
        /*StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.append(4);*/
        int[] arr = new int[]{2,2,3,4,3};
        int maxLength = 0;
        for(int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j =i; j < arr.length; j++){
                if (sb.indexOf(String.valueOf(arr[j])) >= 0){
                    break;
                }
                sb.append(arr[j]);
                if(maxLength < sb.toString().length()){
                    maxLength = sb.toString().length();
                }
            }
        }
        System.out.println(maxLength);
    }
}
