package com.edison.algorithm.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator=list.listIterator();
        while (iterator.hasNext()){
            Integer i =iterator.next();
            if(i<=2){
                iterator.remove();
            }
        }
        list.add(4);
//        MyLoopQueue myLoopQueue = new MyLoopQueue();
//        for (int i = 0; i < 10; i++) { 
//            User user = new User();
//            user.setName("" + i);
//            myLoopQueue.add(user);
//        }
//
////        User user = (User) myLoopQueue.peek();
////        System.out.println(user.toString());
//          User user1 = (User) myLoopQueue.remove();
//          System.out.println(user1.toString());

    }
}
