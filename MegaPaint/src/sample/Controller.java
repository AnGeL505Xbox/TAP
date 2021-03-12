package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    @FXML ColorPicker colorPicker;
    @FXML Slider sliderSize;
    Color brushColor;
    GraphicsContext context;
    int typeBrush = 0;
    @FXML protected void initialize(){
        context = lienzo.getGraphicsContext2D();
        //#region Default
        colorPicker.setValue(Color.BLACK);
        brushColor = colorPicker.getValue();
        sliderSize.setValue(10);
        //#endregion
    }

    public void dragBrush(MouseEvent event){
        context.setFill(brushColor);
        if(typeBrush == 0) context.fillOval(event.getX(),event.getY(),sliderSize.getValue(),sliderSize.getValue());
        else if(typeBrush == 1) context.fillRect(event.getX(),event.getY(),sliderSize.getValue(),sliderSize.getValue());
        else context.strokeLine(event.getX(), event.getY(), event.getX()+sliderSize.getValue(), event.getY()+sliderSize.getValue()); //Aun por arreglar
    }

    public void brushSelected(ActionEvent event){ brushColor = colorPicker.getValue(); }
    public void eraserSelected(ActionEvent event){ brushColor = Color.WHITESMOKE; }

    //#region Tipo de brocha
    public void circleSelected(ActionEvent event){ this.typeBrush = 0; }
    public void squareSelected(ActionEvent event){ this.typeBrush = 1; }
    public void lineSelected(ActionEvent event){ this.typeBrush = 2; }
    //#endregion
}