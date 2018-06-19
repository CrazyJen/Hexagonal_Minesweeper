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

public class FailWindow {
    public static void openFailWindow() {
        Stage failWindow = new Stage();
        failWindow.initModality(Modality.APPLICATION_MODAL);
        failWindow.setTitle("Поражение");

        Text text = new Text("Вы проиграли!");

        Button newGameButton = new Button("Новая игра");
        newGameButton.setOnAction(e -> new Main().newGame());

        VBox vBox = new VBox(text, newGameButton);
        vBox.setSpacing(5);
        BorderPane settings = new BorderPane();
        settings.setCenter(vBox);
        settings.setTop(new HBox(new Text("")));

        Scene settingsScene = new Scene(settings, 330, 150);
        failWindow.setScene(settingsScene);
        failWindow.show();
    }
}
