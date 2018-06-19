import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application{

    private Parent content() {
        BorderPane root = new BorderPane();
        MineField field = new MineField();

        Button newGameButton = new Button("Новая игра");
        newGameButton.setOnAction(e -> newGame());
        Button settingsButton = new Button("Настройки");
        settingsButton.setOnAction(e -> SettingsWindow.openSettings());
        ToolBar toolBar = new ToolBar(newGameButton, settingsButton);

        root.setTop(toolBar);
        root.setCenter(field);
        root.setPrefHeight(field.getTILE_SIZE() * (field.getY_TILES() + 1)
                - field.getY_DISPLACEMENT() * field.getY_TILES());
        root.setPrefWidth(field.getTILE_SIZE() * field.getX_TILES() + field.getX_DISPLACEMENT());
        return root;

    }

    private Scene scene = new Scene(content());

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hexagonal Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void newGame() {
        scene.setRoot(content());
    }



    public static void main(String[] args) {
        launch(args);
    }
}
