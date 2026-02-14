package co.edu.uniquindio.searchAlg;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearch {

    public static int searchEl(int[] arr,  int el){
        return searchEl(arr, 0, arr.length-1, el);
    }

    private static int searchEl(int[] arr, int start, int end, int el) {
        if(start > end){
            return -1;
        }

        int middle = (start + end)/2;

        if(el == arr[middle]){
            return middle;
        }

        else if(arr[middle]>el){
            return searchEl(arr, start, middle-1, el);
        }
        else{
            return searchEl(arr, middle+1, end, el);
        }
    }

    public static void main(String[] args){
        System.out.println(searchEl(new int[]{1,4,6,8,10,20,19}, 20));
    }

}
