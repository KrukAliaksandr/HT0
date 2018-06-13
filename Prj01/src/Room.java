import java.util.ArrayList;

public class Room implements RoomInterface {
    public static final int LIGHT_FLOW_FROM_ONE_WINDOW = 700;
    public static final int ROOM_LIGHT_FLOW_LIMIT = 4000;
    private int sumLampLuminance = 0;
    private int overallLuminance;
    private String name;
    private int space;
    private int spaceInUse;
    private int windowsCount;
    private ArrayList<Lamp> lamps;
    private ArrayList<Furniture> furnitureList;
    private int lampsCount = 0;

    public Room(String name, int space, int windowsCount) {
        this.name = name;
        this.space = space;
        this.windowsCount = windowsCount;
        this.lamps = new ArrayList<Lamp>();
        this.furnitureList = new ArrayList<Furniture>();
        this.overallLuminance = this.windowsCount * LIGHT_FLOW_FROM_ONE_WINDOW;
        this.spaceInUse = 0;
    }

    public int getSpaceInUse() {
        return spaceInUse;
    }

    public String getName() {
        return name;
    }

    public int getSpace() {
        return space;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public int getSumLampLuminance() {

        return sumLampLuminance;
    }

    public ArrayList<Lamp> getLamps() {
        return lamps;
    }

    public int getOverallLuminance() {

        return sumLampLuminance + this.getWindowsCount() * WINDOW_LUMINANCE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public void add(Lamp lamp) {
        try {
        if (overallLuminance + lamp.getLuminance() <= ROOM_LIGHT_FLOW_LIMIT) {
            lamps.add(lamp);
            overallLuminance += lamp.getLuminance();
            lampsCount++;

        } else {
            throw new IlluminanceTooMuchException();
        }
        }
        catch (IlluminanceTooMuchException e){
                e.printStackTrace();
            }

    }

    public int getLampsCount() {
        return lampsCount;
    }

    public void setLampsCount(int lampsCount) {
        this.lampsCount = lampsCount;
    }

    public void add(Furniture furniture) {
        try {
            if (this.space * 0.7 > this.spaceInUse + furniture.getSpaceTaken()) {
                this.furnitureList.add(furniture);
                this.spaceInUse += furniture.getSpaceTaken();
            }
            else {
                throw new SpaceUsageTooMuchException();
            }
        }catch (SpaceUsageTooMuchException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (sumLampLuminance != room.sumLampLuminance) return false;
        if (overallLuminance != room.overallLuminance) return false;
        if (space != room.space) return false;
        if (spaceInUse != room.spaceInUse) return false;
        if (windowsCount != room.windowsCount) return false;
        if (name != null ? !name.equals(room.name) : room.name != null) return false;
        if (lamps != null ? !lamps.equals(room.lamps) : room.lamps != null) return false;
        return furnitureList != null ? furnitureList.equals(room.furnitureList) : room.furnitureList == null;
    }

    @Override
    public int hashCode() {
        int result = sumLampLuminance;
        result = 31 * result + overallLuminance;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + space;
        result = 31 * result + spaceInUse;
        result = 31 * result + windowsCount;
        result = 31 * result + (lamps != null ? lamps.hashCode() : 0);
        result = 31 * result + (furnitureList != null ? furnitureList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "sumLampLuminance=" + sumLampLuminance +
                ", overallLuminance=" + overallLuminance +
                ", name='" + name + '\'' +
                ", space=" + space +
                ", spaceInUse=" + spaceInUse +
                ", windowsCount=" + windowsCount +
                ", lamps=" + lamps +
                ", furnitureList=" + furnitureList +
                '}';
    }
}


