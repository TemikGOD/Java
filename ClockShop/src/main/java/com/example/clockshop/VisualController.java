package com.example.clockshop;

import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;

import com.google.gson.Gson;

public class VisualController {

    public Button btnOpenShopG;
    public TextField textFieldOpenShopG;
    public Button btnSaveShopG;
    public TextField textFieldSaveShopG;
    public Button btnLFBD;
    public Button btnLSTDC;
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
    public Button btnOpenShop;
    @FXML
    public TextField textFieldOpenShop;
    @FXML
    public Button btnSaveShop1;
    @FXML
    public TextField textFieldSaveShop;

    public void btnDescriptionClick(ActionEvent actionEvent) {
        textFieldDescription.setText("Brand: " + Shop.mostExpensiveClock().getName() + "\n" +
                "Cost: " + Shop.mostExpensiveClock().getCost() + "$\n" +
                Shop.mostExpensiveClock().getTimeAsString());
    }

    public void btnSetTimeClick(ActionEvent actionEvent) {
        if (textFieldSetTime.getText().isEmpty())
            return;
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

    public void btnOpenShopClick(ActionEvent actionEvent) {
        try {
            FileInputStream fis = new FileInputStream(textFieldOpenShop.getText() + ".bin");
            ObjectInputStream oos = new ObjectInputStream(fis);
            Shop = (ClockShop)oos.readObject();
            oos.close();
        }
        catch (IOException ex) {
            System.out.println("Error #1");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error #2");
    }
    }

    public void btnSaveShopClick(ActionEvent actionEvent) {
        try {
            FileOutputStream fos = new FileOutputStream(textFieldSaveShop.getText() + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Shop);
            oos.close();
        }
        catch (IOException ex) {
            System.out.println("Error #1");
        }
    }

    public void btnOpenShopGClick(ActionEvent actionEvent) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(clockInterface.class, new InterfaceAdapter());
        Gson gson = builder.setPrettyPrinting().create();
        try (BufferedReader br = new BufferedReader(new FileReader(textFieldOpenShopG.getText()))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String readResult = sb.toString();
            Shop = gson.fromJson(readResult, Shop.getClass());
            System.out.println(Shop);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void btnSaveShopGClick(ActionEvent actionEvent) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(clockInterface.class, new InterfaceAdapter());
        Gson gson = builder.setPrettyPrinting().create();
        try (PrintWriter out = new PrintWriter(textFieldSaveShopG.getText())) {
            String save = gson.toJson(Shop);
            out.println(save);
            out.close();
            System.out.println(save);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void btnLFBDClick(ActionEvent actionEvent) throws SQLException {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(clockInterface.class, new InterfaceAdapter());
        Gson gson = builder.setPrettyPrinting().create();
        ClockService clockService = new ClockService();
        Shop = gson.fromJson(clockService.findClock(4).getShop(), Shop.getClass());
    }

    public void btnSTBDClick(ActionEvent actionEvent) throws SQLException {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(clockInterface.class, new InterfaceAdapter());
        Gson gson = builder.setPrettyPrinting().create();
        String save = gson.toJson(Shop);
        ClockService clockService = new ClockService();
        ClockShopEnt saving = new ClockShopEnt(save);
        clockService.saveClock(saving);
        }
}