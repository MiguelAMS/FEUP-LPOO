import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> transformers;

    StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer st : transformers) {
            st.execute(drink);
        }
    }
}
