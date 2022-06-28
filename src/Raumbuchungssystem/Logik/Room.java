package Raumbuchungssystem.Logik;

import java.io.Serializable;

public class Room implements IRoom, Serializable {

    private int seats;
    private String name;
    private boolean available = true;
    private Buchung buchen;
    private User benutzer;

    public Room(String name,int seats)
    {
        this.name = name;
        this.seats = seats;
    }

    /**
     * Raum einem Buchzeitraum und einem Nutzer zuordnen
     * @param buchen
     * @param benutzer
     */
    public void book(Buchung buchen, User benutzer)
    {
        this.buchen = buchen;
        this.benutzer = benutzer;
    }

    /**
     * Startdatum der Buchung
     * @return
     */
    public String getStart()
    {
        return buchen.getStartDate();
    }

    /**
     * Enddatum der Buchung
     * @return
     */
    public String getEnd()
    {
        return buchen.getEndDate();
    }

    /**
     * Startdatum als Zahlenwert zum vergleichen
     * @return
     */
    public int startCompare()
    {
        return buchen.startComp();
    }

    /**
     * Enddatum als Zahlenwert zum vergleichen
     * @return
     */
    public int endCompare()
    {
        return buchen.endComp();
    }

    public void getReservation()
    {
        System.out.println("Reservierung\nName:"+benutzer.getName()+"\nNachname:"+benutzer.getNachname()+"\nRaum:"+this.getName()+"\nVon:"+buchen.getStartDate()+"\nBis:"+buchen.getEndDate());
    }

    @Override
    public void getRoom()
    {
        System.out.println("Raum:"+name+" Sitzplaetze:"+seats);
    }

    @Override
    public String toString()
    {
        return "Name:" +this.name+ " Seats:"+this.seats+ " Available:" +this.available;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setAnz(int zahl)
    {
        this.seats = zahl;
    }

    @Override
    public int getAnz()
    {
        return this.seats;
    }

    @Override
    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    @Override
    public boolean getAvailable()
    {
        return available;
    }

}
