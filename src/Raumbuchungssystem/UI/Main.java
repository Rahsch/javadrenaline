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

       //Datum zum erstellen der Buchung
        Datum start = new Datum(26,6,2022);
        Datum ende = new Datum(30,6,2022);
        //Erstmalige Buchung
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 1
        Datum startFt1 = new Datum(26,6,2022);
        Datum endeFt1 = new Datum(29,6,2022);
        //Buchung Fehlertest 1
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 2
        Datum startFt2 = new Datum(27,6,2022);
        Datum endeFt2 = new Datum(30,6,2022);
        //Buchung Fehlertest 2
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 3
        Datum startFt3 = new Datum(27,6,2022);
        Datum endeFt3 = new Datum(29,6,2022);
        //Buchung Fehlertest 3
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 4
        Datum startFt4 = new Datum(26,6,2022);
        Datum endeFt4 = new Datum(30,6,2022);
        //Buchung Fehlertest 4
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 5
        Datum startFt5 = new Datum(25,6,2022);
        Datum endeFt5 = new Datum(30,6,2022);
        //Buchung Fehlertest 5
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 6
        Datum startFt6 = new Datum(25,6,2022);
        Datum endeFt6 = new Datum(29,6,2022);
        //Buchung Fehlertest 6
        bookRoom("Guengoer",start,ende,"h1");

        //Datum Fehlertest 7
        Datum startFt7 = new Datum(25,6,2022);
        Datum endeFt7 = new Datum(1,7,2022);
        //Buchung Fehlertest 7
        bookRoom("Guengoer",start,ende,"h1");

        //Data_Room.getRooms();
        Data_Room.getReservation("h1", start, ende);
        //Data_Room.cancelRoom("h1",start,ende);

    }

}
