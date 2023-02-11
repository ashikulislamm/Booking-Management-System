/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Main;
import java.sql.Date;
/**
 *
 * @author ashik
 */
public class moviesData {
    private Integer id;
    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;
    private String current;
    
    public moviesData(int id, String title, String genre, String duration, String image, Date date,String current)
    {
        this.id=id;
        this.title=title;
        this.genre=genre;
        this.duration=duration;
        this.image=image;
        this.date=date;
        this.current=current;
    }

    public String getCurrent() {
        return current;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }


    
}
