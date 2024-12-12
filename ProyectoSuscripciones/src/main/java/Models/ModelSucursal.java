package Models;

import Models.Entities.Sucursal;
import Utilities.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;


public class ModelSucursal {

    public ModelSucursal() {
    }


    public ArrayList<Sucursal> getAll() throws Exception {
        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
        Form form = Form.form();
        JSONArray array = Util.requestArray(form, "ModelSucursal/endPointGetAllSucursal.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Sucursal>>() {}.getType();
            sucursales = new Gson().fromJson(array.toString(), listType);

        }

        return sucursales;
    }

    public ArrayList<Sucursal> getActives() throws Exception {
        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
        Form form = Form.form();
        JSONArray array = Util.requestArray(form, "ModelSucursal/endPointGetActives.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Sucursal>>() {}.getType();
            sucursales = new Gson().fromJson(array.toString(), listType);
        }

        return sucursales;
    }
    
    public Sucursal byUser(Integer idUser) throws Exception{
        Sucursal s = null;

        Form form= Form.form();
        form.add("idUser", idUser.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelSucursal/endPointByUserSucursal.php");
            if(json != null && !json.toString().equals("Error")) {
                s = new Gson().fromJson(json.toString(), Sucursal.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return s;
    }

    public Sucursal byId(Integer idSucursal) throws Exception{
        Sucursal s = null;

        Form form= Form.form();
        form.add("idSucursal", idSucursal.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelSucursal/endPointByIdSucursal.php");
            if(json != null && !json.toString().equals("Error")) {
                s = new Gson().fromJson(json.toString(), Sucursal.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public void addSucursal(Sucursal s) throws Exception {
        Form form = Form.form();
        form.add("name", s.getName());
        form.add("direction", s.getDirection());
        form.add("percentageAdmin", s.getPercentageAdmin().toString());
        form.add("status", s.isStatus() ? "1" : "0");
        form.add("phone", s.getPhone());

        try{
            Util.request(form, "ModelSucursal/endPointAddSucursal.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSucursal(Sucursal s) throws Exception {
        Form form = Form.form();
        form.add("idSucursal", s.getIdSucursal().toString());
        form.add("name", s.getName());
        form.add("direction", s.getDirection());
        form.add("percentageAdmin", s.getPercentageAdmin().toString());
        form.add("status", s.isStatus() ? "1" : "0");
        form.add("phone", s.getPhone());

        try{
            Util.request(form, "ModelSucursal/endPointUpdateSucursal.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteSucursal(Integer idSucursal) throws Exception {
        Form form = Form.form();
        form.add("idSucursal", idSucursal.toString());

        try{
            Util.request(form, "ModelSucursal/endPointDeleteSucursal.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
