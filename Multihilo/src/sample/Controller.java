package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML Label txCont;
    @FXML ImageView imgLiebre, imgTortuga;
    Hilo hilo1;
    HiloCarrera hTortuga,hLiebre;
    boolean finish = false;

    public void btStart(ActionEvent event){
        hilo1 = new Hilo(txCont,finish);
        hilo1.start();

        hTortuga = new HiloCarrera(imgTortuga,250,"Tortuga",finish);
        hLiebre = new HiloCarrera(imgLiebre,125,"Liebre",finish);

        hLiebre.start();
        hTortuga.start();
    }

}