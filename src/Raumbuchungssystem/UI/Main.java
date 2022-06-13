package Raumbuchungssystem.UI;
import Raumbuchungssystem.Logik.Room;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<ArrayList<Room>> listRoom = new ArrayList<>();

        ArrayList<Room> etage1 = new ArrayList<>();
        ArrayList<Room> etage2 = new ArrayList<>();

        etage1.add(new Room("H107", 15));
        etage1.add(new Room("H108", 10));

        etage2.add(new Room("H207", 20));
        etage2.add(new Room("H208",30));

        listRoom.add(etage1);
        listRoom.add(etage2);

        for (ArrayList obj: listRoom) {
            ArrayList<Room> temp = obj;
            for(Room job : temp)
            {
                job.getRoom();
            }
            System.out.println();
        }
    }
}
