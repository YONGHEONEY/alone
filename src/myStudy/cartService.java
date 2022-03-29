package myStudy;

import java.util.ArrayList;

// Class >> 붕어빵 틀 !!
public class cartService {
    // productVO -> list 안에 넣기
    ArrayList<productVO> list = new ArrayList<>();

    public void addProduct(productVO pvo) {
        list.add(pvo);
    }

    public void printAllName() {
        for(int i=0; i< list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    public ArrayList<productVO> findProductByMaker(String maker) {
        ArrayList<productVO> findList = new ArrayList<>();
        for(int i=0; i< list.size(); i++) {
            if(maker.equals(list.get(i).getMaker())) {
                findList.add(list.get(i));
            }
        }
        return findList;
    }

}
