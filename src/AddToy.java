import java.util.InputMismatchException;
import java.util.Scanner;

public class AddToy {
    public static void addingToys() {
        System.out.println("Давайте добавим новую игрушку!");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название игрушки: ");
            String name = scanner.nextLine();
            System.out.println("Введите количество игрушек: ");
            int quantity = scanner.nextInt();
            int dropRate = 0;
            while (dropRate < 1 || dropRate > 99) {
                System.out.println("Введите новый дроп рейт, от 1 до 99.");
                dropRate = NumberInputCheck.numberInputCheck();
            }
            int toyId = GetFreeId.getFreeId();
            Toy toy = new Toy(toyId, name, quantity, dropRate);
            PutToyToDB.putToyToDB(toy);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода " + e.getMessage());;
        }
    }
}
