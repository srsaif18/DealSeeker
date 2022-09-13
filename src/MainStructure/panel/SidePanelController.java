package MainStructure.panel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import InteractiveLogin.MainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SidePanelController implements Initializable {

    @FXML
    private JFXButton home;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton preferences;

    @FXML
    private JFXButton user;

    @FXML
    private JFXButton exit;

    @FXML
    void loadSearch(ActionEvent event) throws IOException {
        loader("/MainStructure/search/search.fxml", "Search");
    }

    @FXML
    void loadPreferences(ActionEvent event) throws IOException {
        loader("/MainStructure/preferences/preferences.fxml", "Preferences");
    }

    @FXML
    void loadUser(ActionEvent event) throws IOException {
        loader("/MainStructure/user/user.fxml", "User Info");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    void loader(String loc, String title) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

}
