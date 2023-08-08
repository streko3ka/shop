import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YoungCustomer implements PrintText, AddGoodsInterface, GetGoodsInterface, RemoveGoodsInterface, PayInterface {
    protected String name;
    protected String mail;
    protected int age;
    protected String parents;

    protected int cash;
    protected List<Goods> listGoodsForUser = new ArrayList<>();

    public YoungCustomer(String name, String mail, int age, String parents, int cash) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.parents = parents;
        this.cash = cash;
    }

    @Override
    public YoungCustomer addGoods(Goods goods) {
        listGoodsForUser.add(goods);
        printText();
        return this;
    }

    @Override
    public YoungCustomer getGoods() {
        Sort.sortByTitle(listGoodsForUser);
        for (int i = 0; i < listGoodsForUser.size(); i++) {
            System.out.println(listGoodsForUser.get(i));
        }
        return this;
    }

    @Override
    public YoungCustomer removeGoods(String title) {
        int sizeBefore = listGoodsForUser.size();

        for (int i = 0; i < listGoodsForUser.size(); i++) {
            if (Objects.equals(listGoodsForUser.get(i).title, title)) {
                listGoodsForUser.remove(i);
            }
        }
        int sizeAfter = listGoodsForUser.size();
        if (sizeBefore == sizeAfter) {
            System.out.println("Don't do it\n");
        } else {
            System.out.format("The item %s is removed!!!\n", title);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format(">>>>>>>>>>>>>>>>Young>>>>>>>>>>>>>>>\n" +
                "Name: %s, mailParents: %s, age: %d\n" +
                "Parents: %s\n" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n", name, mail, age, parents);
    }

    @Override
    public void printText() {
        System.out.println("The item has been added to the user's shopping cart!");
    }

    @Override
    public int pay() {
        int price = 0;
        int countPay = 0;
        for (int i = 0; i < listGoodsForUser.size(); i++) {
            price = (int) listGoodsForUser.get(i).price;
            if (price <= cash) {
                countPay++;
                cash -= price;
                removeGoods(listGoodsForUser.get(i).title);
                System.out.format("We sent message to %s for your parent %s, with the amount of payment %d.\n",
                        mail, parents, price);

            } else {
                System.out.format("Not enough money. We sent message to %s for your parent %s.\n",
                        mail, parents);
            }
        }
        return countPay;
    }
}