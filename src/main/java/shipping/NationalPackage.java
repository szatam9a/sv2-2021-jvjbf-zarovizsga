package shipping;

public class NationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private final int COST = 1_000;


    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        return breakable == true ? 2 * COST : COST;
    }

    @Override
    public String getDestinationCountry() {
        return Transportable.super.getDestinationCountry();
    }
}
