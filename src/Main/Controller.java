/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ashik
 */
public class Controller {

    public void Login(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignUp(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Dashboard(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void SignOut(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
     @FXML
    private AnchorPane addmovie;

    @FXML
    private AnchorPane availablemovies;

    @FXML
    private AnchorPane customers;

    @FXML
    private AnchorPane dashboard;

    @FXML
    private AnchorPane editscreen;

    public void addmovie() {
        addmovie.setVisible(true);
        dashboard.setVisible(false);
        availablemovies.setVisible(false);
        editscreen.setVisible(false);
        customers.setVisible(false);
    }
    public void dashboard()
    {
        dashboard.setVisible(true);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(false);
        editscreen.setVisible(false);
        
    }
    public void avaiable()
    {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(true);
        customers.setVisible(false);
        editscreen.setVisible(false);
    }
    public void edit()
    {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(false);
        editscreen.setVisible(true);
    }
    public void customer()
    {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(true);
        editscreen.setVisible(false);
    }
    @FXML
    private AnchorPane ap;
    @FXML
    public void handleAction(ActionEvent event)
    {
        Stage stage = (Stage)ap.getScene().getWindow();
        stage.setIconified(true);
    }
    public void exit()
    {
        System.exit(0);
    }
}
