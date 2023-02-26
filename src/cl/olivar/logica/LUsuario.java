/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.logica;

import cl.olivar.datos.DUsuario;
import static cl.olivar.logica.LConexion.cn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LUsuario {

//--------------------------------    Variables de Conexion           --------------------------------------    
    Connection cn = LConexion.getConection();

//--------------------------------    Metodo para guardar los Usuarios--------------------------------------
    public String InsertarUsuario(DUsuario miUser) {

        String msg = "";

        try {
            CallableStatement cst = cn.prepareCall("{call olv_insertart_usuario(?,?,?,?,?,?,?)}");

            cst.setString(1, miUser.getUsuario());
            cst.setString(2, miUser.getNombre());
            cst.setString(3, miUser.getApellido());
            cst.setString(4, miUser.getCorreo());
            cst.setString(5, miUser.getContraseña());
            cst.setString(6, miUser.getPerfil());
            cst.setString(7, miUser.getEstado());

            cst.executeUpdate();
            msg = "si";
        } catch (Exception e) {

            msg = "no";
            e.printStackTrace();
        }

        return msg;
    }
//--------------------------------Metodo para Actualiza  los Usuarios ---------------------------------------------

    public String EditarUsuario(DUsuario miUser) {

        String msg = "";

        try {
            CallableStatement cst = cn.prepareCall("{call olv_editar_usuario(?,?,?,?,?,?,?,?)}");
            cst.setInt(1, miUser.getId());
            cst.setString(2, miUser.getUsuario());
            cst.setString(3, miUser.getNombre());
            cst.setString(4, miUser.getApellido());
            cst.setString(5, miUser.getCorreo());
            cst.setString(6, miUser.getContraseña());
            cst.setString(7, miUser.getPerfil());
            cst.setString(8, miUser.getEstado());

            cst.executeUpdate();
            msg = "si";
        } catch (Exception e) {

            msg = "no";
            e.printStackTrace();
        }

        return msg;
    }
//--------------------------------Metodo para Eliminar  Usuarios de la tabla tablas--------------------------------
    
    public String EliminarUsuario(DUsuario miUsuario){
        String msg="";
        try {
            CallableStatement cst=cn.prepareCall("{call olv_eliminar_usuario(?)}");
            
            cst.setInt(1, miUsuario.getId());
            
            cst.executeUpdate();
            msg="si";
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return msg;
    }
//--------------------------------Metodo para Mostrar  los Usuarios en tablas--------------------------------------   
    
    public DefaultTableModel MostUsuario(DUsuario MiUsuario) {

        DefaultTableModel miModulo = null;

        try {
            String Titulos[] = {"ID","Usuario", "Nombre", "Apellido", "Correo", "Contraseña", "perfil", "Estado"};

            String dts[] = new String[8];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = cn.prepareCall("{ call olv_mostrarbuscar_usuario(?)}");
            cst.setString(1, MiUsuario.getUsuario());
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                dts[0] = rs.getString("IdUsuario");
                dts[1] = rs.getString("Usuario");
                dts[2] = rs.getString("Nombre");
                dts[3] = rs.getString("Apellido");
                dts[4] = rs.getString("Correo");
                dts[5] = "******";
                dts[6] = rs.getString("perfil");
                dts[7] = rs.getString("Estado");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return miModulo;
    }

}
