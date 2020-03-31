import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {
    private boolean happyHour;

    StringBar() {
        happyHour = false;
    }

    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        happyHour = true;
        super.notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyHour = false;
        super.notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
