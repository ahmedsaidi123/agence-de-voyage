/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Categorie;
import entity.Evennement;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import services.CategorieCRUD;
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AddCategorieController implements Initializable {

    @FXML
    private TextField nom_cat;
    @FXML
    private TextField desc_cat;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TableView<Categorie> tabv;
   // private TableColumn<Categorie, Integer> idtabv;
    @FXML
    private TableColumn<Categorie, String> nomtabv;
    @FXML
    private TableColumn<Categorie, String> desctabv;
 
    CategorieCRUD pcr=new CategorieCRUD();
    int id;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupp;
    @FXML
    private TextField textrechercher;
    @FXML
    private ImageView imcat;
    @FXML
    private ImageView destimgg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
showCategorie();
search_cat() ;
    }    

    @FXML
    private void AjouterCategorie(ActionEvent event) {
         try
        {
            if(testSaisie())
            {
                
            
        //save Msg in DATA BASE
       String rnom = nom_cat.getText();
       String rdescription = desc_cat.getText();
        Categorie c= new Categorie(rnom,rdescription);
        CategorieCRUD cat= new CategorieCRUD();
        cat.addCategorie(c);
        // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Categorie!");
              a.setHeaderText(null);
              a.setContentText("Categorie ajouté !!!");
              a.showAndWait();
            
            //*********
            
            }
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
             
             showCategorie();          

    
}
    
    
    public void showCategorie() {
        System.out.println("DEBUGG!!!!");
        ObservableList<Categorie> list =pcr.getCategorie();
        //   System.out.println(pcr.getSujet().toString());
        //ObservableList<Product> list = FXCollections.observableList(pcd.getProductList());
     //   idtabv.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        //idcreateurtab.setCellValueFactory(new PropertyValueFactory<Sujet, String>("id_createur"));
        nomtabv.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom"));
     //   dateposttab.setCellValueFactory(new PropertyValueFactory<Sujet, Date>("date_heure_creation"));
        desctabv.setCellValueFactory(new PropertyValueFactory<Categorie, String>("description"));
   
        
        tabv.setItems(list);
        search_cat();
        
    }

    @FXML
    private void ModifierCat(ActionEvent event) {
        
        try {
            String requete = "UPDATE Categorie SET nom=?,description=?  WHERE id="+id+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
         
            pst.setString(1, nom_cat.getText());
            pst.setString(2, desc_cat.getText());
           
            pst.executeUpdate();
            // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Categorie!");
              a.setHeaderText(null);
              a.setContentText("Categorie Modifié !!!");
              a.showAndWait();
            
            //*********
            
            System.out.println("Categorie modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showCategorie();
    }

    @FXML
    private void Supprimercat(ActionEvent event) {
         try {
            String requete = "DELETE FROM Categorie WHERE id="+id+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            pst.executeUpdate();
            // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Categorie!");
              a.setHeaderText(null);
              a.setContentText("Categorie supprimé !!!");
              a.showAndWait();
              
            
            //*********
            
            System.out.println("Categorie supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showCategorie(); 
        
    }

    @FXML
    private void SetValue(MouseEvent event) {
         Categorie selected = tabv.getSelectionModel().getSelectedItem();
        if (selected != null) {
         
          //  String idsujettab = String.valueOf(selected.getId_suj());
            
           // tfprixP.setText(Sprix);
            
            nom_cat.setText(selected.getNom());
            desc_cat.setText(selected.getDescription());
            id = selected.getId();
        }
    }
    
    
    
 void search_cat() {          
   nomtabv.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom"));
     //   dateposttab.setCellValueFactory(new PropertyValueFactory<Sujet, Date>("date_heure_creation"));
        desctabv.setCellValueFactory(new PropertyValueFactory<Categorie, String>("description"));
   
        String requete="select * from Categorie where nom=?";
        try{
             PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, textrechercher.getText());
            pst.executeQuery();
            
            
            ObservableList<Categorie> dataList = pcr.getCategorie();
                tabv.setItems(dataList);
        FilteredList<Categorie> filteredData = new FilteredList<>(dataList, b -> true);  
 textrechercher.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(message -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (message.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } 
  
        
    
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Categorie> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tabv.comparatorProperty());  
  tabv.setItems(sortedData);      
        }catch(Exception e){
            System.out.println(e);
        }
       
   
        
        
        
        
        

        
    }
 
 private Boolean testSaisie() {
       
         String erreur = "";
         
       
        if (!testNom()) {
            erreur = erreur + ("Veuillez verifier votre Nom: seulement des caractères et de nombre >= 3 \n");
        }
       
            
        /*
            
if (!testPrenom()) {
            erreur = erreur + ("Veuillez verifier votre Prenom: seulement des caractères et de nombre >= 3");
        }
        if (!testemail()) {
            erreur = erreur + ("Veuillez verifier que votre adresse email est de la forme : **@**.** \n");
        }
*/        

        if  ((!testNom())) {
           
           
           
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de format");
        alert.setHeaderText("Vérifier les champs");
        alert.setContentText(erreur);
       alert.showAndWait();
       
        }

        return  testNom() ;
    }

  private boolean testNom() {
     
        int nbNonChar = 0;
        for (int i = 1; i < nom_cat.getText().trim().length(); i++) {
            char ch = nom_cat.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && nom_cat.getText().trim().length() >= 3) {
          imcat.setImage(new Image("image/checkmark.png"));
            return true;
        } else {
           imcat.setImage(new Image("image/alertemark.png"));
               
            return false;

        }
        
    }

    @FXML
    private void nomcat(KeyEvent event) {
    }

    @FXML
    private void dest(KeyEvent event) {
    }
        
    






}



