public class ImpatientStrategy implements OrderingStrategy {

    ImpatientStrategy() {}

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        recipe.mix(drink);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
    }

    @Override
    public void happyHourEnded(StringBar bar) {
    }
}
