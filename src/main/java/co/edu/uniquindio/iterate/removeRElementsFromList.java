package co.edu.uniquindio.iterate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class removeRElementsFromList {

    public static void main(String[] args){
        ArrayList<String> list =  new ArrayList<>(Arrays.asList("Andres", "Raul", "Roberto", "Carlos"));
        removeRelementss(list);
        System.out.println(list);
    }

    public static void removeRelements(ArrayList<String> list){
        for(int i = 0; i< list.size(); i++){
            if (list.get(i).charAt(0) == 'R') {
                list.remove(list.get(i));
                i--;
            }
        }
    }

    public static void removeRelementss(ArrayList<String> list){
        Iterator<String> i = list.iterator();
        while(i.hasNext()){
            String palabra = i.next();
            if(palabra.startsWith("R")){
                i.remove();
            }
        }
    }
}
