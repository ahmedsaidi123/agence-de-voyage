/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import javafx.scene.image.ImageView;

/**
 *
 * @author Msi
 */
public class Evennement {

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evennement other = (Evennement) obj;
        if (!Objects.equals(this.dateev, other.dateev)) {
            return false;
        }
        return true;
    }
    private int id;
    private int nbrplaces;
    private float prix;
    String nom;
    String destination;
    String img;
ImageView imgg;
String cat;

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public ImageView getImgg() {
        return imgg;
    }

    public void setImgg(ImageView imgg) {
        this.imgg = imgg;
    }
    public String getImg() {
        return img;
    }

    public void setImage(String image) {
        this.img = img;
    }
    Date dateev;
    public Evennement() {
    }

    public Evennement(int id, int nbrplaces, float prix, String nom, String destination) {
        this.id = id;
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
    }
    

    public Date getDateev() {
        return dateev;
    }

    public void setDateev(Date dateev) {
        this.dateev = dateev;
    }
    
    public Evennement(int id, String nom, String destination, float prix, int nbrplaces) {
        this.id = id;
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
        this.nbrplaces = nbrplaces;
        
        
    }
    public Evennement(int id, String nom, String destination, float prix, int nbrplaces,String img) {
        this.id = id;
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
        this.nbrplaces = nbrplaces;
        this.img=img;
        
        
    }

    public Evennement(int id, String nom, String destination,float prix,int nbrplaces, Date dateev) {
        this.id = id;
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev = dateev;
    }
     public Evennement(int id, String nom, String destination,float prix,int nbrplaces, Date dateev,String img) {
        this.id = id;
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev = dateev;
        this.img=img;
    }
 public Evennement(int id, String nom, String destination,float prix,int nbrplaces, Date dateev,ImageView imgg) {
        this.id = id;
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev = dateev;
        this.imgg=imgg;
    }
    public int getId() {
        return id;
    }

    public Evennement(int nbrplaces, float prix, String nom, String destination,Date dateev) {
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev=dateev;
    }
      public Evennement(int nbrplaces, float prix, String nom, String destination,Date dateev,String img) {
        this.nbrplaces = nbrplaces;
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev=dateev;
        this.img=img;
    }
      public Evennement(String cat,int nbrplaces, float prix, String nom, String destination,Date dateev,String img) {
        this.cat=cat;
          this.nbrplaces = nbrplaces;
        
        this.prix = prix;
        this.nom = nom;
        this.destination = destination;
        this.dateev=dateev;
        this.img=img;
    }
    
    

    
    public void setId(int id) {
        this.id = id;
    }

    public int getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(int nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Evennement{" + "dateev=" + dateev + '}';
    }

    
    
    
}
