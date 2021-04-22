package edu.eci.arsw.app.fitbook.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "userid")
    private int userid;

    @Column(name = "postid")
    private int postid;

    public Like() {
    }

    public Like(int id, int userid, int postid) {
        this.id = id;
        this.userid = userid;
        this.postid = postid;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPostid() {
        return this.postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public Like id(int id) {
        setId(id);
        return this;
    }

    public Like userid(int userid) {
        setUserid(userid);
        return this;
    }

    public Like postid(int postid) {
        setPostid(postid);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userid='" + getUserid() + "'" +
            ", postid='" + getPostid() + "'" +
            "}";
    }


}