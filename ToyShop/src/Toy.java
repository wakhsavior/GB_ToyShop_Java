import java.util.Random;

public class Toy {
    /*
    Класс игрушки, создается статическим методом, id присваевается автоматически на основании counter
     */
    private static int counter;
    private final int id;
    private String toyName;
    private int quantity;
    private int weight;
    {
        id = ++counter;  // Меняется автоматически для присвоения ID
    }
    Random rnd = new Random();
    /*
    Метод генерации новой игрушки, принимает значение имени и количетство, частоту выпадения генерирует случайным образом
     */
    public static Toy createToy(String toyName, int quantity){
        return new Toy(toyName, quantity);
     }
    private Toy(String toyName,int quantity){
        this.toyName = toyName;
        this.quantity = quantity;
        this.weight = rnd.nextInt(1,100);
    }

    /*
        Изменяет количество игрушек, проверяет, чтобы количество не было отрицательным,
        возвращает true если изменения внесены, и false если нет
     */
    public boolean setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
            return true;
        }
        else return false;
    }
    /*
    Метод изменения частоты выпадения игрушки, проверяет, что вероятность находится в диапазоне от 1 до 100, и выдает
    true и false в зависимости от результата
     */
    public boolean setWeight(int weight) {
        if (weight < 100 && weight > 0) {
            this.weight = weight;
            return true;
        }
        else
            return false;
//            throw new RuntimeException(String.format("Weight %d does not correct. Weight doesn't change.\n", weight));

    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }
    /*
    Метод toString перегружен для удобства вывода информации об игрушке
     */
    @Override
    public String toString() {
        return String.format("=====================\n" +
                             "Toy id:   %d\n" +
                             "Toy name: %s\n" +
                             "Quantity: %d\n" +
                             "weight:   %d\n" +
                             "=====================\n\n",id,toyName,quantity,weight);
    }
}
