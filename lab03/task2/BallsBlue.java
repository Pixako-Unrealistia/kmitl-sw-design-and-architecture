public class BallsBlue extends TreeDecorator {

    BallsBlue(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", Balls Blue";
    }
}
