public class AreaStringOutputter {
    SumProvider aggregator;

    AreaStringOutputter(SumProvider aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "Sum of areas: " + aggregator.sum();
    }
}
