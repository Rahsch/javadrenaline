package Raumbuchungssystem.Datenbanken;

import Raumbuchungssystem.Logik.User;
import java.io.*;

public class Data_User
{
    private static final String pfad = "C:\\Users\\bueny\\IdeaProjects\\javadrenaline\\Data\\User";

    /**
     * Erstelle Nutzer und hinterlege Objekt in Data\\User
     * @param user
     */
    public static void write(User user)
    {
        try {
            FileOutputStream f = new FileOutputStream(new File(pfad+"\\"+user.getNachname()+".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write objects to file
            o.writeObject(user);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    /**
     * Suche Nutzer im Verzeichnis Data\\User
     * @param nachname
     * @return
     */
    public static User read(String nachname)
    {
        try {
            FileInputStream fi = new FileInputStream(new File(pfad+"\\"+nachname+".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            User user = (User) oi.readObject();
            oi.close();
            fi.close();

            return user;
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


}
