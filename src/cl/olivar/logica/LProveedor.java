/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.logica;

import cl.olivar.datos.DProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL
 */
public class LProveedor {

    Connection cn = LConexion.getConection();

    public String InsertarProveedor(DProveedor miProveedor) {

        String msg = "";

        try {

            CallableStatement cst = cn.prepareCall("{call olv_insertar_proveedor(?,?,?,?,?,?)}");

            cst.setString(1, miProveedor.getCompania());
            cst.setString(2, miProveedor.getContacto());
            cst.setString(3, miProveedor.getCorreo());
            cst.setString(4, miProveedor.getDomicilio());
            cst.setString(5, miProveedor.getRut());
            cst.setString(6, miProveedor.getTelefono());
           
            cst.executeUpdate();

            msg = "si";
        } catch (Exception e) {

            e.printStackTrace();

        }

        return msg;
    }

    public int EditarProveedor(DProveedor miProveedor) {

        int msg = 0;

        try {

            CallableStatement cst = cn.prepareCall("{call olv_editar_proveedor(?,?,?,?,?,?,?)}");
            cst.setInt(1, miProveedor.getIdProveedor());
            cst.setString(2, miProveedor.getCompania());
            cst.setString(3, miProveedor.getContacto());
            cst.setString(4, miProveedor.getCorreo());
            cst.setString(5, miProveedor.getDomicilio());
            cst.setString(6, miProveedor.getRut());
            cst.setString(7, miProveedor.getTelefono());

            cst.executeUpdate();

            msg = 1;
        } catch (Exception e) {

            e.printStackTrace();

        }

        return msg;
    }

    public int EliminarProveedor(DProveedor miProveedor) {
        int idlinea = 0;

        try {

            CallableStatement cst = cn.prepareCall("{call olv_eliminar_proveedor(?)}");

            cst.setInt(1, miProveedor.getIdProveedor());

            cst.executeUpdate();

//            ResultSet rs=cst.executeQuery();
//            
//            while(rs.next()){
//                idlinea=rs.getInt("IdLineas");
//            }
            idlinea = 1;
        } catch (Exception e) {

            e.printStackTrace();

        }

        return idlinea;
    }

    public DefaultTableModel MostrarBuscarProveedor(DProveedor miProveedor) {

        DefaultTableModel miModelo = null;
        String Titulos[] = {"ID", "Contacto","Compañia","Correo","Domicilio","Rut","Telefono"};

        String dts[] = new String[7];
        String msg = "";
        miModelo = new DefaultTableModel(null, Titulos);
        try {
            CallableStatement cst = cn.prepareCall("{call olv_mostrarbuscar_proveedor(?)}");

            cst.setString(1, miProveedor.getRut());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("IdProveedor");
                dts[1] = rs.getString("Contacto");
                dts[2] = rs.getString("Compañia");
                dts[3] = rs.getString("Correo");
                dts[4] = rs.getString("Domicilio");
                dts[5] = rs.getString("Rut");
                dts[6] = rs.getString("Telefono");
                
                miModelo.addRow(dts);
            }
            msg = "si";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModelo;
    }

}
