public class Main {
    public static void main(String[] args) {

        Calculator calcGoods = new Calculator();
        PrintHi printHi = new PrintHi();
        PrintBye printBye = new PrintBye();
        printHi.printText();

        Goods shoes = new GoodsBuilder()
                .setTitle("Dynafit")
                .setPrice(15000)
                .setType("Trailrunning")
                .setAgeRestriction(15)
                .setSurface("All Terrain")
                .setModel("Ultra 50")
                .build();

        Goods backpack = new GoodsBuilder()
                .setTitle("Raidlight")
                .setPrice(10000)
                .setAgeRestriction(15)
                .setType("Trailrunning")
                .build();

        Goods shorts = new GoodsBuilder()
                .setTitle("Ternua")
                .setPrice(7000)
                .setType("Skyrunning")
                .setModel("Impulse")
                .build();

        AddGoods addGoods = new AddGoods()
                .addGoods(shoes)
                .addGoods(backpack)
                .addGoods(shorts);

        calcGoods.printText();
        printInfo(addGoods);

        OldCustomer oldCustomer = new OldCustomer("Anton", "random@mail.com", 30, 100000);
        System.out.println(oldCustomer);
        oldCustomer.addGoods(shoes).addGoods(backpack).getGoods();
        oldCustomer.removeGoods("Dynafit");
        calcGoods.calc(oldCustomer);

        YoungCustomer youngCustomer = new YoungCustomer("Anna", "another@mail.com", 14, "Mariya Ivanovna", 2000);
        System.out.println(youngCustomer);
        youngCustomer.addGoods(shoes).addGoods(backpack).getGoods();
        youngCustomer.removeGoods("Raidlight");
        calcGoods.calc(youngCustomer);

        calcGoods.printText();
        printBye.printText();
    }

    public static void printInfo(AddGoods addGoods) {

        for (int i = 0; i < addGoods.goodsArrayList.size(); i++) {
            System.out.println(addGoods.goodsArrayList.get(i));
        }
    }
}