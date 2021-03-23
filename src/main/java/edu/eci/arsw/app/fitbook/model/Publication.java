package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;
import java.util.Date;

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
    private int publication_id;

    @Column(name = "content")
    public String content;

    @Column(name = "user_id")
    public int userId;

    @Column(name = "likes")
    public int likes;

    @Column(name = "uploaddate")
    public Date uploaDate;

    public Publication(){

    }

    public Publication(String content, int userId, int likes, Date uploaDate){
        this.content = content;
        this.userId = userId;
        this.likes = likes;
        this.uploaDate = uploaDate;
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

    public Date getUploaDate(){
        return uploaDate;
    }

    public void setUploadDate(Date uploaDate){
        this.uploaDate = uploaDate;
    }


}
