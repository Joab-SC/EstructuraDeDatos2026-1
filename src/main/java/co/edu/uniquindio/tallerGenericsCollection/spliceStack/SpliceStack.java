package co.edu.uniquindio.tallerGenericsCollection.spliceStack;

import java.util.ArrayList;
import java.util.Stack;

public class SpliceStack {

    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j){
        Stack<Integer> auxStack = new Stack<>();
        int size = s.size();
        for(int start = size - 1;  start >= i; start-- ){
            int last = s.pop();
            if(start < j){
                auxStack.push(last);
            }
        }
        Stack<Integer> finalStack = new Stack<>();
        size = auxStack.size();
        for(int start  = size - 1; start >= 0; start --){
            int el = auxStack.pop();
            finalStack.push(el);
        }
        return finalStack;
    }
}
