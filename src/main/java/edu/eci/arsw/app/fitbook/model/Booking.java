package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Booking implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idreserva;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "fecha")
    private String fecha;

    public Booking(){

    }

    public Booking(int iduser, String fecha){
        this.iduser = iduser;
        this.fecha = fecha;
    }


    public int getIdreserva() {
        return this.idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIduser() {
        return this.iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
