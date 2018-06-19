import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class MineField extends Pane {
    private final double TILE_SIZE = 50;
    private final double X_DISPLACEMENT = TILE_SIZE / 2;
    private final double Y_DISPLACEMENT = TILE_SIZE * 0.15;
    private int X_TILES = 9;
    private int Y_TILES = 9;
    private Tile[][] field = new Tile[X_TILES][Y_TILES];

    public MineField() {
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                Tile tile = new Tile(x, y , TILE_SIZE, X_DISPLACEMENT, Y_DISPLACEMENT);
                field[x][y] = tile;
                getChildren().add(tile);
            }
        }
        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) System.out.println("LMB");
            if (e.getButton() == MouseButton.SECONDARY) System.out.println("RMB");
        });
    }

    public List<Tile> getNeighbours(Tile tile) {
        List<Tile> neighbours = new ArrayList<>();
        int x = tile.getxCoord();
        int y = tile.getyCoord();

        if (y-1 >= 0) neighbours.add(field[x][y-1]);
        if (y+1 < Y_TILES) neighbours.add(field[x][y+1]);
        if (x-1 >= 0) neighbours.add(field[x-1][y]);
        if (x+1 < X_TILES) neighbours.add(field[x+1][y]);
        if (x % 2 == 0 && y > 0) {
            if (x-1 >= 0) neighbours.add(field[x-1][y-1]);
            if (x+1 < X_TILES) neighbours.add(field[x+1][y-1]);
        } else if (y < Y_TILES - 1) {
            if (x-1 >= 0) neighbours.add(field[x-1][y+1]);
            if (x+1 < X_TILES) neighbours.add(field[x+1][y+1]);
        }
        return neighbours;
    }

    public void open(Tile tile) {
        if (tile.isOpen())
            return;
        if (tile.isMined()) {
            for (Tile[] t : field)
                for (Tile e: t)
                    if (e.isMined()) e.setOpen();
            FailWindow.openFailWindow();
            return;
        }

        tile.setOpen();
        if (tile.getText().isEmpty()) {
            for (Tile t :this.getNeighbours(tile))
                this.open(t);
        }
    }



    public double getTILE_SIZE() {
        return TILE_SIZE;
    }

    public double getX_DISPLACEMENT() {
        return X_DISPLACEMENT;
    }

    public double getY_DISPLACEMENT() {
        return Y_DISPLACEMENT;
    }

    public int getX_TILES() {
        return X_TILES;
    }

    public int getY_TILES() {
        return Y_TILES;
    }
}


