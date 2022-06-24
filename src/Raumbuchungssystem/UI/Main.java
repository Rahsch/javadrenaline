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

    /* This place is reserved for the User Registration UI and the User data input
    *  it is connected to the (DatenBanken.Data_User_Input) class
    *  the command will create a UI Registration Interface and collects the data from user
    *  Temporary code for calling the UI:
    *
    *  Data_User_Input uInput = new Data_User_Input();
    *
    * */

       for(int i = 0; i<5;i++)
        {
            Room room = new Room("h"+i,i);
            Data_Room.write(room);

        }
        /*
        Data_Room.getRoomsAvailable();
        System.out.println("\n");
        Data_Room.bookRoom("h3");
        Data_Room.getRoomsAvailable();
        Data_Room.bookRoom("h3");
        System.out.println("\n");
        Data_Room.cancelRoom("h3");
        Data_Room.getRoomsAvailable();
        */

        //Datum test = new Datum (29,2,2001);

        /*
        User user1 = new User("Benni","Guengoer");
        Data_User.write(user1);
        System.out.println(Data_User.read("Guengoer").getNachname());
         */

        Datum start = new Datum(26,6,2022);
        Datum ende = new Datum(26,6,2022);

       bookRoom("Guengoer",start,ende,"h1");

        Data_Room.getRooms();

        Data_Room.cancelRoom("h1",start,ende);

    }

}
