package edu.eci.arsw.app.fitbook.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publications")
public class Publication implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int publication_id;

    @Column(name = "content")
    public String content;

    @Column(name = "upload")
    public String uploadDate;

    @Column(name = "mail")
    public String mail;

    @Column(name = "imgUrl")
    public String imgUrl;

    public Publication() {

    }

    public Publication(String content, String mail) {
        this.content = content;
        this.mail = mail;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.uploadDate = formatter.format(date);
    }

    public Publication(int publication_id, String content, String mail, String imgUrl) {
        this.content = content;
        this.mail = mail;
        this.imgUrl = imgUrl;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.uploadDate = formatter.format(date);
    }

    public int getId() {
        return publication_id;
    }

    public void setId(int publication_id) {
        this.publication_id = publication_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUploaDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploaDate) {
        this.uploadDate = uploaDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
