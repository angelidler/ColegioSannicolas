/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.logica;

import cl.olivar.datos.DCursos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL
 */
public class LCursos {

    private Connection cn = LConexion.getConection();

    public String InsertarCurso(DCursos miCurso) {

        String msg = "";
        try {

            CallableStatement cst = cn.prepareCall("{call olv_insertar_curso(?,?)");

            cst.setString(1, miCurso.getCurso());
            cst.setString(2, miCurso.getProfesor());

            msg = "Datos Guardados";
        } catch (Exception e) {

            e.printStackTrace();

        }

        return msg;

    }

    public String EditartCurso(DCursos miCurso) {
        String msg = "";

        try {
            CallableStatement cst = cn.prepareCall("{call olv_editar_curso(?,?,?)");

            cst.setInt(1, miCurso.getIdCurso());
            cst.setString(3, miCurso.getCurso());
            cst.setString(2, miCurso.getProfesor());

            msg = "Datos Editados";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public String EliminarCurso(DCursos miCurso) {
        String msg = "";

        try {
            CallableStatement cst = cn.prepareCall("{call olv_eliminar_curso(?)");

            cst.setInt(1, miCurso.getIdCurso());

            msg = "Datos Eliminados";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public DefaultTableModel MostrarBuscarCurso(DCursos miCurso) {

        DefaultTableModel miModelo;

        String[] Titulos = {"ID", "Curso", "Profesor Encargado"};

        String[] datos = new String[4];
        
        miModelo=new DefaultTableModel(null, Titulos);
        try {
            CallableStatement cst = cn.prepareCall("{call olv_mostrarbusar_curso(?)");

            cst.setString(1, miCurso.getCurso());

            ResultSet rs=cst.executeQuery();
            
            while(rs.next()){
                datos[0]=rs.getString("IdCurso");
                datos[1]=rs.getString("Curso");
                datos[2]=rs.getString("profesor");
                miModelo.addRow(datos);
            }
            
        } catch (Exception e) {
        }
        return miModelo;

    }

}
