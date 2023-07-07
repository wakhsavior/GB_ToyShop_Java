import java.util.Collection;

public interface Model {
    Collection<Toy> createToys(int count);
    void addPrestenter(ToyShopPresenter presenter);
    Collection<Toy> getToys();
    void addToy();
    boolean changeWeight(int id, int weight);
}
