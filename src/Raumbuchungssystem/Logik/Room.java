package Raumbuchungssystem.Logik;

public class Room implements IRoom{

    public int seats;
    public String name;

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


    public void setAnz(int b)
    {
        this.seats = b;
    }


}
