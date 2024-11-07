package org.example.fuelconsumption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class FuelController {
    @FXML
    private Label distanceLabel;
    @FXML
    private TextField distanceTextField;
    @FXML
    private Label fuelUsedLabel;
    @FXML
    private TextField fuelUsedTextField;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;
    @FXML
    private Button ENButton;
    @FXML
    private Button FRButton;
    @FXML
    private Button JPButton;
    @FXML
    private Button IRButton;

    private ResourceBundle bundle;
    private Locale locale;
    private double fuelConsumption = 0.0;


    public void initialize() {
        loadLanguage("en", "UK");
    }

    @FXML
    public void loadLanguage(String language, String country) {
        locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle("fuelView", locale);
        distanceLabel.setText(bundle.getString("distance_label"));
        fuelUsedLabel.setText(bundle.getString("fuel_used_label"));
        calculateButton.setText(bundle.getString("calculate_button"));
        resultLabel.setText(String.format(bundle.getString("fuel_consumption"), fuelConsumption));
    }

    @FXML
    public void onCalculateButtonClick(ActionEvent actionEvent) {
        calculateFuelConsumption();
    }

    @FXML
    public void onENButtonClick(ActionEvent actionEvent) {
        loadLanguage("en", "UK");
    }

    @FXML
    public void onFRButtonClick(ActionEvent actionEvent) {
        loadLanguage("fr", "FR");
    }

    @FXML
    public void onJPButtonClick(ActionEvent actionEvent) {
        loadLanguage("ja", "JP");
    }

    @FXML
    public void onIRButtonClick(ActionEvent actionEvent) {
        loadLanguage("fa", "IR");
    }

    public void calculateFuelConsumption() {
        double distance;
        double fuelUsed;
        try {
            distance = Double.parseDouble(distanceTextField.getText());
            fuelUsed = Double.parseDouble(fuelUsedTextField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers");
            return;
        }
        fuelConsumption = fuelUsed / distance * 100;
        resultLabel.setText(String.format(bundle.getString("fuel_consumption"), fuelConsumption));
    }

}