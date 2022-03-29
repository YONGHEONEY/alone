package myStudy;

import java.util.ArrayList;

public class shoppingCart {
    public static void main(String[] args) {
        cartService service = new cartService();
        service.addProduct(new productVO("참이름","진로",1200));
        service.addProduct(new productVO("처음처럼","롯데",1300));
        service.addProduct(new productVO("진로","삼성",1400));

        service.printAllName();
        System.out.println( );
        ArrayList<productVO> findMaker = service.findProductByMaker("롯데");
        for(int i=0; i< findMaker.size(); i++) {
            System.out.println(findMaker.get(i).getMaker());
        }

    }
}

