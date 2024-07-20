import java.util.List;

// Base Decorator
public abstract class TreeDecorator implements Tree {
    protected Tree tree;

    TreeDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public double cost() {
        return tree.cost();
    }

    @Override
    public String getDescription() {
        return tree.getDescription();
    }

    @Override
    public List<TreeDecorator> getDecorations() {
        return tree.getDecorations();
    }
}
