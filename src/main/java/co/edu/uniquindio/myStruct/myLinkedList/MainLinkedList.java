package co.edu.uniquindio.myStruct.myLinkedList;

public class MainLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(2);
        list.addLast(7);
        list.addLast(4);
        list.addLast(3);
        list.addLast(10);



        for (Integer elem: list){
            System.out.println(elem);
        }

        System.out.println();

        list.reverse();
        for (Integer elem: list){
            System.out.println(elem);
        }

    }
}
