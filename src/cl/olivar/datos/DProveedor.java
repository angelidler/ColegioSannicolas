/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.datos;

/**
 *
 * @author DANIEL
 */
public class DProveedor {
    
    private String Contacto, Compania, correo,Domicilio,Rut,Telefono;
    private int IdProveedor;

    public DProveedor() {
    }

    public DProveedor(String Contacto, String Compania, String correo, String Domicilio, String Rut, String Telefono, int IdProveedor) {
        this.Contacto = Contacto;
        this.Compania = Compania;
        this.correo = correo;
        this.Domicilio = Domicilio;
        this.Rut = Rut;
        this.Telefono = Telefono;
        this.IdProveedor = IdProveedor;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String Compania) {
        this.Compania = Compania;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
    
}
