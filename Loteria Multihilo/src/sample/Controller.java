package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class Controller {
    @FXML Label lb1, lb2, lb3, lb4;
    @FXML Button bb8;
    Hilo h1,h2,h3,h4;
    int n=0;
    LinkedList<Integer> num = new LinkedList<>();

    public void generate(ActionEvent event){
        for(int x=0;x<=5;x++){
            num.add(x);
        }
        if(bb8.getText().equals("Generar")){
            h1=new Hilo(0,n,lb1,bb8,num);
            h2=new Hilo(1,n,lb2,bb8,num);
            h3=new Hilo(2,n,lb3,bb8,num);
            h4=new Hilo(3,n,lb4,bb8,num);
            h1.start();
            h2.start();
            h3.start();
            h4.start();
            bb8.setText("Detener");
        } else {
            h1.stop();
            n=Integer.parseInt(lb1.getText());
            for(int x=0;x<=5;x++){
                if (num.get(x)==n){
                    num.remove(x);
                    break;
                }
            }
            h2.n = num;
            h2.stop();
            n=Integer.parseInt(lb2.getText());
            for(int x=0;x<=5;x++){
                if (num.get(x)==n){
                    num.remove(x);
                    break;
                }
            }
            h3.n=num;
            h3.stop();
            n=Integer.parseInt(lb3.getText());
            for(int x=0;x<=5;x++){
                if (num.get(x)==n){
                    num.remove(x);
                    break;
                }
            }
            h4.n=num;
            h4.stop();
            bb8.setText("Generar");
        }
    }
}
