package ORION.LoginScreen;

import ORION.Main;
import ORION.Others.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import netscape.javascript.JSObject;

import java.io.IOException;

public class Register {
    @FXML TextField txName, txAge, txAP, txAM, txPeso, txAltura, txCURP;
    @FXML CheckBox checkPrivacy;
    Login login = new Login();
    User user;

    public void btFinish(ActionEvent event){
        if(checkPrivacy.isSelected()) {
            this.user = new User(txName.getText() + " " + txAP.getText() + " " + txAM.getText(), txCURP.getText(), login.getPassWord(), login.getUserName(), Integer.parseInt(txAge.getText()), Double.parseDouble(txAltura.getText()), Double.parseDouble(txPeso.getText()), null);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../MenuScreen/menu.fxml"));
                Scene scene=new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setMaximized(false);
            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    public User getUser() { return user; }
}
