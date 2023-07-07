import java.util.Scanner;

/*
    Класс организации взаимодействия с пользователем, запрашивает данные и выводит данные пользователю.
    Использует консольный ввод-вывод
 */
public class UserView implements UserInterface {
    Scanner sc = new Scanner(System.in);

    @Override
    public void showMessage(String msg) {
        System.out.printf(msg);
    }
    /*
        Метод ввода целого числа, проводит проверку типа данных до тех пор пока данные не будут введены правильно
     */
    @Override
    public int getInt(String str) {
        boolean flag = false;
        while (!flag) {
            System.out.println(str);
            if (sc.hasNextInt()) {
                flag = true;
                int num = sc.nextInt();
                return num;
            } else {
                System.out.println("You enter not a number - " + sc.next());
            }
        }
        return 0;
    }
    /*
       Метод ввода целого положительного числа, проводит проверку типа данных до тех пор пока данные не будут введены правильно
    */
    @Override
    public int getUnsignedInt(String str) {
        boolean flag = false;
        while (flag == false) {
            System.out.println(str);
            if (sc.hasNextInt() == true) {
                int num = sc.nextInt();
                if (num >= 0) {
                    flag = true;
                    return num;
                }
            } else {
                System.out.println("You enter not a number or less than 0: " + sc.next());
            }
        }
        return 0;
    }

    /*
        Метод ввода строки.
     */
    @Override
    public String getString(String str) {
        boolean flag = false;
        while (flag == false) {
            System.out.println(str);
            if (sc.hasNext() == true) {
                flag = true;
                String res = sc.next();
                return res;
            } else {
                System.out.println("You enter not a String - " + sc.next());
            }
        }
        return null;
    }
}
