package client.startView;

import client.mainView.MainViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.lipermi.handler.CallHandler;

import java.io.IOException;

/**
 * Created by Chapeau on 2014-12-02.
 */
public class StartViewController {

    @FXML private TextField ConnectionStringBox;

    @FXML public void ConnectToServer()
    {
        int rows = 5;
        int columns = 5;

        //TODO Connection logic

        try {
            OpenMainView(rows,columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenMainView( int rows, int columns ) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainViewController.class.getResource("MainView.fxml"));
        loader.setController(new MainViewController(rows, columns));

        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Connect4 - Game");
        stage.setScene(new Scene(root));
        stage.show();

        Stage currentStage = (Stage)ConnectionStringBox.getScene().getWindow();
        currentStage.close();

        CallHandler callHandler;
    }
}
