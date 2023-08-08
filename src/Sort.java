import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static List<Goods> sortByTitle(List<Goods> goods) {
        Collections.sort(goods, Comparator.comparing(Goods::getTitle));
        return goods;
    }
}