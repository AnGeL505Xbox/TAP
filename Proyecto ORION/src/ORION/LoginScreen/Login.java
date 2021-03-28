package ORION.LoginScreen;

import ORION.Main;
import ORION.Others.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.Objects;

public class Login{
    static String userReg, passReg, userLog, passLog;

    @FXML TextField txtNumberControl ,txtPassword, txUserName, txPassWord;
    @FXML ImageView imgLogo;
    @FXML AnchorPane paneLogin, paneRegister;
    @FXML public void initialize() {
        Register.listUser.addFirst(new User("","","admin","admin",0,2,100,null)); //Master key

        //#region Login events
        txtNumberControl.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER) log();
            }
        });
        txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER) log();
            }
        });
        txUserName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER) reg();
            }
        });
        txPassWord.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER) reg();
            }
        });
        //#endregion
    }

    //#region Eventos del boton de Acceder
    public void login(ActionEvent event){ log(); }

    public void log(){
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

    //#endregion
    //#region Eventos del boton registro
    public void registro(ActionEvent event){
        paneLogin.setVisible(false);
        paneRegister.setVisible(true);
    }

    public void btRegistrar(ActionEvent event){
        reg();
    }

    public void reg(){
        this.userReg = txUserName.getText();
        this.passReg = txPassWord.getText();
        if(txUserName.getText().isEmpty() || txPassWord.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Datos vacios");
            alert.setContentText("Usted no ha llenado todos los cuadros de texto, porfavor llenelos y prosiga con su registro");
            alert.show();
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../LoginScreen/register.fxml"));
                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setMaximized(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btCancel(ActionEvent event){
        paneLogin.setVisible(true);
        paneRegister.setVisible(false);
    }

    //#endregion
    //#region Getters & Setters
    public String getUserName() { return userReg; }
    public String getPassWord() { return passReg; }
    public static String getUsuario() { return userLog; }
    public static String getPassword() { return passLog; }
    //#endregion
}