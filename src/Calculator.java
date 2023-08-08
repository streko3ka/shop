public class Calculator implements PrintText {

    protected int count = 0;

    public void calc(PayInterface payInterface) {

        count += payInterface.pay();
    }

    @Override
    public void printText() {
        System.out.format("==================================================\n" +
                "Quantity of purchased items - %d\n", count);
    }
}