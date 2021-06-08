package sample;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

public class Hilo extends Thread{
    Label label;
    Button bt;
    int id, num;
    LinkedList<Integer> n;
    public Hilo(int id,int num,Label label, Button bt, LinkedList<Integer> n){
        this.label = label;
        this.id = id;
        this.bt = bt;
        this.num=num;
        this.n=n;
    }

    @Override
    public void run() {
        while(true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        switch (id){
                            case 0: {
                                int x = random.nextInt(5);
                                label.setText(x + "");
                            }
                            case 1: {
                                int x = n.get(random.nextInt(n.size()));
                                label.setText(x + "");
                            }
                            case 2: {
                                int x = n.get(random.nextInt(n.size()));
                                label.setText(x + "");
                            }
                            case 3: {
                                int x = n.get(random.nextInt(n.size()));
                                label.setText(x + "");
                            }
                        }
                    }
                });
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
