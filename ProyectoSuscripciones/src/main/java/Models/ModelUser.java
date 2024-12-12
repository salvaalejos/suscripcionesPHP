package Models;

import Models.Entities.User;
import Utilities.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.ArrayList;

import static Models.Entities.User.*;

public class ModelUser {
    String ruta = USERNAME;
    public ModelUser() {

    }

    public User login(String usr, String pass) throws Exception {

        User u = null;

        Form form = Form.form();
        form.add("usr", usr);
        form.add("pass", pass);

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelUser/endPointLogin.php");
            if(json != null && !json.toString().equals("Error")) {

                u = new Gson().fromJson(json.toString(), User.class);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public User register(User user) throws Exception {
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        Integer user_type = user.getUser_type();
        Integer idSucursal = user.getSucursal();
        String email = user.getEmail();
        boolean status = user.isStatus();
        String password = user.getPassword();

        User u = null;


        Form form = Form.form();
        form.add("username", username);
        form.add("name", name);
        form.add("phone", phone);
        form.add("user_type", user_type.toString());
        form.add("Sucursal_idSucursal", idSucursal.toString());
        form.add("email", email);
        form.add("status", status ? "1" : "0");
        form.add("password", password);

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelUser/endPointRegister.php");
            if(json != null && !json.toString().equals("Error")) {
                u = new Gson().fromJson(json.toString(), User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }

        return u;
    }

    public void registerAdmin(User user) throws Exception {
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        Integer user_type = user.getUser_type();
        String email = user.getEmail();
        boolean status = user.isStatus();
        String password = user.getPassword();

        User u = null;


        Form form = Form.form();
        form.add("username", username);
        form.add("name", name);
        form.add("phone", phone);
        form.add("user_type", user_type.toString());
        form.add("Sucursal_idSucursal", null);
        form.add("email", email);
        form.add("status", status ? "1" : "0");
        form.add("password", password);

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelUser/endPointRegister.php");
            if(json != null && !json.toString().equals("Error")) {
                u = new Gson().fromJson(json.toString(), User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public User byId(Integer idUser) throws Exception {
        User u = null;

        Form form = Form.form();
        form.add("idUser", idUser.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelUser/endPointByIdUser.php");
            if(json != null && !json.toString().equals("Error")) {
                u = new Gson().fromJson(json.toString(), User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public void update(User user) throws Exception {
        Integer idUser = user.getIdUser();
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        Integer user_type = user.getUser_type();
        Integer idSucursal = user.getSucursal();
        String email = user.getEmail();
        boolean status = user.isStatus();
        String password = user.getPassword();


        Form form = Form.form();
        form.add("idUser", idUser.toString());
        form.add("name", name);
        form.add("username", username);
        form.add("phone", phone);
        form.add("status", status ? "1" : "0");
        form.add("user_type", user_type.toString());
        form.add("Sucursal_idSucursal", idSucursal.toString());
        form.add("email", email);
        form.add("password", password);

        try{
            Util.request(form, "ModelUser/endPointUpdateUser.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAll() throws Exception {
        ArrayList<User> users = new ArrayList<User>();

        Form form = Form.form();
        JSONArray array = Util.requestArray(form, "ModelUser/endPointGetAllUser.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            users = new Gson().fromJson(array.toString(), listType);
        }

        return users;
    }

    public ArrayList<User> getSellers() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        Form form = Form.form();
        form.add("user_type", "3");

        JSONArray array = Util.requestArray(form, "ModelUser/endPointGetByUserType.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            users = new Gson().fromJson(array.toString(), listType);
        }

        return users;
    }

    public ArrayList<User> getAdmins() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        Form form = Form.form();
        form.add("user_type", "1");

        JSONArray array = Util.requestArray(form, "ModelUser/endPointGetByUserType.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            users = new Gson().fromJson(array.toString(), listType);
        }

        return users;
    }

    public ArrayList<User> getClients() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        Form form = Form.form();
        form.add("user_type", "2");

        JSONArray array = Util.requestArray(form, "ModelUser/endPointGetByUserType.php");

        if(array != null) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            users = new Gson().fromJson(array.toString(), listType);
        }

        return users;
    }

    public boolean delete(Integer idUser) throws Exception {
        boolean result = false;
        Form form = Form.form();
        form.add("idUser", idUser.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelUser/endPointDelete.php");
            if(json != null && !json.toString().equals("Error")) {
                result = new Gson().fromJson(json.toString(), boolean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
