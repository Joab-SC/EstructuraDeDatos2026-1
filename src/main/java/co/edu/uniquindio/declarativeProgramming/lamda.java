package co.edu.uniquindio.declarativeProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class lamda {
    public static void main(String[] args){
        ArrayList<Integer> myArr = new ArrayList<>(List.of(1,2,4));
        myArr.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 4;
                }
        }).forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer){
                System.out.println(integer);
            }
        });
    }
}
