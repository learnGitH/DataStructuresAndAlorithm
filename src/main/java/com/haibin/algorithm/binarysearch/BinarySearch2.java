package com.haibin.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch2 {

    public static void main(String[] args){
        int arr[] = {1,8,10,89,1000,1000,1234};
      //  int resIndex = binarySearch(arr,0,arr.length - 1,1000);
        List<Integer> resIndex = binarySearch2(arr,0,arr.length - 1,1000);
        System.out.println(resIndex);
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearch2(arr,mid + 1,right,findVal);
        }else if(findVal < midVal){
            return binarySearch2(arr,left,mid - 1,findVal);
        }else {
            List<Integer> result = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                result.add(temp);
                temp--;
            }
            result.add(mid);

            temp = mid + 1;
            while(true){
                if (temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                result.add(temp);
                temp++;
            }
            return result;
        }
    }

}
