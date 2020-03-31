public class AreaXMLOutputter {
    SumProvider aggregator;

    AreaXMLOutputter(SumProvider aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "<area>" + aggregator.sum() + "</area>";
    }
}
