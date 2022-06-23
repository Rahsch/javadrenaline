package Raumbuchungssystem.Logik;

public interface IRoom {
    public void getRoom();
    public void setName(String name);
    public String getName();
    public void setAnz(int zahl);
    public int getAnz();
    public void setAvailable(boolean available);
    public boolean getAvailable();
}
