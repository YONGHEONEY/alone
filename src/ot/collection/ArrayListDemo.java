package ot.collection;

import java.util.ArrayList;

// List : 순서가 있는 데이터 집합 , 데이터 중복 허용
public class ArrayListDemo {
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "first";
        arrayObj[1] = "second";
//        arrayObj[2] = "three"; // 오류발생
        for(int i= 0; i<arrayObj.length; i++){
            System.out.println("arrayObj = " + arrayObj[i]);
        }
        ///////////////////////////////////////////////////////
        // ArrayList Collections
        ArrayList<String> al = new ArrayList();
        al.add("one");
        al.add("two");
        al.add("three");

        for(int i=0; i< al.size(); i++) {
            String value = al.get(i);
            System.out.println(value);
        }
    }
}


