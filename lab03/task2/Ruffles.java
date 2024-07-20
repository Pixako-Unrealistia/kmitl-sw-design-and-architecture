public class Ruffles extends TreeDecorator {

    Ruffles(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", Ruffles";
    }
}
