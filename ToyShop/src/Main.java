public class Main {
    public static void main(String[] args) {
        Model model = new ToyModel();
        UserInterface view = new UserView();
        ToyShopPresenter presenter = new ToyShopPresenter(model, view);
        presenter.createToys();
        presenter.showToys();
        presenter.raffleToy();
        presenter.raffleToy();
        presenter.raffleToy();
        presenter.raffleToy();
        presenter.raffleToy();
        presenter.showMessage("Win Toys:\n");
        presenter.showWinToys();
        presenter.getOutToy();
        presenter.getOutToy();
        presenter.getOutToy();
        presenter.showMessage("Win Toys:\n");
        presenter.showWinToys();
        presenter.showMessage("Remaining Toys:\n");
        presenter.showToys();
    }
}