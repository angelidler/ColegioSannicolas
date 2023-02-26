/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Tecnico
 */
public class LConexion {

    private static final String Driver = "org.gjt.mm.mysql.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/dbinventario";

    static Connection cn = null;

    public static Connection getConection() {

        try {
            cn = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return cn;
    }
// ------------------------------Borrar metodo main al terminar el programa este es solo para provar-----------------
    public static void main(String[] args) {

        String clave="123";
        
        String ocultar=DigestUtils.shaHex(clave);
        
        System.out.println(ocultar);
    }
}
