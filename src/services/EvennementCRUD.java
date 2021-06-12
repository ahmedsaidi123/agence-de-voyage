/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Categorie;
import entity.Evennement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.MyConnection;

/**
 *
 * @author Msi
 */
public class EvennementCRUD {
    public void addEvent (Evennement e) throws SQLException{
    try{
        String requete = "INSERT INTO Event (image,nom,destination,prix,nbr_places,dateev)"
                + "VALUES(?,?,?,?,?,?)" ;
           PreparedStatement pst =
            new MyConnection().cn.prepareStatement(requete);
           
            pst.setString(1,e.getImg());
    pst.setString(2,e.getNom());
    pst.setString(3,e.getDestination());
     pst.setString(4,Float.toString(e.getPrix()));
      pst.setString(5,String.valueOf(e.getNbrplaces()));
    
     
Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String s = formatter.format(e.getDateev());
  pst.setString(6,s);

  
    pst.executeUpdate();
    System.out.println("evennement ajoutée!");




    }
    catch (SQLException ex) {
            Logger.getLogger(EvennementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     
     
     
     public ObservableList<Evennement> getEvennement() {

        ObservableList<Evennement> EvennementList = FXCollections.observableArrayList();
        String requete = "SELECT * FROM Event ";
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
                Evennement e = new Evennement();

                while (rs.next()) {
              /*
                    Image img = new Image(rs.getString("image"));
            ImageView imageView = new ImageView();
            imageView.setImage(img);
           
            imageView.setFitWidth(130);
            imageView.setFitHeight(100);
                */     
                   Evennement event = new Evennement(rs.getInt("id"), rs.getString("nom"), rs.getString("destination"),rs.getFloat("prix"),rs.getInt("nbr_places"),rs.getDate("dateev"),rs.getString("image"));
            
                    
                    EvennementList.add(event);
                }

            } catch (Exception ex) {
                //System.out.println("AHAYYYAA L7KEEEYAAAAA!!!!");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvennementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return EvennementList;
    }
     
      public ObservableList<String> showNumbers() {

        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            //String requete = "SELECT COUNT(*) AS n FROM event GROUP BY month(dateev) ORDER BY month(dateev) ";
             String requete = "SELECT year(dateev) as y,month(dateev) as m ,COUNT(*) AS n FROM event GROUP BY month(dateev),year(dateev) ORDER BY month(dateev) ";
           //String requete = "SELECT year(dateev) ,dateev, COUNT(*) AS n FROM event GROUP BY month(dateev),year(dateev) ORDER BY month(dateev)  ";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("y"));
              Integer S =  rs.getInt("n");
              Integer m1=Integer.parseInt(rs.getString("m"));
              String ch = S.toString();
              
              String ch1=String.valueOf(rs.getInt("n"));
              String ch2=(ch1.concat("  evennement "));
              String ch3=ch2.concat(rs.getString("y"));
              if(m1==1)
              {
                  list.add((ch1.concat("  evennement dans le mois de janvier" )).concat(rs.getString("y")));
              }
              else if(m1==2)
              {
               list.add((ch1.concat("  evennement dans le mois de fevrier" )).concat(rs.getString("y")));
              }
              else if(m1==3)
              {
               list.add((ch1.concat("  evennement dans le mois de mars" )).concat(rs.getString("y")));
              }
              else if(m1==4)
              {
               list.add((ch1.concat("  evennement dans le mois de avril" )).concat(rs.getString("y")));
              }
              else if(m1==5)
              {
               list.add((ch1.concat("  evennement dans le mois de mai" )).concat(rs.getString("y")));
              }
              else if(m1==6)
              {
               list.add((ch1.concat("  evennement dans le mois de juin" )).concat(rs.getString("y")));
              }
              else if(m1==7)
              {
               list.add((ch1.concat("  evennement dans le mois de Juillet" )).concat(rs.getString("y")));
              }
              else if(m1==8)
              {
               list.add((ch1.concat("  evennement dans le mois de Aout" )).concat(rs.getString("y")));
              }
              else if(m1==9)
              {
               list.add((ch1.concat("  evennement dans le mois de Septembre" )).concat(rs.getString("y")));
              }
              else if(m1==10)
              {
               list.add((ch1.concat("  evennement dans le mois de Octobre" )).concat(rs.getString("y")));
              }
                else if(m1==11)
              {
               list.add((ch1.concat("  evennement dans le mois de Novembre" )).concat(rs.getString("y")));
              }
              else 
              {
               list.add((ch1.concat("  evennement dans le mois de Decembre" )).concat(rs.getString("y")));
              }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;



    }
    
}
