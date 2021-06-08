package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MultiHilo extends Thread{

    private ProgressBar bar;
    private Label lb;
    private double porcent, lit;
    private int cont;

    public MultiHilo(ProgressBar bar, double lit, double porcent, int cont, Label lb){
        this.bar = bar;
        this.lit = lit;
        this.porcent = porcent;
        this.cont = cont;
        this.lb = lb;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (bar.getProgress()<=1){
                            double x = 1 / lit;
                            bar.setProgress(cont * (x * 2));
                            lb.setText(((cont*(x*2))*100)+"% de gasolina cargada");
                            cont++;
                        } else {
                            lb.setText("Gasolina cargada");
                        }
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
