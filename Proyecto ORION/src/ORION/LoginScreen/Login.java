package ORION.LoginScreen;

import ORION.Main;
import ORION.Others.User;
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

    static String userReg, passReg, userLog, passLog;

    @FXML public void initialize() {
        //#region Llave maestra
        Register.listUser.addFirst(new User("","","admin","admin",0,2,100,null));
        //#endregion
    }

    public void login(ActionEvent event){
        userLog =txtNumberControl.getText();
        passLog =txtPassword.getText();

        for (int x = 0; x<Register.getListUser().size(); x++) {
            if ((userLog.equals(Register.getListUser().get(x).getUsername()) && passLog.equals(Register.getListUser().get(x).getPassword())) || (userLog.equals("admin") && passLog.equals("admin"))) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../MenuScreen/menu.fxml"));
                    Scene scene = new Scene(root);
                    Main.stage.setScene(scene);
                    Main.stage.setMaximized(false);
                } catch (IOException e) { e.printStackTrace(); }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inicio de Sesion Fallido");
                alert.setContentText("Datos invalidos, intenta nuevamente en Sing Up");
                alert.show();
                break;
            }
        }
    }

    public void registro(ActionEvent event){
        paneLogin.setVisible(false);
        imgLogo.setVisible(false);
        paneRegister.setVisible(true);
    }

    public void btRegistrar(ActionEvent event){
        this.userReg = txUserName.getText();
        this.passReg = txPassWord.getText();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../LoginScreen/register.fxml"));
            Scene scene=new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.setMaximized(false);
        } catch (IOException e) { e.printStackTrace(); }
    }

    //#region Getters & Setters
    public String getUserName() { return userReg; }
    public String getPassWord() { return passReg; }
    public static String getUsuario() { return userLog; }
    public static String getPassword() { return passLog; }
    //#endregion
}