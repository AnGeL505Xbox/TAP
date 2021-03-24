package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Random;

public class AhorcadoUI {
    @FXML HBox boxHijo;
    @FXML AnchorPane anchorPadre;

    String[] words = {"NADA","TODO", "CUANTICO", "LINKINPARK", "ROCK", "molotov", "magikarp", "bob", "ITSNCG", "TRUMPISLOVE"};
    TextField[] arrayTxt = null;
    int temp, temp2 = 0;
    @FXML protected void initialize() {
        Random random = new Random();
        String textSelected = words[random.nextInt(words.length)].toLowerCase();
        System.out.println(textSelected);
        arrayTxt = new TextField[textSelected.length()];

        for (int x = 0; x<textSelected.length();x++){
            arrayTxt[x] = new TextField();
            arrayTxt[x].setPrefWidth(40); arrayTxt[x].setPrefHeight(40);
            arrayTxt[x].setId("txt-"+x+"-"+textSelected.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {


                @Override
                public void handle(KeyEvent keyEvent) {

                    TextField textField = (TextField) keyEvent.getTarget();
                    String[] name = textField.getId().split("-");
                    if (name[2].equals(textField.getText().toLowerCase())){
                        System.out.println("Correcto "+textField.getId());
                        textField.setDisable(true);
                        if (arrayTxt[Integer.parseInt(name[1])].isDisable()) temp2 +=1;
                        if (temp2 == arrayTxt.length){
                            String text, title;
                            title = "Juego terminado";
                            text = "Salvaste a Bob!!! Ahora Bob sera feliz con su familia y te lo agradecen haciendote plegarias por salvar a Bob";
                            alertSystem(title,text);
                        }
                    } else {
                        System.out.println("Incorrecto "+textField.getId());
                        textField.setText("");
                        temp = temp +1;
                        drawBob(temp);
                    }
                }
            });
            boxHijo.getChildren().add(arrayTxt[x]);
        }

    }
    public void drawBob(int numTemp){
        ImageView[] imgBob = new ImageView[5];
        imgBob[0] = new ImageView(new Image("sample/IMG/head.png"));
        imgBob[1] = new ImageView(new Image("sample/IMG/body.png"));
        imgBob[2] = new ImageView(new Image("sample/IMG/handL.png"));
        imgBob[3] = new ImageView(new Image("sample/IMG/handR.png"));
        imgBob[4] = new ImageView(new Image("sample/IMG/legs.png"));

        imgBob[0].setX(250); imgBob[0].setY(300);
        imgBob[1].setX(250); imgBob[1].setY(350);
        imgBob[2].setX(219); imgBob[2].setY(363); imgBob[2].setScaleX(0.95);
        imgBob[3].setX(279); imgBob[3].setY(363); imgBob[3].setScaleX(0.95);
        imgBob[4].setX(250); imgBob[4].setY(380);

        if(numTemp<6) for(int x = 0;x<numTemp;x++) anchorPadre.getChildren().add(imgBob[x]);
        else {
            String title, text;
            title = "Fin del juego";
            text = "Bob a muerto!!! Tu incompetencia por no poder descubrir la palabra secreta hizo que la familia de Bob se volviera altamente violenta y por ello ahora estan en la carcel!!! Bob te observa enojado desde el cielo";
            alertSystem(title,text);
        }
    }

    public void alertSystem(String title, String text){
        Alert alert, continues;
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        } catch (IOException e) { e.printStackTrace(); }
    }

}