import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SettingsWindow {
    public static void openSettings() {
        Stage settingsWindow = new Stage();
        settingsWindow.initModality(Modality.APPLICATION_MODAL);
        settingsWindow.setTitle("Настройки");

        Text widthText = new Text("Ячеек в ширину (9-30):");
        TextField widthTextField = new TextField("9");
        HBox widthHBox = new HBox(widthText, widthTextField);
        widthHBox.setSpacing(5);
        widthHBox.setAlignment(Pos.CENTER);

        Text heightText = new Text("Ячеек в высоту (9-24):");
        TextField heightTextField = new TextField("9");
        HBox heightHBox = new HBox(heightText, heightTextField);
        heightHBox.setSpacing(5.0);
        heightHBox.setAlignment(Pos.CENTER);

        Text minesText = new Text("Количество мин:");
        TextField minesTextField = new TextField("15");
        HBox minesHBox = new HBox(minesText, minesTextField);
        minesHBox.setSpacing(5.0);
        minesHBox.setAlignment(Pos.CENTER);

        Button okButton = new Button("OK"),
                cancelButton = new Button("Отмена");
        cancelButton.setOnAction(e -> settingsWindow.close());
        HBox buttons = new HBox(okButton, cancelButton);
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(widthHBox, heightHBox, minesHBox, buttons);
        vBox.setSpacing(5);
        BorderPane settings = new BorderPane();
        settings.setCenter(vBox);
        settings.setTop(new HBox(new Text("")));

        Scene settingsScene = new Scene(settings, 330, 150);
        settingsWindow.setScene(settingsScene);
        settingsWindow.show();
    }
}
