public class Lights extends TreeDecorator {

    Lights(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 5;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", Lights";
    }
}
