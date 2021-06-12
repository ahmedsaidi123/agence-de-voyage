/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author Msi
 */
public class CategorieCRUD {

   public void addCategorie (Categorie c) throws SQLException{
    try{
        String requete = "INSERT INTO Categorie (nom,description)"
                + "VALUES(?,?)" ;
           PreparedStatement pst =
            new MyConnection().cn.prepareStatement(requete);
    pst.setString(1,c.getNom());
    pst.setString(2,c.getDescription());


  
    pst.executeUpdate();
    System.out.println("categorie ajoutée!");




    }
    catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
   public ObservableList<Categorie> getCategorie() {

        ObservableList<Categorie> CategorieList = FXCollections.observableArrayList();
        String requete = "SELECT * FROM Categorie ";
        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            //Statement st;
            ResultSet rs;
            try {
                //System.out.println("AHAYYYAA!!!!");
                //st=conn.createStatement();
                //System.out.println("AHAYYYAA222!!!!");
                rs = pst.executeQuery(requete);
                Categorie c;

                while (rs.next()) {
                   Categorie cat = new Categorie(rs.getInt("id"), rs.getString("nom"), rs.getString("description"));
               //   Sujet suj = new Sujet(rs.getString("id_suj"));
                    
                    CategorieList.add(cat);
                }

            } catch (Exception ex) {
                //System.out.println("AHAYYYAA L7KEEEYAAAAA!!!!");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return CategorieList;
    }
    
}
