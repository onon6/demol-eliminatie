package com.dpeeters.molelim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EliminationApplication.class.getResource("elimination.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.sizeToScene();
        stage.setTitle("De Mol - Eliminatie");
        stage.setScene(scene);
        stage.show();

        ((EliminationController) fxmlLoader.getController()).init();
    }

    public static void main(String[] args) {
        launch();
    }
}