package App.Domain;

public class Player {
    private String ID;
    private String name;
    private String Email;
    private String dateOfBirth;

    public void setID(String ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String Email) {this.Email = Email;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getID() {return ID;}
    public String getName() {return name;}
    public String getEmail() {return Email;}
    public String getDateOfBirth() {return dateOfBirth;}

}