package mylove.poly2.poly19;

public class Buyer {
    static int cnt = 0;
    int money;
    Product[] cart;
    boolean myMoneyOk = true;

    public Buyer() {
        money = 1000;
        cart = new Product[6];
    }

    public void buy(Product product) {
        if (cnt == 6) {
            return;
        }
        cart[cnt] = product;
        cnt++;
    }

    public void summary() {
        String s = "";
        int result = 0;
        for (Product product : cart) {
            if (this.money - product.price < 0) {
                System.out.println("잔액이 부족하여 " + product + "를 살 수 없어요 !");
                break;
            }
            s += product + ",";
            this.money -= product.price;
            result += product.price;
        }
        System.out.println("구입물품 : " + s);
        System.out.println("사용금액 : " + result);
        System.out.println("남은금액 : " + this.money);
    }
}
