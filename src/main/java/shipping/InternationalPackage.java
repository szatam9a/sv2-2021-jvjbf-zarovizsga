package shipping;

public class InternationalPackage implements Transportable {
    private final int COST = 1200;
    private int weight;
    private boolean breakable; // extra cost +10/km
    private String destination;
    private int distance; // km

    public InternationalPackage(int weight, boolean breakable, String destination, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destination = destination;
        this.distance = distance;
    }

    public int getCOST() {
        return COST;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int calculateShippingPrice() {
        int distanceCost = distance*10;
        if (breakable) {
            return costWithBreak() + distanceCost;
        }
        return costWithOutBreak() + distanceCost;
    }

    private int costWithBreak() {
        return COST * 2;
    }

    private int costWithOutBreak() {
        return COST;
    }

    @Override
    public String getDestinationCountry() {
        return destination;
    }
}
