import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RafflePrizes {
    public static void rafflePrizes(){
        List<String> data = GetFromDB.getFromDB();
        ArrayList<Integer> dropRateList = new ArrayList<>();
        int dropRateSum = 0;
        for (int i = 0; i < data.size(); i++) {
            int dropRate = Integer.parseInt(data.get(i).substring(data.get(i).indexOf(",drop:")+6, data.get(i).indexOf(".")));
            dropRateList.add(dropRate);
            dropRateSum += dropRate;
        }

        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 0; i < dropRateList.size(); i++) {
            double toyDrop = (double) dropRateList.get(i) /dropRateSum;
            arr.add(toyDrop);
        }
        Random rnd = new Random();
        double randomNum = rnd.nextDouble(1);
        double diff = Math.abs(randomNum - arr.get(0));
        int id = 0;

        for (int i = 1; i < arr.size(); i++) {
            double currentDiff = Math.abs(randomNum - arr.get(i));
            if (currentDiff < diff) {
                diff = currentDiff;
                id = i;
            }
        }
        String winner = data.get(id).substring(data.get(id).indexOf(",name:") + 6, data.get(id).indexOf(",quantity:"));
        System.out.println("Поздравляю, вам досталась " + winner);
        int drooop = Integer.parseInt(data.get(id).substring(data.get(id).indexOf(",drop:")+6, data.get(id).indexOf(".")));

        int quantity = Integer.parseInt(data.get(id).substring(data.get(id).indexOf(",quantity:")+10, data.get(id).indexOf(",drop:")))-1;
        if (quantity == 0) {
            drooop = 0;
        }
        id += 1;
        String str = "id:" +
                    id +
                    "," +
                    "name:" +
                    winner +
                    "," +
                    "quantity:" +
                    quantity +
                    "," +
                    "drop:" +
                    drooop +
                    ".";
            data.set(id, str);

        try {
            FileWriter fw = new FileWriter("src/toyDataBase.md");
            for (String item : data) {
                fw.write(item + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Проблемы записи в файл: " + e.getMessage());
        }
    }
}
