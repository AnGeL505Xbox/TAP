package ORION.tools;

import ORION.LoginScreen.Login;
import ORION.LoginScreen.Register;
import ORION.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class Tools {
    @FXML Label txAltura, txPeso, txIMC;

    int us = 0;

    @FXML public void initialize(){
        for(int x = 0;x<Register.getListUser().size();x++){
            if(Register.getListUser().get(x).getUsername().equals(Login.getUsuario())){
                this.us = x;
            }
        }
    }

    public void btCalculate(ActionEvent event){
        txAltura.setText(Register.getListUser().get(us).getHeight()+" Mts");

        txPeso.setText(Register.getListUser().get(us).getWeigth()+" Kgs");
        txIMC.setText(""+Register.getListUser().get(us).getImc());
    }

    public void btReturn(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../MenuScreen/menu.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
