/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ashik
 */
public class database {

    private static Connection con;

    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/booking", "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
