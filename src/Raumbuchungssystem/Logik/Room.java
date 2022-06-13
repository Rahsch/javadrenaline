package Raumbuchungssystem.Logik;

public class Room implements IRoom{

    /*
    Raum hat nur einen Namen und eine Anzahl an Sitzplätzen
    Verfügbarkeit aktuell nur Raum Objekt zugeordnet kann sich später noch ändern
     */
    public int seats;
    public String name;
    public boolean available = true;

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

    public void setName(String a)
    {
        this.name = a;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAnz(int b)
    {
        this.seats = b;
    }

    public int setAnz()
    {
        return this.seats;
    }

    public void setAvailable(boolean a)
    {
        this.available = a;
    }

    public boolean getAvailable()
    {
        return available;
    }

}
