package App.Domain;

public class Transaction {
    private String ID;
    private String date;
    private String playerID;
    private String amount;
    private String method;

    public void setID(String ID) { this.ID = ID;}
    public void setDate(String date) { this.date = date;}
    public void setPlayerID(String playerID) { this.playerID = playerID;}
    public void setAmount(String amount) { this.amount = amount;}
    public void setMethod(String method) { this.method = method;}

    public String getID() {return this.ID;}
    public String getDate() {return this.date;}
    public String getPlayerID() {return this.playerID;}
    public String getAmount() {return this.amount;}
    public String getMethod() {return this.method;}
}