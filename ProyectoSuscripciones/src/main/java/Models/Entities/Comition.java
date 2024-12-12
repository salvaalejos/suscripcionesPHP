package Models.Entities;

public class Comition {
    private Integer idComition;
    private Integer User_idSeller;
    private Integer Subscription_idSubscription;
    private Double amount;
    private String comition_date;

    // Nombres de las columnas en la base de datos
    public static final String ID_COMITION = "idComition";
    public static final String ID_SELLER = "User_idSeller";
    public static final String ID_SUBSCRIPTION = "Subscription_idSubscription";
    public static final String AMOUNT = "amount";
    public static final String COMITION_DATE = "comition_date";


    public Comition(Integer idComition, Integer User_idSeller, Integer Subscription_idSubscription, Double amount, String comition_date) {
        this.idComition = idComition;
        this.User_idSeller = User_idSeller;
        this.Subscription_idSubscription = Subscription_idSubscription;
        this.amount = amount;
        this.comition_date = comition_date;
    }

    public Integer getIdComition() {
        return idComition;
    }

    public void setIdComition(Integer idComition) {
        this.idComition = idComition;
    }

    public Integer getUser_idSeller() {
        return User_idSeller;
    }

    public void setUser_idSeller(Integer user_idSeller) {
        this.User_idSeller = user_idSeller;
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

    public String getComition_date() {
        return comition_date;
    }

    public void setComition_date(String comition_date) {
        this.comition_date = comition_date;
    }



}
