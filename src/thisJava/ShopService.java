package thisJava;

public class ShopService {
    // 객체를 싱글톤(단하나의객체)
    private static ShopService singleton = new ShopService();

    private ShopService(){ }

    static ShopService getInstance(){
        return singleton;
    }
}
