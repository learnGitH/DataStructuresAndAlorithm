package com.haibin.thinking.array;

import com.haibin.thinking.util.Print;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args){
        int[][] a = {
                {1,2,3},
                {4,5,6},
        };
        Print.print(Arrays.deepToString(a));
    }
}
