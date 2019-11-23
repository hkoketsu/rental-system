package ca.ubc.cs304.app;

import ca.ubc.cs304.controller.PageController;
import ca.ubc.cs304.controller.PageController1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Super Rent");

        this.setPage(PageController1.class, "1");
    }

    public void setPage(Class<? extends PageController> controllerClass, String pageNumber, Object[]...params) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(controllerClass.getResource("fxml/" + pageNumber + ".fxml"));

        Parent pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PageController controller = loader.getController();
        controller.setApp(this);

        if (params != null && params.length > 0) {
            controller.loadParameter(params);
        }

        if (pane != null) {
            Scene scene = new Scene(pane);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
