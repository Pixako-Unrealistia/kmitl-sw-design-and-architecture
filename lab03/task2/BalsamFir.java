import java.util.ArrayList;
import java.util.List;

public class BalsamFir implements Tree {
    private final List<TreeDecorator> decorations = new ArrayList<>();

    @Override
    public double cost() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Balsam Fir tree";
    }

    @Override
    public List<TreeDecorator> getDecorations() {
        return decorations;
    }
}
