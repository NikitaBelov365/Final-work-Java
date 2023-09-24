import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DropRateChange {
    public static void dropRateChange() {
        List<String> data = GetFromDB.getFromDB();
        ReadDB.readDB();

        ArrayList<Integer> idList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int startIndex = 3;
            int endIndex = data.get(i).indexOf(",name");
            int idInData = Integer.parseInt(data.get(i).substring(startIndex, endIndex));
            idList.add(idInData);
        }

        int id = 0;
        while (!idList.contains(id)) {
            System.out.println("Введите id игрушки, для которой хотите поменять дроп рейт.");
            id = NumberInputCheck.numberInputCheck();
        }

        int strNum = 0;
        String name = "";
        String quantity = "";
        for (int i = 0; i < data.size(); i++) {
            int startIndex = 3;
            int endIndex = data.get(i).indexOf(",name");
            int idInData = Integer.parseInt(data.get(i).substring(startIndex, endIndex));
            if (id == idInData) {
                strNum = i;
                name = data.get(i).substring(data.get(i).indexOf(",name:")+6, data.get(i).indexOf(",quantity:"));
                quantity = data.get(i).substring(data.get(i).indexOf(",quantity:")+10, data.get(i).indexOf(",drop:"));
            }
        }

        int dropRateChanging = 0;
        while (dropRateChanging < 1 || dropRateChanging > 99) {
            System.out.println("Введите новый дроп рейт, от 1 до 99.");
            dropRateChanging = NumberInputCheck.numberInputCheck();
        }
        String str = "id:" +
                id +
                "," +
                "name:" +
                name +
                "," +
                "quantity:" +
                quantity +
                "," +
                "drop:" +
                dropRateChanging +
                ".\n";

        data.set(strNum, str);
        try {
            FileWriter fw = new FileWriter("src/toyDataBase.md");
            for (String item : data) {
                fw.write(item);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Проблемы записи в файл: " + e.getMessage());
        }
    }
}