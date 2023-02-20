/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author ashik
 */
public class customerData {
    private int id;
    private String type;
    private String title;
    private int qty;
    private double total;
    private Date date;
    private Time time;
    
    
    public customerData(Integer id , String type,String title,int qty,double total,Date date,Time time)
    {
        this.id=id;
        this.type=type;
        this.title=title;
        this.qty=qty;
        this.total=total;
        this.date=date;
        this.time=time;
    }

    public String getTitle() {
        return title;
    }

    public Time getTime() {
        return time;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getQty() {
        return qty;
    }

    public double getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }
    
}
