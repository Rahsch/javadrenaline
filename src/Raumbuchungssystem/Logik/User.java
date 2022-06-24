package Raumbuchungssystem.Logik;

import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String nachname;

    public User(String name, String nachname)
    {
        this.name = name;
        this.nachname = nachname;
    }

    /**
     * Gibt den Nachnamen eines Nutzers aus
     * @return
     */
    public String getNachname()
    {
        return this.nachname;
    }

    /**
     * Gibt den Vornamen eines Nutzers aus
     * @return
     */
    public String getName()
    {
        return this.name;
    }
}
