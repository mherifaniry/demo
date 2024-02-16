package com.mherifaniry.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {
    double x, y;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalesView.class.getResource("principale.fxml"));
        Parent root =  fxmlLoader.load();
        Scene scene = new Scene(root, 700, 500);
        //stage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(evt ->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        root.setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX() - x);
            stage.setY(evt.getScreenY() - y);
        });
        scene.getStylesheets().add(PrincipalesView.class.getResource("css/Styling.css").toExternalForm());

        stage.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                PrincipalesView principalesView = fxmlLoader.getController();
                principalesView.initialLoad();
            }
        });

        stage.setTitle("Cashflow");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}