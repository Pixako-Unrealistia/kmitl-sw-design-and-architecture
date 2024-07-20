import java.util.List;

public interface Tree {
    double cost();

    String getDescription();

    List<TreeDecorator> getDecorations();
}
