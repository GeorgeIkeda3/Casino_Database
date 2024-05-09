package App.Domain;

public class PlayerAccount {
    private String accountID;
    private String dateOpened;
    private String balance;

    public void setID(String accountID) {
        this.accountID = accountID;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getID() {return this.accountID;}
    public String getDateOpened() {return this.dateOpened;}
    public String getBalance() {return this.balance;}
}