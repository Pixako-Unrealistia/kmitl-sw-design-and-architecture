public class BallsSilver extends TreeDecorator {

    BallsSilver(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 3;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", Balls Silver";
    }
}
