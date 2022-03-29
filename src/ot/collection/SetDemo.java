package ot.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Set : 객체 저장시 순서가 없고, 동일한 객체는 중복 저장되지 않습니다
public class SetDemo {
    public static void main(String[] args) {
//        HashSet<Integer> A = new HashSet<>();
        ArrayList<Integer> A = new ArrayList<>();
        // ArrayList : 중복된 값도 저장한다.
        A.add(1);
        // HashSet : '2' 중복된 값은 저장되지 않는다.
        A.add(2);
        A.add(3);

//        collection에 보관하고 있는 데이터에 접근 할 때 사용합니다
        Iterator hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }

        HashSet<Integer> B = new HashSet<>();
        B.add(3);
        B.add(4);
        B.add(5);

        HashSet<Integer> C = new HashSet<>();
        C.add(1);
        C.add(2);

        System.out.println(A.containsAll(B)); // false 부분집합X
        System.out.println(A.containsAll(C)); // true 부분집합O

//        A.addAll(B);
//        A.retainAll(B); // retain(간직하다) 교집합
//        A.removeAll(B); // 차집합

//        Iterator hi = (Iterator) A.iterator();
//        while(hi.hasNext()) {
//            System.out.println(hi.next());
//        }
    }
}
