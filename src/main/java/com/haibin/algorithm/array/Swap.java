package com.haibin.algorithm.array;

public class Swap {
    public static void main(String[] args){
        int[] array = new int[]{3,2,0,1};
        sort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array){
        int len = array.length;
        if (len <= 1){
            return;
        }
        for(int i = len - 1; i > 0; --i){
            if (array[i] == i) continue;
            swap_with_zero(array,array[i]);
            int curMax = array[i];
            for(int j = i; j >= 0; --j){
                if (array[j] > curMax){
                    curMax = array[j];
                }
            }
            swap_with_zero(array,curMax);
        }
    }

    public static void swap_with_zero(int[] array,int number){
        int len = array.length;
        int zIndex = -1;
        int nIndex = -1;
        for(int i = 0; i < len;++i){
            if (array[i] == 0){
                zIndex = i;
            }
            if (array[i] == number){
                nIndex = i;
            }
        }
        int temp = array[zIndex];
        array[zIndex] = array[nIndex];
        array[nIndex] = temp;
    }
}
