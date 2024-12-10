package Models;
import Models.Entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
    private Connection con = null;
    private Statement stm = null;

    private String host;
    private String port;
    private String user;
    private String pass;
    private String db;

    public DBManager() {
    }

    public DBManager(String host, String port, String user, String pass, String db) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.db = db;
    }

    public DBManager(String db) {
        this.host = "localhost";
        this.port = "3306";
        this.user = "root";
        this.pass = "0451alejos@";
        this.db = db;
    }

    public void open() throws Exception {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;

        System.out.println(url);

        con = DriverManager.getConnection(
                url, user, pass
        );
        stm = con.createStatement();
    }

    public void close() throws Exception {
        stm.close();
        con.close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }
}
