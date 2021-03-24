package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainUI {
    @FXML AnchorPane anchorPadre;
    @FXML protected void initialize() {
        Button button = new Button();
        button.setLayoutX(200);
        button.setLayoutY(400);
        button.setText("Comenzar a jugar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("AhorcadoUI.fxml"));
                    Scene scene = new Scene(root);
                    Main.stage.setScene(scene);
                } catch (IOException e) { e.printStackTrace(); }
            }
        });
        anchorPadre.getChildren().add(button);
    }

}
