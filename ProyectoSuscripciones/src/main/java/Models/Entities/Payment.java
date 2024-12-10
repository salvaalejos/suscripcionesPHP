package Models.Entities;

public class Payment {
    private Integer id_payment;
    private Integer subscription;
    private Double amount;
    private String payment_date;

    // Nombres de las columnas en la base de datos
    public static final String ID_PAYMENT = "idPayment";
    public static final String ID_SUBSCRIPTION = "Subscription_idSubscription";
    public static final String AMOUNT = "amount";
    public static final String PAYMENT_DATE = "payment_date";


    public Payment(Integer id_payment, Integer subscription, Double amount, String payment_date) {
        this.subscription = subscription;
        this.amount = amount;
        this.payment_date = payment_date;
        this.id_payment = id_payment;
    }

    public Integer getSubscription() {
        return subscription;
    }

    public void setSubscription(Integer subscription) {
        this.subscription = subscription;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
}
