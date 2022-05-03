package com.haibin.algorithm2.queue;

import java.util.LinkedList;

public class MyQueue {

    /**
     *
     * @param arr 数组（4，3，5，4，3，3，6，7）
     * @param w 窗口大小
     * @return 一个长度为n-w+1的数组res,【5，5，5，4，6，7】
     */
    public int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekLast() == i - w){
                qmax.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
