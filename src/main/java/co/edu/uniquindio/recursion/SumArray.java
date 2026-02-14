package co.edu.uniquindio.recursion;

public class SumArray {

    public static void main(String[] args){
        System.out.println(sumArray(new int[]{3,2,5,2,6,10}));
    }

    public static int sumArray(int[] arr){
        return sumArray(arr, 0, arr.length - 1);
    }

    public static int sumArray(int[] arr, int start, int end){
        if (start == end){
            return arr[start];
        }
        int middle = (start + end)/2;
        int left = sumArray(arr, start, middle);
        int right = sumArray(arr, middle+1, end);
        return left + right;
    }

}
