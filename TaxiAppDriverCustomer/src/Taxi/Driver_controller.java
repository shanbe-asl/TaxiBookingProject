package Taxi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Driver_controller {
    ObservableList<String> destinationList = FXCollections.observableArrayList("Dushanbe-Khorog", "Khorog-Dushanbe");
    @FXML
    private TextField fname;

    @FXML
    private TextField age;

    @FXML
    private TextField phnum;

    @FXML
    private TextField carmodel;

    @FXML
    private Slider sliderseat;

    @FXML
    private DatePicker datedr;

    public LocalDate datedriver() {
        LocalDate date = datedr.getValue();
        return date;
    }
    @FXML
    private ChoiceBox destinationBox;
    
    @FXML
    private void initialize(){
        try {
            destinationBox.setItems(destinationList);
        }
        catch (Exception e){

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

    public int numseats() {
        int sliderValue = (int) sliderseat.getValue();
        return sliderValue;
    }

    @FXML
    void resetBtn(ActionEvent event) {
        fname.clear();
        age.clear();
        phnum.clear();
        carmodel.clear();
        sliderseat.adjustValue(0);
        datedr.setValue(LocalDate.now());
        destinationBox.setValue(" ");
    }

    @FXML
    void submitBtn(ActionEvent event) {
        String name = fname.getText();
        String ageDriver = age.getText();
        String phone_number = phnum.getText();
        String car_model = carmodel.getText();
        String destinationCity = (String) destinationBox.getValue();
        String num_seats = numseats() + "";
        String driver_date;
        if (datedriver() ==null){
            driver_date ="";
        }else {
            driver_date = datedriver().toString();
        }


        if (name.isEmpty() || ageDriver.isEmpty() || phone_number.isEmpty() || car_model.isEmpty() || num_seats.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields!!!");
            alert.showAndWait();
        } else {
            try {
                Connection con = Database_connector.getConnection();
                String query = "insert into drivers (`full_name`, `age`, `phone_num`, `car_model`, `number_of_seats`, `date`, `destination`) values (?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, ageDriver);
                preparedStatement.setString(3, phone_number);
                preparedStatement.setString(4, car_model);
                preparedStatement.setString(5, num_seats);
                preparedStatement.setString(6, driver_date);
                preparedStatement.setString(7, destinationCity);
                preparedStatement.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
            resetBtn(event);
        }
    }
}
