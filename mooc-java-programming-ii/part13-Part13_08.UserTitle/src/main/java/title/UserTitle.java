package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("Title");
        
        window.setTitle(title);
        window.show();
    }
}
