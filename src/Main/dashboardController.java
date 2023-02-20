/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

//import javafx.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.sql.Time;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 *
 * @author ashik
 */
public class dashboardController implements Initializable {

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

        showAddMoviesList();
    }

    public void dashboard() {
        dashboard.setVisible(true);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(false);
        editscreen.setVisible(false);
        
        displayTotalSOldTicket();
        displayTotalAvaiableMovie();
        displayTotalIncome();

    }

    public void avaiable() {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(true);
        customers.setVisible(false);
        editscreen.setVisible(false);

        showAvailableMovies();
    }

    public void edit() {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(false);
        editscreen.setVisible(true);
        showEditScreening();
    }

    public void customer() {
        dashboard.setVisible(false);
        addmovie.setVisible(false);
        availablemovies.setVisible(false);
        customers.setVisible(true);
        editscreen.setVisible(false);

        showCustomerList();

    }

    ///Main Dashboard Controlls
    //For Add Movies
    @FXML
    private Button addMovie_Clear;

    @FXML
    private DatePicker addMovie_Date;

    @FXML
    private Button addMovie_Delete;

    @FXML
    private TextField addMovie_Duration;

    @FXML
    private TextField addMovie_Genre;

    @FXML
    private TextField addMovie_Search;

    @FXML
    private TableView<moviesData> addMovie_TableView;

    @FXML
    private TextField addMovie_Title;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_Date;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_Duration;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_Genre;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_title;

    @FXML
    private Button addMovie_import;

    @FXML
    private Button addMovie_insert;

    @FXML
    private ImageView addMovie_poster;

    @FXML
    private Button addMovie_update;

    @FXML
    private AnchorPane ap;

    @FXML
    private Button availableMovie_Buy;

    @FXML
    private Button availableMovie_Clear;

    @FXML
    private Label availableMovie_Date;

    @FXML
    private Label availableMovie_Genre;

    @FXML
    private ImageView availableMovie_Imageview;

    @FXML
    private Label availableMovie_Label;

    @FXML
    private Label availableMovie_PremiumPrice;

    @FXML
    private Spinner<Integer> availableMovie_PremiumQuantity;

    @FXML
    private Button availableMovie_Recipt;

    @FXML
    private Button availableMovie_Select;

    @FXML
    private TableView<moviesData> availablemovies_tableView;

    @FXML
    private TableColumn<moviesData, String> availableMovie_Table_Date;

    @FXML
    private TableColumn<moviesData, String> availableMovie_Table_Genre;

    @FXML
    private TableColumn<moviesData, String> availableMovie_Table_Title;

    @FXML
    private Label availableMovie_Title;

    @FXML
    private Label availableMovie_TotalPrice;

    @FXML
    private Label availableMovie_regularPrice;

    @FXML
    private Spinner<Integer> availableMovie_regularQuantity;

    @FXML
    private Label availablemovie;

    @FXML
    private TextField customer_Date;

    @FXML
    private Button customer_Delete;

    @FXML
    private TextField customer_Payment;

    @FXML
    private TextField customer_Search;

    @FXML
    private TableView<customerData> customer_Table;

    @FXML
    private TableColumn<customerData, String> customer_Table_Date;

    @FXML
    private TableColumn<customerData, String> customer_Table_TicketNo;

    @FXML
    private TableColumn<customerData, String> customer_Table_Time;

    @FXML
    private TableColumn<customerData, String> customer_Table_Title;

    @FXML
    private TextField customer_Time;

    @FXML
    private TextField customer_Title;

    @FXML
    private Button customer_clear;

    @FXML
    private TextField customer_ticketNo;

    @FXML
    private Label dashboard_username;

    @FXML
    private ComboBox<?> editScreen_Current;

    @FXML
    private ImageView editScreen_ImageView;

    @FXML
    private TextField editScreen_Search;

    @FXML
    private TableView<moviesData> addScreening_tableView;

    @FXML
    private TableColumn<moviesData, String> editScreen_Table_Current;

    @FXML
    private TableColumn<moviesData, String> editScreen_Table_Duration;

    @FXML
    private TableColumn<moviesData, String> editScreen_Table_Genre;

    @FXML
    private TableColumn<moviesData, String> editScreen_Table_Title;

    @FXML
    private Label editScreen_Title;

    @FXML
    private Button editScreen_Update;

    @FXML
    private Button editScreen_delete;

    @FXML
    private Label totalearning;

    @FXML
    private Label totalsoldticket;

    Alert alert;
    private Connection connect;

    private Image image;
    //Database Tools
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Connection con;

    //Add Movies////////////////////////////////////////////////////////////////////////////////
    public ObservableList<moviesData> addMovieslist() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie";
        try {

            con = database.connectDb();
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();
            moviesData mvD;
            while (result.next()) {
                mvD = new moviesData(result.getInt("id"), result.getString("movieTitle"),
                        result.getString("genre"), result.getString("duration"),
                        result.getString("image"), result.getDate("date"),
                        result.getString("current"));
                listData.add(mvD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }
    private int countId;

    public void movieId() {
        String sql = "SELECT count(id) FROM movie";
        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                getData.movieId = result.getInt("count(id)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMovieslist();

        addMovie_col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovie_col_Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovie_col_Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovie_col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovie_TableView.setItems(listAddMovies);

    }

    public void selectAddMovieList() {
        moviesData mvD = addMovie_TableView.getSelectionModel().getSelectedItem();
        int num = addMovie_TableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = mvD.getImage();
        getData.movieId = mvD.getId();
        addMovie_Title.setText(mvD.getTitle());
        addMovie_Genre.setText(mvD.getGenre());
        addMovie_Duration.setText(mvD.getDuration());
        String getDate = String.valueOf(mvD.getDate());
        addMovie_Date.setValue(mvD.getDate().toLocalDate());
        String uri = "file:" + mvD.getImage();
        image = new Image(uri, 185, 220, false, true);
        addMovie_poster.setImage(image);

    }

    public void importImage() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*png", "*jpg"));

        Stage stage = (Stage) addmovie.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {

            image = new Image(file.toURI().toString(), 185, 220, false, true);

            addMovie_poster.setImage(image);
            //Taking the image path
            getData.path = file.getAbsolutePath();

        }

    }

    public void searchAddMovie() {
        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);
        addMovie_Search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMoviesData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String keySearch = newValue.toLowerCase();
                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }

                return false;

            });
            SortedList<moviesData> sortData = new SortedList<>(filter);
            sortData.comparatorProperty().bind(addMovie_TableView.comparatorProperty());
            addMovie_TableView.setItems(sortData);

        });

    }

    public void clearAddMovie() {
        addMovie_Title.setText("");
        addMovie_Genre.setText("");
        addMovie_poster.setImage(null);
        addMovie_Duration.setText("");
        addMovie_Date.setValue(null);
    }

    public void deleteMovie() {
        String sql = "DELETE FROM movie WHERE movieTitle = '" + addMovie_Title.getText() + "'";
        connect = database.connectDb();
        try {
            statement = connect.createStatement();
            if (addMovie_Title.getText().isEmpty() || addMovie_Genre.getText().isEmpty() || addMovie_Duration.getText().isEmpty() || addMovie_Date.getValue() == null || addMovie_poster.getImage() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText(" Please select the movie first!");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirm deletion ?");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete " + addMovie_Title.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (ButtonType.OK.equals(option.get())) {

                    statement.executeUpdate(sql);

                    showAddMoviesList();
                    clearAddMovie();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText(" Successfully Deleted !");
                    alert.showAndWait();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertAddMovie() {

        String sql1 = "SELECT * FROM movie WHERE movieTitle = '" + addMovie_Title.getText() + "'";

        connect = database.connectDb();
        try {

            statement = connect.createStatement();
            result = statement.executeQuery(sql1);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText(addMovie_Title.getText() + " already exists!");
                alert.showAndWait();
            } else {
                if (addMovie_Title.getText().isEmpty() || addMovie_Genre.getText().isEmpty() || addMovie_Duration.getText().isEmpty() || addMovie_poster.getImage() == null || addMovie_Date.getValue() == null) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Fill blank fileds !");
                    alert.showAndWait();
                } else {
                    String sql = "INSERT INTO movie (id,movieTitle,genre,duration,image,date) VALUES (?,?,?,?,?,?)";

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    movieId();
                    String mID = String.valueOf(getData.movieId + 1);

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, mID);
                    prepare.setString(2, addMovie_Title.getText());
                    prepare.setString(3, addMovie_Genre.getText());
                    prepare.setString(4, addMovie_Duration.getText());
                    prepare.setString(5, uri);
                    prepare.setString(6, String.valueOf(addMovie_Date.getValue()));

                    prepare.execute();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    clearAddMovie();
                    showAddMoviesList();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAddMovies() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");
        String sql = "UPDATE movie SET movieTitle = '" + addMovie_Title.getText() + "', genre = '" + addMovie_Genre.getText() + "', duration = '" + addMovie_Duration.getText() + "', image = '" + uri + "', date = '" + addMovie_Date.getValue() + "' WHERE id = '" + String.valueOf(getData.movieId) + "'";

        connect = database.connectDb();
        try {

            statement = connect.createStatement();
            if (addMovie_Title.getText().isEmpty() || addMovie_Genre.getText().isEmpty() || addMovie_Duration.getText().isEmpty() || addMovie_poster.getImage() == null || addMovie_Date.getValue() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {
                statement.execute(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("INFORMATION MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated " + addMovie_Title.getText() + " !");
                alert.showAndWait();

                showAddMoviesList();
                clearAddMovie();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    ///Customer

    public ObservableList<customerData> customerList() {
        ObservableList<customerData> customerL = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";

        connect = database.connectDb();
        customerData cusD;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                cusD = new customerData(result.getInt("id"),
                        result.getString("type"),
                        result.getString("movieTitle"),
                        result.getInt("quantity"),
                        result.getDouble("total"),
                        result.getDate("date"), result.getTime("time"));

                customerL.add(cusD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerL;
    }

    private ObservableList<customerData> custList;

    public void searchCustomer() {
        FilteredList<customerData> filter = new FilteredList<>(custList, e -> true);

        customer_Search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateCustomer -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (predicateCustomer.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getDate().toString().contains(searchKey)) {
                    return true;
                } 

                return false;

            });
            SortedList<customerData> sortData = new SortedList<>(filter);
            sortData.comparatorProperty().bind(customer_Table.comparatorProperty());
            customer_Table.setItems(sortData);

        });

    }

    public void showCustomerList() {
        custList = customerList();

        customer_Table_Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        customer_Table_TicketNo.setCellValueFactory(new PropertyValueFactory<>("id"));
        customer_Table_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer_Table_Time.setCellValueFactory(new PropertyValueFactory<>("time"));

        customer_Table.setItems(custList);

    }

    public void deleteCustomer() {
        Alert alert;
        String sql = "DELETE FROM customer WHERE id = '" + customer_ticketNo.getText() + "'";

        connect = database.connectDb();

        try {
            statement = connect.createStatement();

            if (customer_ticketNo.getText().isEmpty()
                    || customer_Title.getText().isEmpty()
                    || customer_Date.getText().isEmpty()
                    || customer_Time.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select customer first");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText(null);
                alert.setContentText("Are sure to delete " + customer_Title.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == ButtonType.OK) {
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("INFORMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted");
                    alert.showAndWait();
                    showCustomerList();
                    clearCustomer();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearCustomer() {
        customer_ticketNo.setText("");
        customer_Title.setText("");
        customer_Date.setText("");
        customer_Time.setText("");
    }

    public void selectcustomerList() {
        customerData custD = customer_Table.getSelectionModel().getSelectedItem();
        int num = customer_Table.getSelectionModel().getSelectedIndex();
        if ((num - 1 < -1)) {
            return;
        }

        customer_ticketNo.setText(String.valueOf(custD.getId()));
        customer_Title.setText(String.valueOf(custD.getTitle()));
        customer_Date.setText(String.valueOf(custD.getDate()));
        customer_Time.setText(String.valueOf(custD.getTime()));

    }
    ///Dahsboard
    private int totalMovies;
    private void totalAvaiableMovies()
    {
        String sql = "SELECT COUNT(id) FROM movie WHERE current='Showing'";
        
        connect=database.connectDb();
        
        try{
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();
            if(result.next())
            {
                totalMovies=result.getInt("count(id)");
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        
    }
    
    public void displayTotalAvaiableMovie()
    {
        totalAvaiableMovies();
        availablemovie.setText(String.valueOf(totalMovies));
    }
    private double totalIncome;
    public void totalIncome()
    {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        String sql = "SELECT SUM(total) FROM customer WHERE date ='"+String.valueOf(sqlDate)+"'";
        connect = database.connectDb();
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result.next())
            {
                totalIncome = result.getDouble("SUM(total)");
            }
            
            
        }catch(Exception e){e.printStackTrace();}
        
       
    }
    
    public void displayTotalIncome()
    {
        totalIncome();
        totalearning.setText(String.valueOf(totalIncome));
    }
    
    private int soldTicket;
    public void countTicket()
    {
        String sql = "SELECT count(id) FROM customer";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result.next())
            {
                soldTicket = result.getInt("count(id)");
                
            }
                           
        }catch(Exception e){e.printStackTrace();}
    }
    
    
    public void displayTotalSOldTicket()
    {
        countTicket();
        totalsoldticket.setText(String.valueOf(soldTicket));
    }
    
    
    ////////For Available movies/////////////////////////////////////////////////////////////
    private SpinnerValueFactory<Integer> spinner1;

    private SpinnerValueFactory<Integer> spinner2;

    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;
    private int qty;

    public void Recipt() {

    }

    public void buy() {
        String sql = "INSERT INTO customer (type,movieTitle,quantity,total,date,time) VALUES(?,?,?,?,?,?)";

        connect = database.connectDb();
        String type = "";
        if (price1 > 0 && price2 == 0) {
            type = "Premium";
        } else if (price2 > 0 && price1 == 0) {
            type = "Regular";
        } else if (price2 > 0 && price1 > 0) {
            type = "Premium & Regular";
        }
        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());
        try {

            LocalTime localtime = LocalTime.now();
            Time time = Time.valueOf(localtime);
            qty = qty1 + qty2;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, availableMovie_Label.getText());
            prepare.setString(3, String.valueOf(qty));
            prepare.setString(4, String.valueOf(total));
            prepare.setString(5, String.valueOf(setDate));
            prepare.setString(6, String.valueOf(time));

            if (availableMovie_Imageview.getImage() == null
                    || availableMovie_Label.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please Select The movie first");
                alert.showAndWait();
            } else if (price1 == 0 && price2 == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please insert quantity of tickets");
                alert.showAndWait();
            } else {
                prepare.executeUpdate();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Purchased");
                alert.showAndWait();

                String sql1 = "SELECT * FROM customer";
                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();
                int num = 0;
                while (result.next()) {
                    num = result.getInt("id");
                }
                String sql2 = "INSERT INTO customer_info (customer_id,type,total,movieTitle) VALUES(?,?,?,?)";

                prepare = connect.prepareStatement(sql2);
                prepare.setString(1, String.valueOf(num));
                prepare.setString(2, type);
                prepare.setString(3, String.valueOf(total));
                prepare.setString(4, availableMovie_Label.getText());

                prepare.execute();

                clearPurchaseTicketInfo();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearPurchaseTicketInfo() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovie_regularQuantity.setValueFactory(spinner1);
        availableMovie_PremiumQuantity.setValueFactory(spinner2);

        availableMovie_regularPrice.setText("৳ 0.00");
        availableMovie_PremiumPrice.setText("৳ 0.00");
        availableMovie_TotalPrice.setText("৳ 0.00");

        availableMovie_Imageview.setImage(null);
        availableMovie_Label.setText("Title");

    }

    public void showSpinnerValue() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovie_regularQuantity.setValueFactory(spinner1);
        availableMovie_PremiumQuantity.setValueFactory(spinner2);

    }

    public void getSpinnerValue() {
        qty1 = availableMovie_PremiumQuantity.getValue();

        qty2 = availableMovie_regularQuantity.getValue();
        price1 = (qty1 * 700); //৳25 per premium ticket
        price2 = (qty2 * 350); // ৳10 per regular ticket
        total = price1 + price2;

        availableMovie_regularPrice.setText("৳ " + String.valueOf(price2));
        availableMovie_PremiumPrice.setText("৳ " + String.valueOf(price1));
        availableMovie_TotalPrice.setText("৳ " + String.valueOf(total));

    }

    public ObservableList<moviesData> availableMoviesList() {

        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie WHERE current = 'Showing'";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {

                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                listAvMovies.add(movD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAvMovies;
    }

    private ObservableList<moviesData> availableMoviesList;

    public void showAvailableMovies() {

        availableMoviesList = availableMoviesList();

        availableMovie_Table_Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovie_Table_Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovie_Table_Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        availablemovies_tableView.setItems(availableMoviesList);

    }

    public void selectAvailableMovies() {

        moviesData mvD = availablemovies_tableView.getSelectionModel().getSelectedItem();
        int num = availablemovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        availableMovie_Title.setText(mvD.getTitle());
        availableMovie_Genre.setText(mvD.getGenre());
        availableMovie_Date.setText(String.valueOf(mvD.getDate()));

        getData.path = mvD.getImage();
        getData.title = mvD.getTitle();

    }

    public void selectMovie() {

        Alert alert;

        //checking if movie is selected first
        if (availableMovie_Title.getText().isEmpty() || availableMovie_Genre.getText().isEmpty() || availableMovie_Date.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else {

            String uri = "file:" + getData.path;
            image = new Image(uri, 160, 200, false, true);
            availableMovie_Imageview.setImage(image);

            availableMovie_Label.setText(getData.title);

            //clearing text
            availableMovie_Title.setText("");
            availableMovie_Genre.setText("");
            availableMovie_Date.setText("");

        }

    }

    //For Edit Screen
    private String[] currentList = {"Showing", "End showing"};

    public void comboBox() {
        List<String> listCurrent = new ArrayList<>();

        for (String data : currentList) {
            listCurrent.add(data);
        }

        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editScreen_Current.setItems(listC);
    }

    public void updateEditScreening() {
        String sql = "UPDATE movie SET current = '" + editScreen_Current.getSelectionModel().getSelectedItem() + "' WHERE movieTitle = '" + editScreen_Title.getText() + "'";

        connect = database.connectDb();

        try {

            statement = connect.createStatement();

            if (editScreen_Title.getText().isEmpty() || editScreen_ImageView.getImage() == null
                    || editScreen_Current.getSelectionModel().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else {

                statement.execute(sql);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!!");
                alert.showAndWait();

                showEditScreening();
                clearEditScreening();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearEditScreening() {

        editScreen_Title.setText("");
        editScreen_ImageView.setImage(null);
        //editScreen_Current.setSelectionModel(null);
    }

    public void searchEditScreening() {
        FilteredList<moviesData> filter = new FilteredList(editScreeningL, e -> true);

        editScreen_Search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMoviesData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (predicateMoviesData.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getCurrent().toLowerCase().contains(searchKey)) {
                    return true;
                }
                return false;

            });

            SortedList<moviesData> sortData = new SortedList<>(filter);
            sortData.comparatorProperty().bind(addScreening_tableView.comparatorProperty());
            addScreening_tableView.setItems(sortData);
        });

    }

    public void selectEditScreening() {

        moviesData movD = addScreening_tableView.getSelectionModel().getSelectedItem();
        int num = addScreening_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String uri = "file:" + movD.getImage();
        image = new Image(uri, 160, 200, false, true);
        editScreen_ImageView.setImage(image);

        editScreen_Title.setText(movD.getTitle());

    }

    public ObservableList<moviesData> editScreenList() {
        moviesData mvD;

        ObservableList<moviesData> editSList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie";

        connect = database.connectDb();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                mvD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                editSList.add(mvD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return editSList;

    }

    private ObservableList<moviesData> editScreeningL;

    public void showEditScreening() {
        editScreeningL = editScreenList();

        editScreen_Table_Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreen_Table_Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreen_Table_Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreen_Table_Current.setCellValueFactory(new PropertyValueFactory<>("current"));

        addScreening_tableView.setItems(editScreeningL);
    }

    public void displayUsername() {
        dashboard_username.setText(getData.uname);
    }
    ///Slider
   
    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private AnchorPane slider1;

    @FXML
    private AnchorPane slider2;

    @FXML
    private AnchorPane slider3;

    @FXML
    private AnchorPane slider4;
    
    
    
    
    public void translateAnimation(double duration, Node node , double width)
    {
        TranslateTransition t = new TranslateTransition(Duration.seconds(duration), node);
        t.setByX(width);
        t.play();
    }
    
    int show=0;
    void next()
    {
        if(show==0)
        {
            translateAnimation(0.5,slider2,-424);
            show++;
            
        }
        else if(show==1)
        {
            translateAnimation(0.5,slider3, -424);
            show++;
        }
    }
    
    void back()
    {
       if(show==0)
        {
            translateAnimation(0.5,slider2,424);
            show--;
            
        }
        else if(show==1)
        {
            translateAnimation(0.5,slider3, 424);
            show--;
        } 
    }
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        //For Add Movie
        showAddMoviesList();

        // For Edit Screen  
        showEditScreening();
        comboBox();

        //For showing available movies
        showAvailableMovies();

        showSpinnerValue();

        showCustomerList();
        
        displayTotalSOldTicket();
        displayTotalAvaiableMovie();
        displayTotalIncome();
        translateAnimation(0.5,slider1,424);
        //translateAnimation(0.5,slider2,424);
        
    }
}
