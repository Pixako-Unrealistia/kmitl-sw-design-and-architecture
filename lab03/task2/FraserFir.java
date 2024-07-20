import java.util.ArrayList;
import java.util.List;

public class FraserFir implements Tree {
    private final List<TreeDecorator> decorations = new ArrayList<>();

    @Override
    public double cost() {
        return 12;
    }

    @Override
    public String getDescription() {
        return "Fraser Fir tree";
    }

    @Override
    public List<TreeDecorator> getDecorations() {
        return decorations;
    }
}
