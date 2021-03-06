package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Chapeau on 2014-12-02.
 */
public class Startup extends Application {

    public static void main(String[] args)
    {
        launch(args);
        //System.out.println(StartViewController.class.getResource("StartView.fxml").getPath());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/StartView.fxml"));
        primaryStage.setTitle("Connect4 - Server connection");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
