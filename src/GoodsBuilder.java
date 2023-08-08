public class GoodsBuilder {
    protected String title;
    protected String type;
    protected double price;
    protected int ageRestriction;
    protected String surface;
    protected String model;

    public GoodsBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public GoodsBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public GoodsBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    public GoodsBuilder setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public GoodsBuilder setSurface(String surface) {
        this.surface = surface;
        return this;
    }

    public GoodsBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    Goods build() {
        if (title == null || type == null || price == 0) {
            throw new IllegalStateException("Title, type and price must be specified");
        }
        return new Goods(this);
    }
}