package App.Domain;

public class CashIn {
    private String ID;
    private String date;
    private String amount;
    private String playerID;

    public void setID(String ID) { this.ID = ID;}
    public void setDate(String date) { this.date = date;}
    public void setAmount(String amount) { this.amount = amount;}
    public void setPlayerID(String playerID) { this.playerID = playerID;}

    public String getID() {return this.ID;}
    public String getDate() {return this.date;}
    public String getAmount() {return this.amount;}
    public String getPlayerID() {return this.playerID;}
}