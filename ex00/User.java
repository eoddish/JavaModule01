
public class User {
    private Integer Identifier;
    private String Name;
    private Integer Balance;

    public User(String Name, int Balance) {
        this.Name = Name;
        if (Balance > 0) {
            this.Balance = Balance;
        }
    }

    public User() {
        this.Name = "Default";
        this.Balance = 0;
    }

    public Integer getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Integer identifier) {
        Identifier = identifier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        Balance = balance;
    }
}
