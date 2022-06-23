package Raumbuchungssystem.Datenbanken;

import Raumbuchungssystem.Logik.Room;

import java.io.*;
import java.util.*;


public class Data_Room {
    private static final String pfad = "C:\\Users\\bueny\\IdeaProjects\\javadrenaline\\Data\\Rooms";

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

    //Prüft ob Räume verfügbar sind und gibt diese dann aus
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

    //Sucht die Liste nach einem gewählten Raum aus und "bucht" ihn
    public static void bookRoom(String bezeichnung)
    {
        try {
            FileInputStream fi = new FileInputStream(new File(pfad+"\\"+bezeichnung+".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Room room = (Room) oi.readObject();
            oi.close();
            fi.close();
            if(room.getAvailable() == true)
            {
                room.setAvailable(false);
            }
            else
            {
                System.out.println("Der Raum ist bereits gebucht");
            }

            write(room);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Sucht die Liste nach einem gewählten Raum aus und "storniert" ihn
    public static void cancelRoom(String bezeichnung)
    {
        try {
            FileInputStream fi = new FileInputStream(new File(pfad+"\\"+bezeichnung+".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Room room = (Room) oi.readObject();
            oi.close();
            fi.close();
            room.setAvailable(true);
            write(room);
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
