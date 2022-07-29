package Raumbuchungssystem.Logik;

import java.io.*;
import java.util.ArrayList;


public class Filtern implements Serializable {

    //Attribute
    private static final String pfad = "C:\\Users\\Ceyhun\\IdeaProjects\\javadrenaline\\Data\\Rooms";
    private static final String pfadB = "C:\\Users\\Ceyhun\\IdeaProjects\\javadrenaline\\Data\\Reservation";
    private static final ArrayList<String> verfuegbareRaueme = new ArrayList<>();


    //Alle Dateien aus Ordner "Reservation" in Array speichern
    public static String [] reservierungensDateien() {
        File test = new File(pfadB);
        return test.list();
    }

    //Alle Dateien aus Ordner "Rooms" in Array speichern
    public static String [] raumDateien() {
        File test = new File(pfad);

        return test.list();
    }


    //Methode um aus einem Startdatum des Objekts Raum ein Datum Objekt zu erstellen
    public static Datum vonRoomZuDatumStart(Room room) {
        int compare = room.startCompare();
        int jahr = (int)compare/10000;
        compare = compare-(jahr*10000);
        int monat = compare /100;
        compare = compare-(monat*100);
        int tag = compare;
        return new Datum(tag, monat, jahr);
    }

    //Methode um aus einem Enddatum des Objekts Raum ein Datum Objekt zu erstellen
    public static Datum vonRoomZuDatumEnde(Room room) {
        int compare = room.endCompare();
        int jahr = (int)compare/10000;
        compare = compare-(jahr*10000);
        int monat = compare /100;
        compare = compare-(monat*100);
        int tag = compare;
        return new Datum(tag, monat, jahr);
    }

    //Eine Arraylist mit allen Daten (Plural von Datum) die von Start bis Ende vorkommen erzeugen
    public static ArrayList<Datum> alleZeitpunkte (Datum start, Datum ende) {
        ArrayList<Datum> alleZeitpunkte = new ArrayList<>();
        alleZeitpunkte.add(start);
        do {
            if ((start.getTag()+1) > Datum.getMaxTage(start.getMonat(), start.getJahr()) && start.getMonat()==12){
                start = new Datum(1,1, start.getJahr()+1);
            } else if ((start.getTag()+1) > Datum.getMaxTage(start.getMonat(), start.getJahr())){
                start = new Datum(1, start.getMonat()+1, start.getJahr());
            } else {
                start = new Datum(start.getTag()+1, start.getMonat(), start.getJahr());
            }
            alleZeitpunkte.add(start);
        } while (start.getDateComp()!=ende.getDateComp());

        return alleZeitpunkte;
    }




    //Methode um EINEN Raum zu Filtern für den Zeitpunkt
    public static ArrayList<String> imZeitraumVerfuegbar(Datum start, Datum ende){
        //Arraylist die im Verlauf der Methode gebraucht wird
        ArrayList<String> überschneidendeRäume = new ArrayList<>();

        //Array mit allen Datum (Datum Plural), die im Zeitraum vorkommen
        ArrayList<Datum> alleZeitpunkte = alleZeitpunkte(start, ende);



        //Von der Methode reservierungensDateien die ganzen txt Datei Namen im Array übernehmen
        String[] dateinamen = reservierungensDateien();

        //Alle Reservationsdateien durchgehen
        for (String dateinaman : dateinamen) {

            //Inhalte aus Txt Datei in Objekt Room speichern
            Room room;
            try {
                // Reading the object from a file
                FileInputStream file = new FileInputStream(pfadB + "\\" + dateinaman);
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                room = (Room) in.readObject();

                in.close();
                file.close();

                //Start und Enddatum von Room in ein Datum Objekt umwandeln mithilfe der folgenden Methoden:
                Datum start1 = vonRoomZuDatumStart(room);
                Datum ende1 = vonRoomZuDatumEnde(room);

                //Array mit allen Datum (Datum Plural), die im Zeitraum vorkommen
                ArrayList<Datum> alleZeitpunkte2 = alleZeitpunkte(start1, ende1);


                //Nun werden die vorkommenden Daten (Datum) aus der Reservierungsdatei und dem vorgegebenen Zeitpunkt auf Überschneidung geprüft
                //Wenn z.B. h1 dann im angegebenen Zeitraum nicht verfügbar ist, wird es in die Arraylist überschneidendeRäume hinzugefügt
                for (Datum datum : alleZeitpunkte) {
                    for (Datum value : alleZeitpunkte2) {
                        if (value.getDateComp() == datum.getDateComp()) {
                            überschneidendeRäume.add(room.getName());
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException is caught");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught");
            }
        }


        String[] überschneidung = überschneidendeRäume.toArray(new String[0]); //Räume die aus Liste entfernt werden müssen
        String[] raumdateien = raumDateien(); //Liste mit allen Räumen (h1.txt)


        for (int i = 0; i < raumdateien.length; i++) {
            raumdateien[i] = raumdateien[i].replaceAll(".txt", "");
            verfuegbareRaueme.add(raumdateien[i]);
            for (String s : überschneidung) {
                if (s.equals(raumdateien[i])) {
                    verfuegbareRaueme.remove(raumdateien[i]);
                }
            }
        }


        StringBuilder ausgabe = new StringBuilder("Im angegebenen Zeitraum sind folgende Räume verfügbar: \n");
        for(String p : verfuegbareRaueme){
            ausgabe.append(p).append("\n");
        }

        System.out.println(ausgabe);

        return verfuegbareRaueme;
    }
}