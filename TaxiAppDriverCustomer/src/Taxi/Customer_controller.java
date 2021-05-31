package Taxi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Customer_controller implements Initializable {

    ObservableList<String> destinationList = FXCollections.observableArrayList("Dushanbe-Khorog", "Khorog-Dushanbe");
    @FXML
    private TableView<Driver> table;

    @FXML
    private TableColumn<Driver, String> id;

    @FXML
    private TableColumn<Driver, String> fname;

    @FXML
    private TableColumn<Driver, String> age;

    @FXML
    private TableColumn<Driver, String> num_seats;

    @FXML
    private TableColumn<Driver, String> datect;

    @FXML
    private TableColumn<Driver, String> phonenum;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox destinationBox;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField numTxt;

    ObservableList<Driver> observableList = FXCollections.observableArrayList();

    @FXML
    void confirmBtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public LocalDate dateCustomer() {
        LocalDate date = datePicker.getValue();
        return date;
    }



    @FXML
    void BookBtn(ActionEvent event) {
        try {
            Driver driver = table.getSelectionModel().getSelectedItem();
            Parent parent = FXMLLoader.load(getClass().getResource("confirm.fxml"));
            nameTxt = (TextField) parent.lookup("#nameTxt");
            nameTxt.setText(driver.getFull_name());
            numTxt = (TextField) parent.lookup("#numTxt");
            numTxt.setText(driver.getPhone_num());
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {

        }

    }

    @FXML
    void homeBtn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("main_page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Taxi App");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void updateTab() {
        observableList.clear();
        try {
            Connection con = Database_connector.getConnection();
            ResultSet resultSet = con.createStatement().executeQuery("select * from drivers");
            while (resultSet.next()) {
                observableList.add(new Driver(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getInt("age"), resultSet.getString("phone_num"),resultSet.getString("car_model"), resultSet.getInt("number_of_seats"), resultSet.getString("date"), resultSet.getString("destination")));
            }

        } catch (SQLException throwable) {
        }
    }

    void loadData() {
        try {
            Connection con = Database_connector.getConnection();
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            fname.setCellValueFactory(new PropertyValueFactory<>("full_name"));
            age.setCellValueFactory(new PropertyValueFactory<>("age"));
            num_seats.setCellValueFactory(new PropertyValueFactory<>("number_of_seats"));
            datect.setCellValueFactory(new PropertyValueFactory<>("date"));
            phonenum.setCellValueFactory(new PropertyValueFactory<>("phone_num"));
            table.setItems(observableList);
        } catch (Exception e) {

        }
    }


    @FXML
    void updateBtn(ActionEvent event) {
        String date = dateCustomer().toString();
        String destinationCity = (String) destinationBox.getValue();
        observableList.clear();

        try {
            Connection con = Database_connector.getConnection();
            ResultSet resultSet = con.createStatement().executeQuery("select * from drivers where destination = '"+destinationCity+"' and date = '"+date+"'");
            while (resultSet.next()) {
                observableList.add(new Driver(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getInt("age"), resultSet.getString("phone_num"),resultSet.getString("car_model"), resultSet.getInt("number_of_seats"), resultSet.getString("date"), resultSet.getString("destination")));
            }

//            loadData();
        } catch (SQLException throwable) { }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTab();
        loadData();
        try {
            destinationBox.setItems(destinationList);
        }
        catch (Exception e){

        }
    }
}
