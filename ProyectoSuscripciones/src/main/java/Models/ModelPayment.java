package Models;

import Models.Entities.Comition;
import Models.Entities.Payment;
import Utilities.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONArray;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.Payment.*;

public class ModelPayment {

    public ModelPayment() { }

    public ArrayList<Payment> getAll() throws Exception{
        ArrayList<Payment> payments = new ArrayList<Payment>();

        try {
            Form form = Form.form();
            JSONArray array = Util.requestArray(form, "ModelPayment/endPointGetAllPayment.php");

            if(array != null) {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<Payment>>() {}.getType();
                payments = new Gson().fromJson(array.toString(), listType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return payments;
    }

    public void addPayment(Payment payment) throws Exception {
        Form form = Form.form();
        form.add("Subscription_idSubscription", payment.getSubscription_idSubscription().toString());
        form.add("amount", payment.getAmount().toString());
        form.add("payment_date", payment.getPayment_date());

        try{
            Util.request(form, "ModelPayment/endPointAddPayment.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Payment> getPaymentsBySubscription(Integer idSubscription) throws Exception {
        ArrayList<Payment> payments = new ArrayList<>();
        Form form = Form.form();
        form.add("idSubscription", idSubscription.toString());

        try {
            JSONArray array = Util.requestArray(form, "ModelPayment/endPointBySubscription.php");

            if(array != null) {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<Payment>>() {}.getType();
                payments = new Gson().fromJson(array.toString(), listType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return payments;
    }
}
