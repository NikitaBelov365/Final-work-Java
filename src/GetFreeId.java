import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GetFreeId {
    public static int getFreeId() {
        int lineCount = 0;
        try {
            FileReader fileReader = new FileReader("src/toyDataBase.md");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
            }

            bufferedReader.close();
            fileReader.close();


        } catch (IOException e) {
            System.out.println("Проблема чтения файла: " + e.getMessage());
            try {
                File f = new File("src/toyDataBase.md");
                if (f.createNewFile())
                    System.out.println("База данных создана успешно");
            }
            catch (Exception g) {
                System.err.println(Arrays.toString(g.getStackTrace()));
            }
        }
        return lineCount + 1;
    }
}

