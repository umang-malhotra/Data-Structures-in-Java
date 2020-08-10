package LinkedList;

import java.util.LinkedList;

public class JavaLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(12);
        list.add(20);
        for(Integer i: list){
            System.out.println(i);
        }
        Integer someval = list.remove(1);
        System.out.println(someval);
        System.out.println(list.get(1));
    }
}
