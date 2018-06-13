public class Main {
    public static void main(String[] args) {
        Building building = new Building("Здание 1");
        building.addRoom("Комната 1", 2500, 3);
        building.addRoom("Комната 2", 3500, 2);
        building.getRoom("Комната 1").add(new Lamp("svet_lamp", 150));
        building.getRoom("Комната 1").add(new Lamp("sun lamp", 250));
        building.getRoom("Комната 1").add(new Furniture("Стол письменный", 4));
        building.getRoom("Комната 2").add(new Furniture("Стол письменный", 4));
        building.getRoom("Комната 1").add(new Furniture("Кресло мягкое и пушистое", 3));
        Main m = new Main();
        m.describe(building);

    }

    public void describe(Building building) {
        System.out.println(building.getName());
        for (String currentRoom : building.getRoomList().keySet()) {
            System.out.println(building.getRoomList().get(currentRoom).getName());
            System.out.println(building.getRoomList().get(currentRoom).getOverallLuminance());
            System.out.println("Lamps: " + building.getRoomList().get(currentRoom).getLamps().size());
            for (Lamp currentLamp : building.getRoomList().get(currentRoom).getLamps()) {
                System.out.println("LampName: " + currentLamp.getName());
                System.out.println("Luminance: " + currentLamp.getLuminance());

            }
            System.out.println("Free space: " + building.getRoomList().get(currentRoom).getSpace()
                    + "\n spaceinUse: " + building.getRoomList().get(currentRoom).getSpaceInUse());

        }
    }
}
