package com.haibin.algorithm.binarysearch;

public class BinarySearch {

    public static void main(String[] args){
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        //int index = binarySearchNoRecur(arr, 100);
        int index = binarySearchRecur(arr, 0,arr.length - 1,100);
        System.out.println("index=" + index);
    }

    /**
     *  二分查找的非递归实现
     * @param arr 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearchNoRecur(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){   //说明继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;    //需要向左边查找
            }else{
                left = mid + 1;     //需要向右边查找
            }
        }
        return -1;
    }

    /**
     *  二分查找的递归实现
     * @param arr 待查找的数组, arr是升序排序
     * @param left 左边下标
     * @param right 右边下标
     * @param target 需要查找的数
     * @return
     */
    public static int binarySearchRecur(int[] arr,int left,int right,int target){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal){
            return binarySearchRecur(arr,mid + 1,right,target);
        }else if(target < midVal){
            return binarySearchRecur(arr,left,mid - 1,target);
        }else{
            return mid;
        }
    }

}
