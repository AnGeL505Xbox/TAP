package sample.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;


public class Menu {


    @FXML
    public void bntDiag(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("diagnostico.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
        Main.stage.setMaximized(false);
    }

    @FXML
    public void bntOut(ActionEvent event){

    }
}
