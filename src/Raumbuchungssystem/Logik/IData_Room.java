package Raumbuchungssystem.Logik;

public interface IData_Room {
    public void getRooms();
    public void getRoomsAvailable();
    public void bookRoom(String bezeichnung);
    public void cancelRoom(String bezeichnung);
    public Room[] getRoomsWithAtleastXSeats(int seats);
    public Room[] getRoomsWithEquipment(String equipment);
    public boolean createRoom(int seats,String equipment);

}
