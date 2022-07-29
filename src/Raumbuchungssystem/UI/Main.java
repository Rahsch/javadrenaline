package Raumbuchungssystem.UI;

import Raumbuchungssystem.Datenbanken.Data_Room;
import Raumbuchungssystem.Datenbanken.Data_User;
import Raumbuchungssystem.Logik.Datum;
import Raumbuchungssystem.Logik.Room;
import Raumbuchungssystem.Logik.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Raumbuchungssystem.Datenbanken.Data_Room.bookRoom;
import static Raumbuchungssystem.Logik.Filtern.imZeitraumVerfuegbar;

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

 //Eine Methode die das erstellen eines Datums per Eingabe unterstützt und sicherstellt das dieses eingegebene Datum existiert
 public static Datum erstelleDatumPerEingabe() {

  boolean geschafft = false;
  Datum rueckgabe = null;

  while (!geschafft) {
   Scanner in = new Scanner(System.in);

   int tag = -1;
   boolean success = false;
   System.out.println("Zuerst Tag");

   while (!success) {
    try {
     tag = Integer.parseInt(in.next());
     if (tag > 31 || tag < 1) {
      System.out.print("Bitte einen richtigen Monat eiengeben\n");
     } else {
      success = true;
     }
    } catch (NumberFormatException a) {
     System.out.print("Bitte einen richtigen Tag eingeben\n");
    }
   }

   int monat = -1;
   success = false;
   System.out.println("Nun Monat");

   while (!success) {
    try {
     monat = Integer.parseInt(in.next());
     if (monat > 12 || monat < 1) {
      System.out.print("Bitte einen richtigen Monat eiengeben\n");
     } else {
      success = true;
     }
    } catch (NumberFormatException a) {
     System.out.print("Bitte einen richtigen Monat eingeben\n");
    }
   }


   int jahr = -1;
   success = false;
   System.out.println("Zuletzt Jahr");

   while (!success) {
    try {
     jahr = Integer.parseInt(in.next());
     if (jahr > 2025 || jahr < 2022) {
      System.out.print("Bitte ein Jahr zwischen 2022 und 2025 eingeben\n");
     } else {
      success = true;
     }

    } catch (NumberFormatException a) {
     System.out.print("Bitte einen richtiges Jahr eingeben\n");
    }
   }

   rueckgabe = new Datum(tag, monat, jahr);

   if (rueckgabe.pruefeDatum(tag, monat, jahr)) {
    geschafft = true;
   }
  }
  return rueckgabe;
 }

 public static void main(String[] args) {

  /* This place is reserved for the User Registration UI and the User data input
   *  it is connected to the (DatenBanken.Data_User_Input) class
   *  the command will create a UI Registration Interface and collects the data from user
   *  Temporary code for calling the UI:
   *
   *  Data_User_Input uInput = new Data_User_Input();
   *
   * */

  //Erstellen von 5 Räumen
  for (int i = 0; i < 5; i++) {
   Room room = new Room("h" + i, i);
   Data_Room.write(room);

  }

  //Bennis Testfälle
/*
  //Datum zum erstellen der Buchung
  Datum start = new Datum(29, 12, 2022);
  Datum ende = new Datum(04, 1, 2023);
  //Erstmalige Buchung
  bookRoom("Guengoer", start, ende, "h1");

  Datum starte = new Datum(26, 7, 2022);
  Datum endee = new Datum(30, 7, 2022);
  bookRoom("Guengoer", starte, endee, "h1");

  //Datum Fehlertest 1
  Datum startFt1 = new Datum(26, 6, 2022);
  Datum endeFt1 = new Datum(29, 6, 2022);
  //Buchung Fehlertest 1
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 2
  Datum startFt2 = new Datum(27, 6, 2022);
  Datum endeFt2 = new Datum(30, 6, 2022);
  //Buchung Fehlertest 2
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 3
  Datum startFt3 = new Datum(27, 6, 2022);
  Datum endeFt3 = new Datum(29, 6, 2022);
  //Buchung Fehlertest 3
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 4
  Datum startFt4 = new Datum(26, 6, 2022);
  Datum endeFt4 = new Datum(30, 6, 2022);
  //Buchung Fehlertest 4
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 5
  Datum startFt5 = new Datum(25, 6, 2022);
  Datum endeFt5 = new Datum(30, 6, 2022);
  //Buchung Fehlertest 5
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 6
  Datum startFt6 = new Datum(25, 6, 2022);
  Datum endeFt6 = new Datum(29, 6, 2022);
  //Buchung Fehlertest 6
  bookRoom("Guengoer", start, ende, "h1");

  //Datum Fehlertest 7
  Datum startFt7 = new Datum(25, 6, 2022);
  Datum endeFt7 = new Datum(1, 7, 2022);
  //Buchung Fehlertest 7
  bookRoom("Guengoer", start, ende, "h1");

  Data_Room.getRoomsAvailable();
  Data_Room.getReservation("h1", start, ende);

  Data_Room.cancelRoom("h1",start,ende);

  Data_Room.getReservation("h2", start, ende);
*/

  //Eingabesimulation zum Buchen eines Raumes von Ceyhun
  Scanner in = new Scanner(System.in);

  System.out.println("Vornamen eingeben");
  String name = in.next();
  System.out.println("Nachnamen eingeben");
  String nachname = in.next();

  User neu = new User(name, nachname);
  Data_User.write(neu);

  System.out.println("\nAb wann wollen sie buchen? Startdatum angeben\n");
  Datum startx = erstelleDatumPerEingabe();


  System.out.println("\nBis wann wollen sie buchen? Enddatum angeben\n");
  Datum endex = erstelleDatumPerEingabe();


  ArrayList<String> x = imZeitraumVerfuegbar(startx, endex);

  if (x.isEmpty()) {
   System.out.println("Keine Räume im gewünschten Zeitintervall verfügbar");
  } else {

   System.out.println("\nWelchen Raum möchten Sie buchen?");
   String raumm = "";
   boolean success = false;

   while (!success) {
    raumm = in.next();
    for (String e : x) {
     if (e.equals(raumm)) {
      success = true;
      break;
     }
    }
    if (!success){
     System.out.print("Bitte geben sie den richtigen Raumnamen ein!\n");
    }
   }
   bookRoom(nachname, startx, endex, raumm);
  }
 }
}