package ORION.LoginScreen;

import ORION.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class Login{
    @FXML TextField txtNumberControl ,txtPassword, txUserName, txPassWord;
    @FXML ImageView imgLogo;
    @FXML AnchorPane paneLogin, paneRegister;

    public void ingresar(){
        String usuario=txtNumberControl.getText();
        String password=txtPassword.getText();
        if(usuario.equals("si")  && password.equals("si")){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../MenuScreen/menu.fxml"));
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
        paneLogin.setVisible(false);
        imgLogo.setVisible(false);
        paneRegister.setVisible(true);
    }
    public void btRegistrar(ActionEvent event){

    }
}//controller
