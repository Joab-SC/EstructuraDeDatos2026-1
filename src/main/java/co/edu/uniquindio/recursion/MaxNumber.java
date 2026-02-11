package co.edu.uniquindio.recursion;

public class MaxNumber {

    public static int findMaxNumber(int[] arr){
        return findMaxNumber(arr, arr[0], 1);
    }

    private static int  findMaxNumber(int[] arr, int currentMax, int nextIndex){
        if(nextIndex == arr.length){
            return currentMax;
        }

        else if(currentMax > arr[nextIndex]){
            return findMaxNumber(arr, currentMax, nextIndex + 1);
        }
        else{
            return findMaxNumber(arr, arr[nextIndex], nextIndex + 1);
        }
    }

    public static int findMaxNumber2(int[] arr){
        return  findMaxNumber2(arr, 0);
    }

    private static int findMaxNumber2(int[] arr, int index){
        if (index == arr.length - 1){
            return arr[index];
        }
        int maxExcedent = findMaxNumber2(arr, index+1);
        return arr[index] > maxExcedent?arr[index]:maxExcedent;
    }

    public static void main(String[] args) {
        System.out.println(findMaxNumber(new int[]{4,1,6,10,2,0,18,3, 21, 22, 80,1,0,2, 100}));
    }
}
