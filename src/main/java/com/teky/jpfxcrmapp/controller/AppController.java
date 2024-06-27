package com.teky.jpfxcrmapp.controller;

import com.teky.jpfxcrmapp.App;
import com.teky.jpfxcrmapp.view.AppView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AppController implements Initializable {

    public void dispatcher(String command) {
        switch (command) {
            case "contracts" ->contractController.listActivity();
            case "new-contract" ->contractController.newActivity();
            case "customers" ->customerController.listActivity();
            case "new-customer" ->customerController.newActivity();

            case "home" ->contractController.listActivity();
        }
    }

    CustomerController customerController;
    ContractController contractController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppView appView = new AppView(txtTitle, container);

        customerController = App.getInstance(CustomerController.class);
        customerController.setAppView(appView);

        contractController = App.getInstance(ContractController.class);
        contractController.setAppView(appView);

        dispatcher("home");
    }

    @FXML
    void menuClick(ActionEvent evt) {
        Button button = (Button) evt.getSource();
        String command = (String) button.getProperties().get("command");

        dispatcher(command);
    }

    @FXML
    Label txtTitle;
    @FXML
    Pane container;
}
