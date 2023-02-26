/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.logica;

import cl.olivar.datos.DLineas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL
 */
public class LLineas {

    Connection cn = LConexion.getConection();

    public String InsertarLineas(DLineas miLina) {

        String msg = "";

        try {

            CallableStatement cst = cn.prepareCall("{call olv_insertar_lineas(?)}");

            cst.setString(1, miLina.getLineas());

            cst.executeUpdate();

            msg = "si";
        } catch (Exception e) {

            e.printStackTrace();

        }

        return msg;
    }
    public int EditarLineas(DLineas miLina) {

        int msg = 0;

        try {

            CallableStatement cst = cn.prepareCall("{call olv_editar_linea(?,?)}");
           
            cst.setInt(1, miLina.getIdLineas());
            cst.setString(2, miLina.getLineas());
            
            cst.executeUpdate();

            msg = 1;
        } catch (Exception e) {

            e.printStackTrace();

        }

        return msg;
    }
   public int EliminarLineas(DLineas miLina) {
         int idlinea=0;

        try {

            CallableStatement cst = cn.prepareCall("{call olv_eliminar_linea(?)}");

            cst.setInt(1, miLina.getIdLineas());

            cst.executeUpdate();
            
//            ResultSet rs=cst.executeQuery();
//            
//            while(rs.next()){
//                idlinea=rs.getInt("IdLineas");
//            }
          
        idlinea=1;
        } catch (Exception e) {

            e.printStackTrace();
            
        }

        return idlinea;
    }

    public DefaultTableModel MostrarBuscarLinea(DLineas miLinea) {

        DefaultTableModel miModelo = null;
        String Titulos[] = {"ID", "Linea"};

        String dts[] = new String[2];
        String msg = "";
        miModelo = new DefaultTableModel(null, Titulos);
        try {
            CallableStatement cst = cn.prepareCall("{call olv_mostrarbuscar_lineas(?)}");

            cst.setString(1, miLinea.getLineas());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("IdLineas");
                dts[1] = rs.getString("Linea");

                miModelo.addRow(dts);
            }
            msg = "si";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModelo;
    }

 
}
