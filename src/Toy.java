public class Toy{
    private int toyId;
    private String name;
    private int quantity;
    private int dropRate;

    public Toy(int toyId, String name, int quantity, int dropRate) {
        this.toyId = toyId;
        this.name = name;
        this.quantity = quantity;
        this.dropRate = dropRate;
    }


    public int getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDropRate() {
        return dropRate;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }
}
