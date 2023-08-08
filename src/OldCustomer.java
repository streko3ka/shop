import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OldCustomer implements PrintText, AddGoodsInterface, GetGoodsInterface, RemoveGoodsInterface, PayInterface {
    protected String name;
    protected String mail;
    protected int age;
    protected int cash;
    protected List<Goods> listGoods = new ArrayList<>();

    public OldCustomer(String name, String mail, int age, int cash) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.cash = cash;
    }

    @Override
    public OldCustomer addGoods(Goods goods) {
        listGoods.add(goods);
        printText();
        return this;
    }

    @Override
    public OldCustomer getGoods() {
        Sort.sortByTitle(listGoods);
        for (int i = 0; i < listGoods.size(); i++) {
            System.out.println(listGoods.get(i));
        }
        return this;
    }

    @Override
    public OldCustomer removeGoods(String title) {
        int sizeBefore = listGoods.size();

        for (int i = 0; i < listGoods.size(); i++) {
            if (Objects.equals(listGoods.get(i).title, title)) {
                listGoods.remove(i);
            }
        }
        int sizeAfter = listGoods.size();
        if (sizeBefore == sizeAfter) {
            System.out.println("Don't do it\n");
        } else {
            System.out.format("The item %s is removed!!!\n", title);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("<<<<<<<<<<<<<<<<Adult<<<<<<<<<<<<<<<<\n" +
                "Name: %s, mail: %s age: %d\n" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n", name, mail, age);
    }

    @Override
    public void printText() {
        System.out.println("The item has been added to the user's shopping cart!");
    }

    @Override
    public int pay() {
        int price = 0;
        int countPay = 0;
        for (int i = 0; i < listGoods.size(); i++) {
            price += listGoods.get(i).price;
            if (price <= cash) {
                countPay++;
                cash -= price;
                removeGoods(listGoods.get(i).title);
            } else {
                System.out.println("Not enough money");
            }
        }
        return countPay;
    }
}