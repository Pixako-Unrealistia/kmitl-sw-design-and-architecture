public class BallsRed extends TreeDecorator {

    BallsRed(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", Balls Red";
    }
}
