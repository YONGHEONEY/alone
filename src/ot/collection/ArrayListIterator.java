package ot.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterator {
    public static void main(String[] args) {
        // 컬렉션 생성
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("벤츠");
        cars.add("현대");
        cars.add("기아");
        cars.add("람보르기니");

        // iterator 획득
        Iterator<String> iteratorCar = cars.iterator();

        while(iteratorCar.hasNext()){
            System.out.println(iteratorCar.next());
        }

        for(String iteratorStr : cars) {
            System.out.println(iteratorStr);
        }
    }
}
