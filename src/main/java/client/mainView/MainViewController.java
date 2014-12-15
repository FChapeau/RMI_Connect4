package client.mainView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import javax.annotation.Resources;
import java.net.URL;

/**
 * Created by boivi_000 on 2014-12-02.
 */
public class MainViewController {

    int rows;
    int columns;

    @FXML private GridPane GameGrid;

    public MainViewController(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @FXML
    public void initialize(){
        //TODO Procedural generation of game grid

        for (int i = 0; i < columns-1; i++)
        {
            for (int j = 0; j < rows; j++)
            {

            }
        }
        System.out.println("initialize ran!");
    }


}
