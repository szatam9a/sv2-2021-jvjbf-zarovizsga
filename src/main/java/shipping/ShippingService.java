package shipping;

import java.util.*;

public class ShippingService {
    private List<Transportable> transportables = new LinkedList<>();

    public List<Transportable> getPackages() {
        return transportables;
    }

    public ShippingService() {
    }

    public void addPackage(Transportable packagee) {
        transportables.add(packagee);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return transportables
                .stream()
                .filter(e -> e.isBreakable() == breakable)
                .filter(e -> e.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable t : transportables) {
            placeInTheMap(t, result);
        }
        return result;
    }

    private void placeInTheMap(Transportable transportable, Map<String, Integer> map) {
        if (map.containsKey(transportable.getDestinationCountry())) {
            map.put(transportable.getDestinationCountry(), map.get(transportable.getDestinationCountry()) + 1);
        } else {
            map.put(transportable.getDestinationCountry(), 1);
        }
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        List<InternationalPackage> internationalPackages = new LinkedList<>();
        List<Transportable> result;
        transportables
                .stream()
                .filter(e -> e instanceof InternationalPackage).forEach(e -> internationalPackages.add((InternationalPackage) e));
        return result = List.copyOf(internationalPackages.stream().sorted(Comparator.comparingInt(InternationalPackage::getDistance)).toList());
    }
}
