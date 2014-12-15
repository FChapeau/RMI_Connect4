package client.mainView;

import com.sun.javafx.geom.Vec2d;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import server.Model.Position;

import javax.annotation.Resources;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by boivi_000 on 2014-12-02.
 */
public class MainViewController implements Initializable{

    int rows;
    int columns;

    @FXML private GridPane GameGrid;
    HashMap<Position, Pane> displayGrid;

    public MainViewController(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        displayGrid = new HashMap<Position, Pane>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        GenerateGameGrid();
        System.out.println("initialize ran!");
    }

    private void GenerateGameGrid()
    {
        //TODO Prettification of gamegrid
        //TODO Solving the damned display problems...
        for (Integer i = 0; i < columns; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100/columns);
            GameGrid.getColumnConstraints().add(column);

            for (Integer j = 0; j <= rows; j++)
            {
                if (i == 0 && j != rows)
                {
                    RowConstraints row = new RowConstraints();
                    row.setPercentHeight(100/rows);
                    GameGrid.getRowConstraints().add(row);
                }

                if (j == 0)
                {
                    Pane pane = new Pane();
                    Button button = new Button();

                    button.setText("V");
                    button.setId("ColumnSelector-" + i);
                    //TODO Add button action event handler

                    pane.getChildren().addAll(button);
                    GameGrid.add(pane, i, j);
                }
                else
                {
                    Pane pane = new Pane();
                    pane.setId("Cell-" + j + "-" + i);
                    displayGrid.put(new Position(j,i), pane);
                    GameGrid.add(pane, i, j);
                }
            }
        }
    }

    @FXML public void SetCellColorMenuAction (ActionEvent event)
    {
        for (Pane p : displayGrid.values())
        {
            p.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                @Override
                public void handle(ContextMenuEvent contextMenuEvent) {
                    CellContextMenuRequested(contextMenuEvent);
                }
            });
        }
    }

    @FXML public void CellContextMenuRequested(ContextMenuEvent event)
    {
        Pane source = (Pane)event.getSource();
        System.out.println("Clicked!" + source.getId());
        Position pos = ParseCellName(source.getId());

        if (source.getStyle().equals("-fx-background-color: red"))
        {
            //source.setStyle("-fx-background-color: blue");
            SetCellColor(pos.getPosX(), pos.getPosY(), Color.BLUE);
        }
        else
        {
            SetCellColor(pos.getPosX(), pos.getPosY(), Color.RED);
        }
    }

    private Position ParseCellName(String name)
    {
        String[] split = name.split("-");
        return new Position(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void SetCellColor (int row, int column, Color color)
    {
        Pane pane = displayGrid.get(new Position(row, column));


        if (color == Color.RED)
        {
            pane.setStyle("-fx-background-color: red");
        }
        else
        {
            pane.setStyle("-fx-background-color: blue");
        }
    }

}
