/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Msi
 */
public class MyConnection {
       public String url="jdbc:mysql://localhost:3306/devahmed";
    public String login="root";
    public String pwd="";
    public Connection cn;

    public MyConnection() {
        try {
          cn = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion");
            System.out.println(ex.getMessage());
            
        }
        
    }
}
