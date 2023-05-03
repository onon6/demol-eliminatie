package com.dpeeters.molelim;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EliminationApplication.class.getResource("elimination.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        ObservableList<Screen> screenlist = Screen.getScreens();
        Screen activeScreen = Screen.getPrimary();
        if (screenlist.size() > 1) {
            activeScreen = screenlist.get(screenlist.size()-1); // No support for > 2 monitors
        }
        Rectangle2D screenBounds = activeScreen.getBounds();
        stage.setX(screenBounds.getMinX());
        stage.setY(screenBounds.getMinY());

        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.setTitle("De Mol - Eliminatie");
        stage.setScene(scene);
        stage.show();

        ((EliminationController) fxmlLoader.getController()).init();
    }

    public static void main(String[] args) {
        launch();
    }
}