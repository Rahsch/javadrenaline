package Raumbuchungssystem.UI;
import Raumbuchungssystem.Logik.Room;
import Raumbuchungssystem.Datenbanken.Data_Room;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Lädt die Liste und fügt Ihnen Räume hinzu
        Data_Room data = new Data_Room();

        data.getRooms();
        data.getRoomsAvailable();

    }
}
