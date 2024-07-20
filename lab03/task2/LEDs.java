public class LEDs extends TreeDecorator {

    LEDs(Tree tree) {
        super(tree);
        tree.getDecorations().add(this);
    }

    @Override
    public double cost() {
        return super.cost() + 10;
    }

    @Override
    public String getDescription() {
        return tree.getDescription() + ", LEDs";
    }
}
