package co.edu.uniquindio.sortAlg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(List.of(3,2,5,2,1,6,7));
        bubbleSort(list);
        System.out.println(list);
    }

    public static void bubbleSort(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int curr;
            int next;
            int temp;
            boolean swap = false;
            for(int j = 0; j < list.size()-1 ; j++){
                curr = j;
                next = j + 1;
                temp = list.get(curr);

                if(list.get(curr) > list.get(next)){
                    list.set(curr, list.get(next));
                    list.set(next, temp);
                    swap = true;
                }
            }
            if (!swap){
                return;
            }
        }
    }
}
