package Raumbuchungssystem.Datenbanken;

import Raumbuchungssystem.Logik.Room;
import java.util.*;

public class Data_Room {
    //Liste zum speichern und abrufen der Räume
    List<ArrayList<Room>> listRoom = new ArrayList<>();

    /*
    Konstruktor fügt beim erstellen des Data_Room Objekts Daten hinzu
    Konstruktor könnte später diese aus einem Dokument laden und hinzufügen z.B.
     */
    public Data_Room() {
        ArrayList<Room> etage1 = new ArrayList<>();
        ArrayList<Room> etage2 = new ArrayList<>();

        etage1.add(new Room("H107", 15));
        etage1.add(new Room("H108", 10));

        etage2.add(new Room("H207", 20));
        etage2.add(new Room("H208", 30));

        listRoom.add(etage1);
        listRoom.add(etage2);
    }

    //Gibt einfach alle Räume aus
    public void getRooms() {
        for (ArrayList obj : listRoom) {
            ArrayList<Room> temp = obj;
            for (Room job : temp) {
                job.getRoom();
            }
            System.out.println();
        }
    }

    //Prüft ob Räume verfügbar sind und gibt diese dann aus
    public void getRoomsAvailable() {
        for (ArrayList obj : listRoom) {
            ArrayList<Room> temp = obj;
            for (Room job : temp) {
                if (job.getAvailable() == true) {
                    job.getRoom();
                }
                System.out.println();
            }
        }
    /*
    public Room[] getRoomsWithAtleastXSeats(int seats){
        return null;
    }

    public Room[] getRoomsWithEquipment(String equipment){
        return null;
    }

    public boolean createRoom(int seats,String equipment){
        return false;
    }
    public boolean bookRoom(Room reservedRoom){
        return false;
    } */
    }
}
