package Raumbuchungssystem.Logik;

import Raumbuchungssystem.Datenbanken.Data_Room;

import java.io.Serializable;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administrator implements Serializable{
    private String adminPasswort;
    public static Scanner in = new Scanner(System.in);

    public Administrator(){
        this.adminPasswort = "A12345";
    }

    public String getAdminPasswort(){
        return this.adminPasswort;
    }

    public static void erstelleRaumAdmin(){
        // Eingabe Namen des Raums
        System.out.println("Geben Sie den Namen des Raumes ein!");
        String nameRaum = in.next();

        // Eingabe Anzahl Sitzplätze
        System.out.println("Geben Sie die Anzahl an Sitzplätze ein!");
        int anzahlSitzplaetze = in.nextInt();

        //Erstellen des Raumes
        Room room = new Room(nameRaum, anzahlSitzplaetze);
        Data_Room.write(room);
        System.out.println("Raum wurde erstellt.\n");
    }
    public static void loescheRaumAdmin(){
        //Ausgabe aller Räume
        System.out.println("Welchen dieser Räume wollen Sie löschen?");
        Data_Room.getRooms();
        //Eingabe eines Raumes, der gelöscht werden soll
        String loeschRaum = in.next();

        Data_Room.loescheRaum(loeschRaum);
    }
    public static void sperreRaumAdmin(){
        //Ausgabe aller Räume
        System.out.println("Welchen dieser Räume wollen Sie sperren?");
        Data_Room.getRooms();
        //Eingabe eines Raumes, der gesperrt werden soll
        String sperrRaum = in.next();

        Data_Room.sperreRaum(sperrRaum);
    }
    public static void entsperreRaumAdmin(){
        System.out.println("Welchen dieser Räume wollen Sie entsperren?");
        Data_Room.getRoomsGesperrt();
        //Eingabe eines Raumes, der entsperrt werden soll
        String entsperrRaum = in.next();

        Data_Room.entsperreRaum(entsperrRaum);
    }

}
