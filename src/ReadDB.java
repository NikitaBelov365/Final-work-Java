import java.util.List;

public class ReadDB {
    public static void readDB() {

        List<String> myDB = GetFromDB.getFromDB();

        for (int i = 0; i < myDB.size(); i++) {
            System.out.println(myDB.get(i));
        }
    }
}
