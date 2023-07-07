import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/*
    Класс проведения розыгрыша игрушки из коллекции. Так-же реализован функционал выдачи выигранной игрушки.
    Выданная игрушка записывается в текстовый файл, и удаляется из коллекции выигранных игрушек.
 */

public class Raffle {
    private final Collection<Toy> winToys;
    Random rnd = new Random();

    public Raffle() {
        this.winToys = new ArrayList<>();

    }
    /*
        Разыгрывает игрушку путем умножения веса на рандомное число. Выиганную игрушку заносит в коллекцию
        Уменьшает количество игрушек на 1
     */
    public boolean getWinToy(Collection<Toy> toys) {
        Toy winToy = null;
        int winWeight = -1;
        for (Toy toy : toys) {
            int curWinWeight = toy.getWeight() * rnd.nextInt(0, 100);
            if (curWinWeight > winWeight && toy.getQuantity() > 0) { // Количество игрушек должно быть больше 0
                winWeight = curWinWeight;
                winToy = toy;
            }
        }
        if (winToy != null) {
            this.winToys.add(winToy);
            winToy.setQuantity(winToy.getQuantity() - 1);
            return true;
        }
        return false;
    }

    public Collection<Toy> getWinToys() {
        return winToys;
    }
    /*
    Метод реализующий выдачу игрушек. Выбирает игрушку по ID, удаляет из коллекции выигранных и записывает выданную
    игрушку в файл
     */
    public boolean getOutToy(int id) {
        if (this.winToys == null) {
            System.out.print("All win Toys have been get out.\n");
            return false;
        }
        String filename = "./winner.txt";
        try (FileWriter fw = new FileWriter(filename, true)) {
            for (Toy toy : this.winToys) {
                if (toy.getId() == id) {
                    winToys.remove(toy);
                    System.out.printf("Toy ID %d successfully get out.\n", id);
                    fw.write(String.format("Toy get out:\n%s", toy));
                    return true;
                }

            }
            System.out.printf("Toy with ID %d doesn't win.\n", id);
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
