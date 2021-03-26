package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


import java.io.IOException;

public class Login{
    @FXML TextField txtNumberControl;
    @FXML TextField txtPassword;
    //accion del login
    public void ingresar(){
        String usuario=txtNumberControl.getText();
        String password=txtPassword.getText();
        if(usuario.equals("si")  && password.equals("si")){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("menu/menu.fxml"));
                Scene scene=new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setMaximized(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inicio de Sesion Fallido");
            alert.setContentText("Datos invalidos, intenta nuevamente en Sing Up");
            alert.show();
        }
    }
    public void login(ActionEvent event){
        txtNumberControl.setEditable(false);
        txtPassword.setEditable(false);
        txtPassword.setVisible(false);
        txtNumberControl.setVisible(false);
        ingresar();
    }
    public void registro(ActionEvent event){
        txtPassword.setEditable(true);
        txtNumberControl.setEditable(true);
        txtNumberControl.setVisible(true);
        txtPassword.setVisible(true);
        txtPassword.clear();
        txtNumberControl.clear();
    }
}//controller
