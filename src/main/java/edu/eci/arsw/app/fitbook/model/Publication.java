package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "publications")
public class Publication implements Serializable{
    

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int publication_id;

    @Column(name = "content")
    public String content;

    @Column(name = "user_id")
    public int userId;

    @Column(name = "likes")
    public int likes;

    @Column(name = "uploaddate")
    public Timestamp uploaDate;

    @Column(name = "mail")
    public String mail;

    public Publication(){

    }

    public Publication(String content, String mail, int likes){
        this.content = content;
        this.mail = mail;
        this.likes = likes;
        this.uploaDate = new Timestamp(System.currentTimeMillis());
    }

    public Publication(int publication_id, String content, int likes, String mail){
        this.content = content;
        this.mail = mail;
        this.likes = likes;
        this.uploaDate = new Timestamp(System.currentTimeMillis());
    }

    public int getId(){
        return publication_id;
    }

    public void setId(int publication_id){
        this.publication_id = publication_id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getLikes(){
        return likes;
    }

    public void setLikes(int likes){
        this.likes = likes;
    }

    public Timestamp getUploaDate(){
        return uploaDate;
    }

    public void setUploadDate(Timestamp uploaDate){
        this.uploaDate = uploaDate;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

}
