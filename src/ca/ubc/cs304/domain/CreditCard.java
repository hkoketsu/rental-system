package ca.ubc.cs304.domain;

public class CreditCard {
    private String name;
    private String number;
    private String expDate;

    public CreditCard(String name, String number, String expDate) {
        this.name = name;
        this.number = number;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getExpDate() {
        return expDate;
    }
}
