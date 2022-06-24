package Raumbuchungssystem.Logik;

import java.io.Serializable;

public class Buchung implements Serializable
{
    private Datum start;
    private Datum ende;

    public Buchung (Datum start, Datum ende)
    {
        this.start = start;
        this.ende = ende;
    }

    public Datum getStart()
    {
        return this.start;
    }

    public Datum getEnde()
    {
        return this.ende;
    }

    /**
     * Gibt Startdatum der Buchung zurück
     * @return
     */
    public String getStartDate()
    {
        return start.getDate();
    }

    /**
     * Gibt Enddatum der Buchung zurück
     * @return
     */
    public String getEndDate()
    {
        return ende.getDate();
    }

    /**
     * Gibt Startdatum als Zahlenwert zum vergleichen zurück von der Buchung
     * @return
     */
    public int startComp()
    {
        int gesamtzahl = start.getTag() + start.getMonat()*100 +start.getJahr()*10000;
        return gesamtzahl;
    }

    /**
     * Gibt Enddatum als Zahlenwert zum vergleichen zurück von der Buchung
     * @return
     */
    public int endComp()
    {
        int gesamtzahl = ende.getTag() + ende.getMonat()*100 +ende.getJahr()*10000;
        return gesamtzahl;
    }
}
