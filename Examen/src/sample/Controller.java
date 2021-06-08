package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class Controller {
    @FXML Label txMoney, txPorcentaje;
    @FXML ProgressBar progressBar;
    @FXML TextField txLitros;

    double porcentaje=0, litros=0;
    int contador = 1;
    MultiHilo hilo;
    public void initialize(){
        txMoney.setAlignment(Pos.CENTER);
        txPorcentaje.setAlignment(Pos.CENTER);
    }

    public void btStart(ActionEvent event){
        litros = Double.parseDouble(txLitros.getText());
        txMoney.setText("$"+(litros*20));
        hilo = new MultiHilo(progressBar,litros,porcentaje,contador,txPorcentaje);
        hilo.start();
    }
}