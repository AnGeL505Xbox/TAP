package ORION.tools;

import ORION.LoginScreen.Login;
import ORION.LoginScreen.Register;
import ORION.Others.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Tools {
    @FXML TextField txAltura, txPeso;
    @FXML ListView<String> listIMC;
    User user;
    @FXML public void initialize(){

    }

    public void btCalculate(ActionEvent event){
        user.imcCalculate();
        listIMC.getItems().clear();
        listIMC.getItems().add("Indice de Masa Corporal: "+user.getImc());
    }
}
