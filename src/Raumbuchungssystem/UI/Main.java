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

        //Raum buchen + Ausgabe wo H107 verschwinden müsste
        data.bookRoom("H107");
        data.getRoomsAvailable();

        //Raum stornieren
        data.cancelRoom("H107");
    }
}
