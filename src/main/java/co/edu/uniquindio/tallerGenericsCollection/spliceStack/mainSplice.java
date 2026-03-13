package co.edu.uniquindio.tallerGenericsCollection.spliceStack;

import java.util.List;
import java.util.Stack;

public class mainSplice {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(10);
        stack.push(14);
        stack.push(2);
        System.out.println(SpliceStack.spliceStack(stack, 2,5).toString());

    }
}
