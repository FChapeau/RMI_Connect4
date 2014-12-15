package client.mainView;
import javafx.util.Callback;

/**
 * Created by Chapeau on 2014-12-14.
 */
public class MainViewControllerFactory implements Callback <Class<?>, MainViewController> {

    private int Rows;
    private int Columns;

    public MainViewControllerFactory(int rows, int columns) {
        Rows = rows;
        Columns = columns;
    }

    @Override
    public MainViewController call(Class<?> aClass) {
        return new MainViewController(Rows, Columns);
    }
}
