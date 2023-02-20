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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

/**
 *
 * @author ashik
 */
public class Controller {

    ///Login SignUp Button Controls
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

    //Databse Controlls
    @FXML
    private PasswordField login_password;

    @FXML
    private TextField username;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Connection con;
    private Connection connect;
    Alert alert;

    public void Dashboard(ActionEvent event) throws IOException {

        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, login_password.getText());

            result = prepare.executeQuery();

            if (username.getText().isEmpty() || login_password.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    getData.uname = username.getText();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username/password");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    private TextField signup_email;

    @FXML
    private PasswordField signup_password;

    @FXML
    private TextField signup_username;

    public boolean validEmail() {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher match = pattern.matcher(signup_email.getText());

        if (match.find() && match.group().equals(signup_email.getText())) {
            return true;
        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR MESSAGE !");
            alert.setHeaderText(null);
            alert.setContentText("Invalid mail");
            alert.showAndWait();
            return false;
        }
    }

    public void backtToLogin(ActionEvent event) throws IOException {
        String sql = "INSERT INTO admin (username,password,email) VALUEs (?, ?, ?)";
        String sql1 = "SELECT * FROM admin";
        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signup_username.getText());
            prepare.setString(2, signup_password.getText());
            prepare.setString(3, signup_email.getText());

            if (signup_username.getText().isEmpty() || signup_password.getText().isEmpty() || signup_email.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (signup_password.getText().length() < 8) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Password is too weak !");
                alert.showAndWait();
            } else {

                if (validEmail()) {

                    prepare = connect.prepareStatement(sql1);
                    result = prepare.executeQuery();
                    if (result.next()) {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("ERROR MESSAGE");
                        alert.setHeaderText(null);
                        alert.setContentText("username " + signup_username.getText() + " is alerady exists");
                        alert.showAndWait();
                    } else {
                        prepare.execute();
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("INFORMATION MESSAGE");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Created New Account !");
                        alert.showAndWait();

                        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
