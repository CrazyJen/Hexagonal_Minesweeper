import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private int xCoord, yCoord;
    private boolean isOpen = false;
    private boolean isMined = false;
    private boolean isFlagged = false;
    private boolean hasQuestion = false;
    private Circle border;
    private Text text = new Text();


    public Tile(int xCoord, int yCoord, double TILE_SIZE, double X_DISPLACEMENT, double Y_DISPLACEMENT) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.border = new Circle(TILE_SIZE / 2 - 2);

        border.setFill(Color.GRAY);
        border.setStroke(Color.BLACK);

        text.setFont(Font.font(18));
        text.setVisible(false);

        getChildren().addAll(border, text);


        double translateY = xCoord * (TILE_SIZE - X_DISPLACEMENT);
        double translateX;
        if (xCoord % 2 == 0) translateX = yCoord * TILE_SIZE;
        else translateX = yCoord * TILE_SIZE + Y_DISPLACEMENT;


        setTranslateX(translateX);
        setTranslateY(translateY);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getText() {
        return text.getText();
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isMined() {
        return isMined;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public boolean hasQuestion() {
        return hasQuestion;
    }

    public void setOpen() {
        isOpen = true;
        border.setFill(null);
        text.setVisible(true);
    }

    public void setMined() {
        isMined = true;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public void setQuestion(boolean hsQuestion) {
        hasQuestion = hsQuestion;
    }

    public void setText(String string) {
        this.text.setText(string);
    }
}
