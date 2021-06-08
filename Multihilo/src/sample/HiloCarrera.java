package sample;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class HiloCarrera extends Thread {
    private long time = 1000, t2 = 1000;
    private ImageView animal;
    private String id;
    private boolean finish;

    public HiloCarrera(ImageView image, long time, String name, boolean finish){
        this.animal=image;
        this.time=time; this.t2= time;
        this.id=name;
        this.finish=finish;
    }
    @Override
    public void run() {
        while (true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (id.equals("Tortuga")){
                            if(animal.getLayoutX()!=590 && animal.getLayoutY()==10){
                                animal.setLayoutX(animal.getLayoutX()+10);
                            } else if (animal.getLayoutX()==590 && animal.getLayoutY()==10){
                                animal.setLayoutY(animal.getLayoutY()+10);
                            } else if (animal.getLayoutX()==590 && animal.getLayoutY()!=590){
                                animal.setLayoutY(animal.getLayoutY()+10);
                            } else if (animal.getLayoutX()==590 && animal.getLayoutY()==590){
                                animal.setLayoutX(animal.getLayoutX()-10);
                            } else if (animal.getLayoutX()!=10 && animal.getLayoutY()==590){
                                animal.setLayoutX(animal.getLayoutX()-10);
                            } else if (animal.getLayoutX()==10 && animal.getLayoutY()==590){
                                HiloCarrera.super.stop();
                                finish = true;
                            }
                        } else if (id.equals("Liebre")){
                            if(animal.getLayoutX()!=590 && animal.getLayoutY()==10){
                                animal.setLayoutX(animal.getLayoutX()+10);
                            } else if (finish){
                                HiloCarrera.super.stop();
                            }else if (animal.getLayoutX()==590 && animal.getLayoutY()==10){
                                time += 29000;
                                animal.setLayoutY(animal.getLayoutY()+10);
                            } else if (animal.getLayoutX()==590 && animal.getLayoutY()!=590){
                                animal.setLayoutY(animal.getLayoutY()+10);
                                time = t2;
                            } else if (animal.getLayoutX()==590 && animal.getLayoutY()==590){
                                animal.setLayoutX(animal.getLayoutX()-10);
                            } else if (animal.getLayoutX()!=10 && animal.getLayoutY()==590){
                                animal.setLayoutX(animal.getLayoutX()-10);
                            }
                        }
                    }
                });
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}