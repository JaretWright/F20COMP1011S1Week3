import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
                outputLabel.setText(hs.toString());
            }
            catch (IllegalArgumentException e)
            {
                outputLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * Check if there is a value in each input field.  If not, provide a useful
     * message to the user and return false.
     * @return true if all fields have values, false otherwise
     */
    public boolean allFieldsArePopulated()
    {
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
        alcoholTextField.setPromptText("Enter Alcohol %");

        //configure the combobox
        materialComboBox.getItems().addAll("glass","plastic","metal");
        materialComboBox.setPromptText("Select a material");

        //configure the spinner
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 30);
        volumeSpinner.setValueFactory(valueFactory);
        volumeSpinner.setEditable(true);

    }
}
