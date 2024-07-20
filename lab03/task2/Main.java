public class Main {
    public static void printTree(Tree tree) {
        System.out.println(tree.getDescription());
        System.out.println("costs $" + String.format("%.2f", tree.cost()));
    }

    public static void main(String[] args) {
        Tree mytree = new ColoradoBlueSpruce();
        mytree = new Star(mytree);
        mytree = new Ruffles(mytree);
        mytree = new Star(mytree);
        mytree = new Ruffles(mytree);

        System.out.println("Decorations: ");
        mytree.getDecorations().forEach(decoration -> System.out.println(decoration.getClass().getSimpleName()));
        printTree(mytree);
    }
}