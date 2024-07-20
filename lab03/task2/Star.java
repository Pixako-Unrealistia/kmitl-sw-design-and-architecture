public class Star extends TreeDecorator {
    private boolean alreadyHasStar = false;

    Star(Tree tree) {
        super(tree);
        alreadyHasStar = tree.getDecorations().stream().anyMatch(d -> d instanceof Star);
        if (!alreadyHasStar) {
            tree.getDecorations().add(this);
        } else {
            System.out.println("Tree already has a star!");
        }
    }

    @Override
    public double cost() {
        return alreadyHasStar ? super.cost() : super.cost() + 4;
    }

    @Override
    public String getDescription() {
        return alreadyHasStar ? tree.getDescription() : tree.getDescription() + ", Star";
    }
}
