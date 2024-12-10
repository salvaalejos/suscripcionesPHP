/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author hfyh
 */
public class Sucursal {
    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private Double porcentajeGananciaAdmin;
    private Double porcentajeGananciaSucursal;
    private String telefono;
    private boolean status;

    // Nombres de las columnas en la base de datos
    public static final String ID_SUCURSAL = "idSucursal";
    public static final String NAME = "name";
    public static final String DIRECTION = "direction";
    public static final String PERCENTAGE_ADMIN = "percentageAdmin";
    public static final String PERCENTAGE_SUCURSAL = "percentageSucursal";
    public static final String PHONE = "phone";
    public static final String STATUS = "status";


    public Sucursal(Integer idSucursal, String nombre, String direccion, Double porcentajeGananciaAdmin, Double porcentajeGananciaSucursal, String telefono, boolean status) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.porcentajeGananciaAdmin = porcentajeGananciaAdmin;
        this.porcentajeGananciaSucursal = porcentajeGananciaSucursal;
        this.telefono = telefono;
        this.status = status;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPorcentajeGananciaAdmin() {
        return porcentajeGananciaAdmin;
    }

    public void setPorcentajeGananciaAdmin(Double porcentajeGananciaAdmin) {
        this.porcentajeGananciaAdmin = porcentajeGananciaAdmin;
    }

    public Double getPorcentajeGananciaSucursal() {
        return porcentajeGananciaSucursal;
    }

    public void setPorcentajeGananciaSucursal(Double porcentajeGananciaSucursal) {
        this.porcentajeGananciaSucursal = porcentajeGananciaSucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.getNombre(); // Devuelve el nombre como representación
    }
}
