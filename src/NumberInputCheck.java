import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputCheck {
    public static int numberInputCheck() {
        int number = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число: ");
            boolean confirm = false;
            while (!confirm) {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    confirm = true;
                } else {
                    System.out.println("Вы ввели не число :(");
                    scanner.next();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод: " + e.getMessage());
        }
        return number;
    }
}
