import java.util.ArrayList;
import java.util.List;

public class AddGoods implements PrintText, AddGoodsInterface {

    protected int countGoods = 0;
    protected int countGoodsForOld = 0;
    protected List<Goods> goodsArrayList = new ArrayList<>();
    @Override
    public AddGoods addGoods(Goods goods) {
        goodsArrayList.add(goods);
        countGoods = goodsArrayList.size();
        if (goods.getAgeRestriction() >= 15) {
            countGoodsForOld++;
        }
        printText();
        Sort.sortByTitle(goodsArrayList);

        return this;
    }


    @Override
    public void printText() {
        System.out.format("Goods added - %s!\n" +
                        "available %d items\n" +
                        "Adult goods %d\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n"
                , goodsArrayList.get(goodsArrayList.size() - 1).title, countGoods, countGoodsForOld);
    }
}