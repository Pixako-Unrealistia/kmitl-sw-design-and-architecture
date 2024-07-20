import java.util.ArrayList;
import java.util.List;

public class ColoradoBlueSpruce implements Tree {
    private final List<TreeDecorator> decorations = new ArrayList<>();

    @Override
    public double cost() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "Colorado Blue Spruce tree";
    }

    @Override
    public List<TreeDecorator> getDecorations() {
        return decorations;
    }
}
