package co.edu.uniquindio.tallerGenericsCollection.splitStack;

import co.edu.uniquindio.tallerGenericsCollection.pairList.Pair;

import java.util.Stack;

public class SplitStack {
    public static Pair<Stack<Integer>, Stack<Integer>> splitStack(Stack<Integer> s, int i){
        Stack<Integer> aux = new Stack<>();
        int size = s.size();
        for(int j = size -1; j >= i; j--){
            int el = s.pop();
            aux.push(el);
        }
        Stack<Integer> subparte = new Stack<>();
        size = aux.size();
        for(int start = size - 1; start >= 0; start--){
            subparte.push(aux.pop());
        }
        return new Pair<>(s, subparte);

    }
}
