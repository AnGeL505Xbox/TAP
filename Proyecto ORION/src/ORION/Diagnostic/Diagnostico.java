package ORION.Diagnostic;

import ORION.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Collection;

public class Diagnostico{
    Test test = new Test();

    String enfe=test.getEnfermedad();

    @FXML TableView<Test> listEnferm=new TableView();
    @FXML TableColumn clmEnfe = new TableColumn<>("Enfermedad");
    @FXML TableColumn clmTrat = new TableColumn<>("Enfermedad");
    public void initialize(){

    }
    public void btnTest(ActionEvent event){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ORION/Diagnostic/test.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        } catch (IOException e) { e.printStackTrace(); }
    }
    public void btnBack(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../MenuScreen/menu.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        } catch (IOException e) { e.printStackTrace(); }
    }
    public void mostrar(ActionEvent event){
      // clmEnfe.getColumns().addAll(test.getEnfermedad());
    }

}
