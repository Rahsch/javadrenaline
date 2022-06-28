package Raumbuchungssystem.UI;

import Raumbuchungssystem.Logik.Buchung;
import Raumbuchungssystem.Logik.Room;
import Raumbuchungssystem.Logik.Datum;
import Raumbuchungssystem.Datenbanken.Data_Room;
import Raumbuchungssystem.Datenbanken.Data_User;
import Raumbuchungssystem.Logik.User;

import java.io.*;
import java.util.*;

import static Raumbuchungssystem.Datenbanken.Data_Room.*;

/**
 * Räume erstellen funktioniert => Objekt in Datei speichern
 * User erstellen funktioniert => Objekt in Datei Speichern
 * Datum erstellen funktioniert => Anwendung kommt in Buchung
 * Objekte aus Dateien lesen verändern und neu schreiben usw funktioniert.
 *
 * Räume werden immer h+aufsteigende nummer sortiert geschrieben und gespeichert
 * Buchungen haben nur ne aufsteigende nummerierung
 */


public class Main {

    public static void main(String[] args) {
       for(int i = 0; i<5;i++)
        {
            Room room = new Room("h"+i,i);
            Data_Room.write(room);

        }

        Datum start = new Datum(26,6,2022);
        Datum ende = new Datum(26,6,2022);

        //Raum buchen
        bookRoom("Guengoer",start,ende,"h1");

        //Data_Room.getRooms();
        Data_Room.getReservation("h1", start, ende);

        //Data_Room.cancelRoom("h1",start,ende);

    }

}
