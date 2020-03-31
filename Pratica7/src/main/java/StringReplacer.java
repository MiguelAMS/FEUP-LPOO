public class StringReplacer implements StringTransformer {
    private char current;
    private char replace;

    StringReplacer(char current, char replace) {
        this.current = current;
        this.replace = replace;
    }

    @Override
    public void execute(StringDrink drink) {
        String res = "";
        for (int i = 0; i < drink.getText().length(); i++) {
            char c = drink.getText().charAt(i);
            if (c == current) {
                c = replace;
            }
            res += c;
        }
        drink.setText(res);
    }
}
