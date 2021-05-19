package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idclase")
    private int idclase;

    @Column(name = "document")
    private String document;

    public Agenda(int idclase, String document){
        this.idclase = idclase;
        this.document = document;
    }

    public Agenda(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getIdclase(){
        return idclase;
    }

    public void setIdclase(int idclase){
        this.idclase = idclase;
    }

    public String getDocument(){
        return document;
    }

    public void setDocument(String document){
        this.document = document;
    }

}
