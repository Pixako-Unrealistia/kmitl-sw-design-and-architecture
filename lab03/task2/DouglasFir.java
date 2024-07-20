import java.util.ArrayList;
import java.util.List;

public class DouglasFir implements Tree {
    private final List<TreeDecorator> decorations = new ArrayList<>();

    @Override
    public double cost() {
        return 15;
    }

    @Override
    public String getDescription() {
        return "Douglas Fir tree";
    }

    @Override
    public List<TreeDecorator> getDecorations() {
        return decorations;
    }
}
