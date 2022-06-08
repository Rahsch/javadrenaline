package Raumbuchungssystem.Logik;

public interface IData_Room {
    public Room[] getRooms();
    public Room[] getRoomsAvailable();
    public Room[] getRoomsWithAtleastXSeats(int seats);
    public Room[] getRoomsWithEquipment(String equipment);
    public boolean createRoom(int seats,String equipment);
    public boolean bookRoom(Room reservedRoom);
}
