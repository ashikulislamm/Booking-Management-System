/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root); 
        Image image = new Image("/icons/integrated-system.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Booking Management System");
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
