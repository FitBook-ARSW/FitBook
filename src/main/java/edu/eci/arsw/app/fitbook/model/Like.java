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
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int like_id;

    @Column(name = "mail")
    private int mail;

    @Column(name = "postid")
    private int postid;

    public Like() {
    }

    public Like(int like_id, int mail, int postid) {
        this.like_id = like_id;
        this.mail = mail;
        this.postid = postid;
    }

    public int getLike_id() {
        return this.like_id;
    }

    public void setLike_id(int id) {
        this.like_id = id;
    }

    public int getMail() {
        return this.mail;
    }

    public void setMail(int mail) {
        this.mail = mail;
    }

    public int getPostid() {
        return this.postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public Like like_id(int id) {
        setLike_id(like_id);
        return this;
    }

    public Like mail(int mail) {
        setMail(mail);
        return this;
    }

    public Like postid(int postid) {
        setPostid(postid);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getLike_id() + "'" +
            ", email='" + getMail() + "'" +
            ", postid='" + getPostid() + "'" +
            "}";
    }


}