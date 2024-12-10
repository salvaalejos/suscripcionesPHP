package Models.Entities;

public class Comition {
    private Integer id_comition;
    private Integer seller;
    private Integer subscription;
    private Double amount;
    private String comition_date;

    // Nombres de las columnas en la base de datos
    public static final String ID_COMITION = "idComition";
    public static final String ID_SELLER = "User_idSeller";
    public static final String ID_SUBSCRIPTION = "Subscription_idSubscription";
    public static final String AMOUNT = "amount";
    public static final String COMITION_DATE = "comition_date";


    public Comition(Integer id_comition, Integer seller, Integer subscription, Double amount, String comition_date) {
        this.id_comition = id_comition;
        this.seller = seller;
        this.subscription = subscription;
        this.amount = amount;
        this.comition_date = comition_date;
    }

    public Integer getId_comition() {
        return id_comition;
    }

    public void setId_comition(Integer id_comition) {
        this.id_comition = id_comition;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
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

    public String getComition_date() {
        return comition_date;
    }

    public void setComition_date(String comition_date) {
        this.comition_date = comition_date;
    }



}
