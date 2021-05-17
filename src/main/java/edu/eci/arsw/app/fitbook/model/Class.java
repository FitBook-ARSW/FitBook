package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clase")
public class Class implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "beginclass")
    private String beginclass;

    @Column(name = "max")
    private int max;
    
    @Column(name = "document")
    private String document;

    public Class(String begin, int max, String document){
        this.beginclass = begin;
        this.max = max;
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getId() {
        return id;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public String getBeginClass() {
        return beginclass;
    }
    public void setBegin(String begin) {
        this.beginclass = begin;
    }
    public void setId(int id) {
        this.id = id;
    }
}
