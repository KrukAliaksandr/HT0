public class Furniture implements FurnitureMustHaveMethods {
    private String name;
    private int spaceTaken;

    public String getName() {
        return name;
    }

    public int getSpaceTaken() {
        return spaceTaken;
    }

    public Furniture(String name, int spaceTaken) {
        this.name = name;
        this.spaceTaken = spaceTaken;
    }
}