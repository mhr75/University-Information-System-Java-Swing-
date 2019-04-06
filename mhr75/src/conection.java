

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class conection implements Serializable{
    public Connection con;
    
    
    public conection(Connection c)
    {
        con=c;
    }
}
