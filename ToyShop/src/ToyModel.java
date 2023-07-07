import java.util.ArrayList;
import java.util.Collection;

/*
Класс ToyModel используется для работы с Игрушками, создание игрушек, редактирование, хранение набора игрушек,
Класс взаимодействует с presenter, имплементирует интерфейс Model
 */
public class ToyModel implements Model {
    private Collection<Toy> toys;
    ToyShopPresenter presenter;

    public void addPrestenter(ToyShopPresenter presenter) {
        this.presenter = presenter;
    }
    /*
        Создает набор игрушек количеством указанным в переменной, заполняет коллекцию
     */
    @Override
    public Collection<Toy> createToys(int count) {
        if (toys == null) {
            toys = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                this.addToy();
            }
        }
        return toys;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }

    @Override
    public void addToy() {
        this.toys.add(Toy.createToy(presenter.getString("Enter Name for a Toy: "), presenter.getUnsignedInt("Enter a Toy count: ")));
    }

    @Override
    public boolean changeWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy.setWeight(weight);
            }
        }
        return false;
    }
}
