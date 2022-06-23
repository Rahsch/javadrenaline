package Raumbuchungssystem.UI;

import Raumbuchungssystem.Logik.Room;
import Raumbuchungssystem.Datenbanken.Data_Room;
import java.util.*;


public class Main {

    public static void main(String[] args) {
       /* for(int i = 0; i<5;i++)
        {
            Room room = new Room("h"+i,i);
            Data_Room.write(room);
            System.out.println(Data_Room.read(room.getName()));
        }*/

        //System.out.println(Data_Room.read("h4"));
        Data_Room.getRoomsAvailable();
        System.out.println("\n");
        Data_Room.bookRoom("h3");
        Data_Room.getRoomsAvailable();
        Data_Room.bookRoom("h3");
        System.out.println("\n");
        Data_Room.cancelRoom("h3");
        Data_Room.getRoomsAvailable();
    }

}
