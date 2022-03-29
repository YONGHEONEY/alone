package ot.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> A = new HashMap<String, Integer>();
        A.put("one",1);
        A.put("two",2);
        A.put("three",3);
        A.put("four",4);

        System.out.println(A.get("one"));
        System.out.println(A.get("two"));

        iteratorUsingIterator(A);
        iteratorUsingForEach(A);
    }

    private static void iteratorUsingIterator(HashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()) {
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void iteratorUsingForEach(HashMap map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
