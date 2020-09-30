import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateHandSanitizerController implements Initializable {

    @FXML
    private TextField brandTextField;

    @FXML
    private Spinner<Integer> volumeSpinner;

    @FXML
    private ComboBox<String> materialComboBox;

    @FXML
    private TextField alcoholTextField;

    @FXML
    private Label outputLabel;

    @FXML
    void submitButtonClicked() {
        if (allFieldsArePopulated())
        {
            try {
                HandSanitizerBottle hs = new HandSanitizerBottle(
                        brandTextField.getText(),
                        volumeSpinner.getValue(),
                        materialComboBox.getValue(),
                        Double.parseDouble(alcoholTextField.getText()));
                outputLabel.setTextFill(Color.BLACK);
                outputLabel.setText(hs.toString());
            }
            catch (NumberFormatException ex)
            {
                outputLabel.setTextFill(Color.RED);
                outputLabel.setText("Volume must be a whole number 10-100");
            }
            catch (IllegalArgumentException e)
            {
                outputLabel.setTextFill(Color.RED);
                outputLabel.setText(e.getMessage());
            }
        }
    }

    @FXML
    void changeToListView(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass()
//                .getResource("listOfBottlesView.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Hand Sanitizer GUI cool thing");
//        stage.show();
        SceneChanger.changeScene(event,"listOfBottlesView.fxml","List View");
    }

    /**
     * Check if there is a value in each input field.  If not, provide a useful
     * message to the user and return false.
     * @return true if all fields have values, false otherwise
     */
    public boolean allFieldsArePopulated()
    {
        outputLabel.setTextFill(Color.RED);
        if (brandTextField.getText().isBlank())
        {
            outputLabel.setText("Please enter a brand");
            return false;
        }

        if (materialComboBox.getValue() == null)
        {
            outputLabel.setText("Please select a type of material for the bottle");
            return false;
        }

        if (alcoholTextField.getText().isBlank())
        {
            outputLabel.setText("Please enter the alcohol content");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outputLabel.setText("");
        alcoholTextField.setPromptText("Enter Alcohol %");

        //configure the combobox
        materialComboBox.getItems().addAll("glass","plastic","metal");
        materialComboBox.setPromptText("Select a material");

        //configure the spinner
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 30);
        volumeSpinner.setValueFactory(valueFactory);
        TextField editor = volumeSpinner.getEditor();
//        SpinnerChangeListener scl = new SpinnerChangeListener();
//        editor.textProperty().addListener(scl);

//        editor.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue,
//                                String oldValue, String newValue) {
//                outputLabel.setText("");
//                try {
//                    Integer.parseInt(newValue);
//                } catch (NumberFormatException e)
//                {
//                    editor.setText(oldValue);
//                    outputLabel.setTextFill(Color.RED);
//                    outputLabel.setText("Only whole numbers can be used for the volume");
//                }
//            }
//        });

        editor.textProperty().addListener((observableValue, oldValue, newValue) -> {
            outputLabel.setText("");
            try {
                Integer.parseInt(newValue);
            } catch (NumberFormatException e)
            {
                editor.setText(oldValue);
                outputLabel.setTextFill(Color.RED);
                outputLabel.setText("Only whole numbers can be used for the volume");
            }
        });
        volumeSpinner.setEditable(true);

    }
}
