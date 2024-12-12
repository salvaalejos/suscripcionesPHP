package Models.Entities;

public class Payment {
    private Integer idPayment;
    private Integer Subscription_idSubscription;
    private Double amount;
    private String payment_date;

    // Nombres de las columnas en la base de datos
    public static final String ID_PAYMENT = "idPayment";
    public static final String ID_SUBSCRIPTION = "Subscription_idSubscription";
    public static final String AMOUNT = "amount";
    public static final String PAYMENT_DATE = "payment_date";


    public Payment(Integer idPayment, Integer Subscription_idSubscription, Double amount, String payment_date) {
        this.Subscription_idSubscription = Subscription_idSubscription;
        this.amount = amount;
        this.payment_date = payment_date;
        this.idPayment = idPayment;
    }

    public Integer getSubscription_idSubscription() {
        return Subscription_idSubscription;
    }

    public void setSubscription_idSubscription(Integer subscription_idSubscription) {
        this.Subscription_idSubscription = subscription_idSubscription;
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

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }
}
