public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        String res = "";
        for (int i = 0; i < drink.getText().length(); i++) {
            char c = drink.getText().charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            res += c;
        }
        drink.setText(res);
    }
}
