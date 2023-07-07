import java.util.Collection;

/*
    Класс взаимодействия между всеми элементами программы
 */
public class ToyShopPresenter implements UserInterface {

    private final Model model;
    private final UserInterface view;
    private final Raffle raffle;

    public ToyShopPresenter(Model model, UserInterface view) {
        this.model = model;
        this.view = view;
        this.model.addPrestenter(this);
        this.raffle = new Raffle();

    }

     public void showToys(Collection<Toy> toys) {
        for (Toy toy : toys) {
            view.showMessage(toy.toString());
        }
    }

    public void showToys() {
        this.showToys(model.getToys());
    }

    public void showWinToys() {
        this.showToys(raffle.getWinToys());
    }

    public void createToys() {
        int count = view.getUnsignedInt("How many toys would you like to create?");
        model.createToys(count);
    }

    public int getInt(String str) {
        return view.getInt(str);
    }

    public int getUnsignedInt(String str) {
        return view.getUnsignedInt(str);
    }

    public String getString(String str) {
        return view.getString(str);
    }

    public void showMessage(String msg) {
        view.showMessage(msg);
    }

    public boolean raffleToy() {
        return raffle.getWinToy(model.getToys());
    }
    public void getOutToy(){
        int id = view.getUnsignedInt("Enter get out Toy ID?");
        raffle.getOutToy(id);
    }


}
