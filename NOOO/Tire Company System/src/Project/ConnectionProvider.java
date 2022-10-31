/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
    *
 * @author ENDUSER
 */
public class ConnectionProvider {
    public  Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//tire company management system
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tcms","root","");
            return con;
        }
        catch(Exception e)
            //JOptionPane.showMessageDialog(null, "Error en la conexion");
        {
            return null;
        }
    }
            
    
}
