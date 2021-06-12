/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Msi
 */
public class Reservation_event {
    private int id;
    private int nbr_participant;
    Date date_reservation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbr_participant() {
        return nbr_participant;
    }

    public void setNbr_participant(int nbr_participant) {
        this.nbr_participant = nbr_participant;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public Reservation_event() {
    }
    

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public Reservation_event(int id, int nbr_participant, Date date_reservation) {
        this.id = id;
        this.nbr_participant = nbr_participant;
        this.date_reservation = date_reservation;
    }
    
    
    
    
}
