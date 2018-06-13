import java.util.HashMap;

public class Building {
    private String name;
    private HashMap<String, Room> roomList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Room> getRoomList() {
        return roomList;
    }

    Building(String name) {
        this.name = name;
        this.roomList = new HashMap<String, Room>();
    }

    public void addRoom(String name, int space, int windowsCount) {

        this.roomList.put(name, new Room(name, space, windowsCount));

    }

    public Room getRoom(String name) {
        return this.roomList.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;

        if (name != null ? !name.equals(building.name) : building.name != null) return false;
        return roomList != null ? roomList.equals(building.roomList) : building.roomList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (roomList != null ? roomList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", roomList=" + roomList +
                '}';
    }
}
