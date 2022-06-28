package Raumbuchungssystem.Datenbanken;

import java.io.*;

public class UserData implements Serializable {
    private String userId;
    private String userFName;
    private String userLName;
    private String userEmail;
    private String userPass;

    public UserData(String userId, String userFName, String userLName, String userEmail, String userPass) {
        this.userId    = userId;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userEmail = userEmail;
        this.userPass  = userPass;
    }

    // Serializing the input data by the user
    public void toPutDataIn(Object inData) throws IOException{
        FileOutputStream fos   = new FileOutputStream("UserData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(inData);
        oos.close();
    }

    // De-serializing the data from the txt file
    public String toTakeDataOut(String requestedData) throws IOException, ClassNotFoundException{
        String answer = "";
        FileInputStream fis   = new FileInputStream("com.Database.UserData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserData outData = (UserData)ois.readObject();
        if (requestedData.equals("id")) {
            answer = outData.userId;
        }
        if (requestedData.equals("first")) {
            answer = outData.userFName;
        }
        if (requestedData.equals("last")) {
            answer = outData.userLName;
        }
        if (requestedData.equals("email")) {
            answer = outData.userEmail;
        }
        if (requestedData.equals("pass")) {
            answer = outData.userPass;
        }
        ois.close();
        return answer;
    }

    public String getUserId(){

        return userId;
    }

}