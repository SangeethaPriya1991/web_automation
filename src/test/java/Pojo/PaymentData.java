package Pojo;

public class PaymentData {
    private String cardName;
    private int cardNumber;
    private int cvc;
    private int expiryMonth;
    private int expiryYear;


    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
    public int getExpiryMonth() {
        return expiryMonth;
    }
    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }
    public int getExpiryYear() {
        return expiryYear;

    }
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

}
