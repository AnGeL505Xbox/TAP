package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Hilo extends Thread{

    private int cont=0;
    private Label label;
    private boolean finish;
    public Hilo(Label label, boolean finish){
        this.label = label;
        this.finish = finish;
    }
    @Override
    public void run() {
        //Se inicia el hilo
        while (true) {
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (finish){
                            Hilo.super.stop();
                        }
                        label.setText(cont+"");
                        cont++;
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
1.- Crear la clase y heredar Thread
2.- Sobreescribir el metodo run
3.- Crear el While infinito
4.- Crear el Plattaform
*/