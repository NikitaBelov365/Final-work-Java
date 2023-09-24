import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет!");
        System.out.println("Что вы хотите сделать?");
        System.out.println("Посмотреть игрушки в базе данных - введите 1");
        System.out.println("Добавить игрушку в базу данных - введите 2");
        System.out.println("Изменить дроп рейт игрушки - введите 3");
        System.out.println("Запустить розыгрыш игрушек - введите 4");

        String inputNumber = "0";
        try {
            Scanner scanner = new Scanner(System.in);
            boolean confirm = false;
            while (!confirm) {
                System.out.println("Введите число от 1 до 4: ");
                inputNumber = scanner.nextLine().strip();
                if (inputNumber.equals("1") || inputNumber.equals("2") || inputNumber.equals("3") || inputNumber.equals("4")) {
                    confirm = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка сканнера: " + e.getMessage());
        }
        int inputNum = Integer.parseInt(inputNumber);
        switch (inputNum){
            case 1 -> ReadDB.readDB();
            case 2 -> AddToy.addingToys();
            case 3 -> DropRateChange.dropRateChange();
            case 4 -> RafflePrizes.rafflePrizes();
        }

    }
}