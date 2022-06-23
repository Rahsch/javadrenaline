package Raumbuchungssystem.Logik;

import java.io.Serializable;

public class Room implements IRoom, Serializable {

    private int seats;
    private String name;
    private boolean available = true;

    public Room(String name,int seats)
    {
        this.name = name;
        this.seats = seats;
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
