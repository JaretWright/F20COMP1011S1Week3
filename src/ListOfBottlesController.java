import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOfBottlesController {
    @FXML
    void changeToCreateView(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass()
//                .getResource("createHandSanitizerView.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Hand Sanitizer GUI cool thing");
//        stage.show();
        SceneChanger.changeScene(event,"createHandSanitizerView.fxml",
                "create hand Sanitizer bottle");
    }
}
