package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    @FXML ColorPicker colorPicker;
    @FXML Slider sliderSize;
    @FXML ComboBox<String> cbType;
    @FXML Button btCircle, btSquare, btLine, btBrush;
    Color brushColor;
    GraphicsContext context;
    int typeBrush = 0;
    @FXML protected void initialize(){
        context = lienzo.getGraphicsContext2D();
        //#region Default
        colorPicker.setValue(Color.BLACK);
        brushColor = colorPicker.getValue();
        cbType.getItems().addAll("Brocha", "Casillas", "Ajedrez", "Estrella","Curva", "Circulo");
        sliderSize.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                cbType(t1.intValue());
            }
        });
        //#endregion
    }

    public void cbType(int value){
        if(cbType.getSelectionModel().getSelectedIndex() == 0){
            btBrush.setDisable(false);
            btCircle.setDisable(false);
            btSquare.setDisable(false);
            btLine.setDisable(false);
        }else if (cbType.getSelectionModel().getSelectedIndex() == 1 || cbType.getSelectionModel().getSelectedIndex() == 2 || cbType.getSelectionModel().getSelectedIndex() == 3 || cbType.getSelectionModel().getSelectedIndex() == 4 || cbType.getSelectionModel().getSelectedIndex() == 5 ) {
            btBrush.setDisable(true);
            btCircle.setDisable(true);
            btSquare.setDisable(true);
            btLine.setDisable(true);
            //#region Cuadricula
            if (cbType.getSelectionModel().getSelectedIndex() == 1){
                context.setFill(Color.WHITESMOKE);
                context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
                brushColor = colorPicker.getValue();
                int division = (int) (lienzo.getWidth() / value);
                for( int x = 1;x<value+1;x++){
                    context.strokeLine(0, division*x,lienzo.getWidth(),division*x);
                    context.strokeLine(division*x, 0,division*x,lienzo.getHeight());
                }
            }
            //#endregion
            //#region Chess
            else if(cbType.getSelectionModel().getSelectedIndex() == 2){
                context.setFill(Color.WHITESMOKE);
                context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
                context.setFill(brushColor);
                brushColor = colorPicker.getValue();
                int division = (int) (lienzo.getWidth() / value);
                int l = 0;
                for( int x = 0;x<value;x++){
                    for(int y = 0;y<value;y++){
                        if(l%2==0){ //Par
                            context.setFill(Color.WHITE);
                            context.fillRect(division*y,division*x,division*(y+1),division*(x+1));
                            if(y%2==0){
                                context.setFill(Color.BLACK);
                                context.fillRect(division*y,division*x,division*(y+1),division*(x+1));
                            }
                        } else { //Impar
                            context.setFill(Color.WHITE);
                            context.fillRect(division*y,division*x,division*(y+1),division*(x+1));
                            if(y%2!=0){
                                context.setFill(Color.BLACK);
                                context.fillRect(division*y,division*x,division*(y+1),division*(x+1));
                            }
                        }
                    }
                    l=l+1;
                }
            }
            //#endregion
            //#region S.T.A.R.S!!!
            else if(cbType.getSelectionModel().getSelectedIndex() == 3) {
                context.setFill(Color.WHITESMOKE);
                context.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
                brushColor = colorPicker.getValue();
                context.setFill(brushColor);
                int divisionX = (int) ((lienzo.getWidth() / 2) / value);
                context.strokeLine(lienzo.getWidth() / 2, 0, lienzo.getWidth() / 2, lienzo.getHeight());
                context.strokeLine(0, lienzo.getHeight() / 2, lienzo.getWidth(), lienzo.getHeight() / 2);
                for (int x = 0; x < value; x++) {
                    context.strokeLine(divisionX * x, lienzo.getHeight() / 2, lienzo.getWidth() / 2, (lienzo.getHeight() / 2) + (divisionX * x));
                    context.strokeLine(lienzo.getWidth() / 2, divisionX * x, (lienzo.getWidth() / 2) - (divisionX * x), lienzo.getHeight() / 2);
                    context.strokeLine(lienzo.getWidth() / 2, divisionX * x, (lienzo.getWidth() / 2) + (divisionX * x), lienzo.getHeight() / 2);
                    context.strokeLine((lienzo.getWidth()) - (divisionX * x), lienzo.getHeight() / 2, lienzo.getWidth() / 2, (lienzo.getHeight() / 2) + (divisionX * x));
                }
            }
            //#endregion
            //#region Curvatura Espacio-Tiempo
            else if(cbType.getSelectionModel().getSelectedIndex() == 4){
                context.setFill(Color.WHITESMOKE);
                context.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
                brushColor = colorPicker.getValue();
                context.setFill(brushColor);
                int divisionX = (int) (lienzo.getWidth() / value);
                for( int x = 0;x<value;x++){
                    context.strokeLine(0, divisionX*x,divisionX*x,lienzo.getHeight());
                    context.strokeLine(0, lienzo.getHeight()-(divisionX*x),divisionX*x,0);
                    context.strokeLine(lienzo.getWidth(), lienzo.getHeight()-(divisionX*x),lienzo.getWidth()-(divisionX*x),0);
                    context.strokeLine(lienzo.getWidth(), divisionX*x,lienzo.getWidth()-(divisionX*x),lienzo.getHeight());
                }
            }
            //#endregion
            else if(cbType.getSelectionModel().getSelectedIndex() == 5){
                context.setFill(Color.WHITESMOKE);
                context.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
                brushColor = colorPicker.getValue();
                context.setFill(brushColor);
                //650x650
                context.strokeOval(0,0,lienzo.getWidth(),lienzo.getHeight());
                context.strokeOval(162.5,0,325,lienzo.getHeight()/2);
                /*for (int x = 0; x<value;x++){

                }*/
            }
        }
    }

    public void dragBrush(MouseEvent event){
        context.setFill(brushColor);
        if(typeBrush == 0) context.fillOval(event.getX(),event.getY(),sliderSize.getValue(),sliderSize.getValue());
        else if(typeBrush == 1) context.fillRect(event.getX(),event.getY(),sliderSize.getValue(),sliderSize.getValue());
    }

    public void brushSelected(ActionEvent event){ brushColor = colorPicker.getValue(); }
    public void eraserSelected(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
    }

    //#region Tipo de brocha
    public void circleSelected(ActionEvent event){ this.typeBrush = 0; }
    public void squareSelected(ActionEvent event){ this.typeBrush = 1; }
    public void lineSelected(ActionEvent event){ this.typeBrush = 2; }
    //#endregion
}