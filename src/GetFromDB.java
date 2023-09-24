import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFromDB {
    public static List<String> getFromDB() {
        List<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/toyDataBase.md");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return data;
    }
}
