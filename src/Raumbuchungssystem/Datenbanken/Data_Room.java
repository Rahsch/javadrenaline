package Raumbuchungssystem.Datenbanken;

import Raumbuchungssystem.Logik.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Data_Room{
    /**
     * Pfade zu den Verzeichnissen
     * Methode bookRoom nutzt alle 3
     * Methode write nutzt nur Room
     * Methode read nutzt nur Room
     */
    private static final String pfad = "C:\\Users\\Ceyhun\\IdeaProjects\\javadrenaline\\Data\\Rooms";
    private static final String pfadB = "C:\\Users\\Ceyhun\\IdeaProjects\\javadrenaline\\Data\\Reservation";
    private static final String pfadU = "C:\\Users\\Ceyhun\\IdeaProjects\\javadrenaline\\Data\\User";


    /**
     * Schreiben / überschreiben funktioniert
     * @param room
     */
    public static void write(Room room)
    {
        try {
            FileOutputStream f = new FileOutputStream(new File(pfad+"\\"+room.getName()+".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write objects to file
            o.writeObject(room);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    /**
     * lesen funktioniert in Verzeichnis Räume
     * @param roomName
     * @return
     */
    public static Room read(String roomName)
    {

        try {
            FileInputStream fi = new FileInputStream(new File(pfad+"\\"+roomName+".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Room room = (Room) oi.readObject();
            oi.close();
            fi.close();

            return room;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Raum mit Zeitraum buchbar
     * @param nachname
     * @param start
     * @param ende
     * @param raumname
     */
    public static void bookRoom(String nachname, Datum start, Datum ende, String raumname)
    {
        User user;
        Buchung buchung = new Buchung(start, ende);

        try {
            FileInputStream fiU = new FileInputStream(new File(pfadU+"\\"+nachname+".txt"));
            ObjectInputStream oiU = new ObjectInputStream(fiU);

            //Search the User
            user = (User) oiU.readObject();
            oiU.close();
            fiU.close();

            FileInputStream fi = new FileInputStream(new File(pfad+"\\"+raumname+".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);


            // Read objects
            Room room = (Room) oi.readObject();
            oi.close();
            fi.close();

            room.book(buchung, user);
            room.setAvailable(false);
            //Zählt alle Objekte in der Liste
            File dir = new File(pfadB);
            File[] arr = dir.listFiles(new FilenameFilter(){
                public boolean accept(File dir, String name) {
                    if(name.toLowerCase().endsWith(".txt")) return true;
                    return false;
                }
            });


            try {
                 boolean check = true;
                 File folder = new File(pfadB);
                 ArrayList<Room> roomlist = new ArrayList<>();
                 for (File file : folder.listFiles()) {
                    FileInputStream fiRes = new FileInputStream(new File(pfadB+"\\"+file.getName()));
                    ObjectInputStream oiRes = new ObjectInputStream(fiRes);

                    //Search the User
                    roomlist.add((Room)oiRes.readObject());
                    oiRes.close();
                    fiRes.close();
                 }


                 for (int i = 0; i < roomlist.size(); i++) {
                    if(roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() == start.getDateComp() && roomlist.get(i).endCompare() == ende.getDateComp()
                            || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() < start.getDateComp() && roomlist.get(i).endCompare() > ende.getDateComp()
                             || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() == start.getDateComp() && roomlist.get(i).endCompare() > ende.getDateComp()
                              || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() < start.getDateComp() && roomlist.get(i).endCompare() == ende.getDateComp()
                               || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() > start.getDateComp() && roomlist.get(i).endCompare() == ende.getDateComp()
                                || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() > start.getDateComp() && roomlist.get(i).endCompare() > ende.getDateComp()
                                 || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() > start.getDateComp() && roomlist.get(i).endCompare() < ende.getDateComp()
                                  || roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() < start.getDateComp() && roomlist.get(i).endCompare() < ende.getDateComp() && start.getDateComp() < roomlist.get(i).endCompare())
                    {
                        check = false;
                    }
                 }

                if(check == false)
                 {
                    System.out.println("Raum nicht buchbar");
                 }
                 else if(check == true)
                 {
                    System.out.println("Raum wurde gebucht");
                    FileOutputStream f = new FileOutputStream(new File(pfadB+"\\"+arr.length+".txt"));
                    ObjectOutputStream o = new ObjectOutputStream(f);

                    //Write objects to file
                    o.writeObject(room);

                    o.close();
                    f.close();
                 }
                 } catch (FileNotFoundException e) {
                 System.out.println("File not found");
                 } catch (IOException e) {
                 System.out.println("Error initializing stream");
                 } catch (ClassNotFoundException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
                 }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Ausgabe Reservierung
     */
    public static void getReservation(String raumname, Datum start, Datum ende)
    {
        try {
            boolean check = true;
            File folder = new File(pfadB);
            ArrayList<Room> roomlist = new ArrayList<Room>();
            for (File file : folder.listFiles()) {
                FileInputStream fiRes = new FileInputStream(new File(pfadB + "\\" + file.getName()));
                ObjectInputStream oiRes = new ObjectInputStream(fiRes);

                //Search the User
                roomlist.add((Room) oiRes.readObject());
                oiRes.close();
                fiRes.close();
            }

            for (int i = 0; i < roomlist.size(); i++) {
                if(roomlist.get(i).getName().equals(raumname) && roomlist.get(i).startCompare() == start.getDateComp() && roomlist.get(i).endCompare() == ende.getDateComp() )
                {
                    roomlist.get(i).getReservation();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Raum löschen aus Reservierung funktioniert
     * @param raumname
     * @param start
     * @param ende
     */
    //Sucht die Liste nach einem gewählten Raum aus und "storniert" ihn
    public static void cancelRoom(String raumname, Datum start, Datum ende)
    {
        try {
            File folder = new File(pfadB);
            ArrayList<Room> roomlist = new ArrayList<Room>();
            for (File file : folder.listFiles()) {
                FileInputStream fiRes = new FileInputStream(new File(pfadB + "\\" + file.getName()));
                ObjectInputStream oiRes = new ObjectInputStream(fiRes);

                //Search the User
                roomlist.add((Room) oiRes.readObject());
                oiRes.close();
                fiRes.close();

                for (int i = 0; i < roomlist.size(); i++) {
                    if(roomlist.get(roomlist.size()-1).getName().equals(raumname) && roomlist.get(roomlist.size()-1).startCompare() == start.getDateComp() && roomlist.get(roomlist.size()-1).endCompare() == ende.getDateComp())
                    {
                        Path path = Paths.get(pfadB+"\\"+file.getName());
                        Files.delete(path);
                        break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * Gibt alle Räume aus
     */
    public static void getRooms()
    {
        try {
            File folder = new File(pfad);
            ArrayList<Room> roomlist = new ArrayList<Room>();
            for (File file : folder.listFiles()) {
                FileInputStream fiRes = new FileInputStream(new File(pfad + "\\" + file.getName()));
                ObjectInputStream oiRes = new ObjectInputStream(fiRes);

                //Search the User
                roomlist.add((Room) oiRes.readObject());
                oiRes.close();
                fiRes.close();


                System.out.println(roomlist.get(roomlist.size()-1).getName());


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * noch nicht vollständig
     */
    public static void getRoomsAvailable()
    {
        //Zählt alle Objekte in der Liste
        File dir = new File(pfad);
        File[] arr = dir.listFiles(new FilenameFilter(){
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".txt")) return true;
                return false;
            }
        });
        //System.out.println("Anzahl *.txt Dateien: "+arr.length);

        //Geht alle Objekte aus die angelegt sind
        for(int i=0; i<arr.length;i++)
            try {
                FileInputStream fi = new FileInputStream(new File(pfad+"\\h"+i+".txt"));
                ObjectInputStream oi = new ObjectInputStream(fi);

                // Read objects
                Room room = (Room) oi.readObject();
                oi.close();
                fi.close();

                if(room.getAvailable() == true){
                    System.out.println(room.getName());
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

}
