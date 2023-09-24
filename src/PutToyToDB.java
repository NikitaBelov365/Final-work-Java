import java.io.FileWriter;
import java.io.IOException;

public class PutToyToDB {
    public static void putToyToDB(Toy toy){
        try {
            FileWriter fw = new FileWriter("src/toyDataBase.md", true);
            String str = "id:" +
                    toy.getToyId() +
                    "," +
                    "name:" +
                    toy.getName() +
                    "," +
                    "quantity:" +
                    toy.getQuantity() +
                    "," +
                    "drop:" +
                    toy.getDropRate() +
                    ".\n";

            fw.write(str);

            fw.close();

            System.out.println("Игрушка занесена в базу данных.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
