package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "boxid")
    private Integer boxId;

    @Column(name = "url")
    private String url;

    public User() {

    }

    public User(String fullName, String email, String role, Integer boxId, String cedula, String url) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.cedula = cedula;
        this.boxId = boxId;
        this.url = url;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCc(String cedula) {
        this.cedula = cedula;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}
