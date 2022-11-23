package com.example.clockshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VisualController {

    private ClockShop Shop = new ClockShop();
    @FXML
    public Button btnWB;
    @FXML
    public Button btnMCWB;
    @FXML
    public Button btnSetTime;
    @FXML
    public Button btnDescription;
    @FXML
    public TextField textFieldSetTime;
    @FXML
    public TextArea textFieldDescription;
    @FXML
    public TextField textFieldMCWB;
    @FXML
    public TextArea textWB;
    
    @FXML
    public void btnDescriptionClick(ActionEvent actionEvent) {
        textFieldDescription.setText("Brand: " + Shop.mostExpensiveClock().getName() + "\n" +
                "Cost: " + Shop.mostExpensiveClock().getCost() + "$\n" +
                Shop.mostExpensiveClock().getTimeAsString());
    }

    public void btnSetTimeClick(ActionEvent actionEvent) {
        String[] timeStr = textFieldSetTime.getText().split("\\.");
        int[] time = new int[timeStr.length];
        for (int j = 0; j < timeStr.length; j++)
            time[j] = Integer.parseInt(timeStr[j]);
        Shop.setTimeOnAllClocks(time);
    }

    public void btnMCWBClick(ActionEvent actionEvent) {
        textFieldMCWB.setText(Shop.getMostPopularName());
    }

    public void btnWBClick(ActionEvent actionEvent) {
        textWB.setText(String.join(", ", Shop.getSortedNames()));
    }
}