public class Goods {

    protected final String title;
    protected final String type;
    protected final double price;
    protected int ageRestriction;
    protected String surface;
    protected String model;


    public Goods(final GoodsBuilder goodsBuilder) {
        this.title = goodsBuilder.title;
        this.type = goodsBuilder.type;
        this.price = goodsBuilder.price;
        setAgeRestriction(goodsBuilder.ageRestriction);
        setSurface(goodsBuilder.surface);
        setModel(goodsBuilder.model);
    }

    public String getTitle() {

        return title;
    }

    public String getType() {

        return type;
    }

    public double getPrice() {

        return price;
    }
    public int getAgeRestriction() {
        return Math.max(ageRestriction, 0);
    }

    public String getSurface() throws NullPointerException {
        if (surface != null && !surface.isEmpty()) {
            return surface;
        } else {
            return "All Terrain";
        }
    }

    public String getModel() throws NullPointerException {
        if (model != null && !model.isEmpty()) {
            return model;
        } else {
            return "Not specified";
        }
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Title: %s,\n " +
                        "Type: %s,\n " +
                        "Price: %.2f rub,\n " +
                        "AgeRestriction: %d+,\n " +
                        "Model: %s,\n " +
                        "Surface: %s.\n" +
                        "--------------------------------------------------\n",
                getTitle(),
                getType(),
                getPrice(),
                getAgeRestriction(),
                getModel(),
                getSurface());
    }
}