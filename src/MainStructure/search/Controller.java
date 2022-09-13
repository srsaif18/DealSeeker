package MainStructure.search;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextField searchInput;

    @FXML
    private JFXButton goSearch;

    @FXML
    public void setGoSearch() {
        goSearch.setOnAction(event -> display(searchInput.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    public void display(String search) {
        Stage window = new Stage();

        window.setTitle("Your Searched " + "\"" + search + "\"");
        window.initModality(Modality.WINDOW_MODAL);

        String[] urls = new String[]{
                    "https://www.youtube.com/results?search_query=" + search,
                    "https://www.startech.com.bd/product/search?search=" + search,
                    "https://www.ryanscomputers.com/search?q=" + search,
        };

        FlowPane root = new FlowPane();

        for (String url : urls) {
            WebView webView = new WebView();
            webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) ->
                        System.out.println(url + " " + oldState + " -> " + newState));
            webView.getEngine().load(url);
            webView.setMaxSize(550, 600);
            root.getChildren().addAll(webView);
            }

        Scene scene = new Scene(root, 1650, 600);
        window.setScene(scene);
        window.showAndWait();
    }
}

