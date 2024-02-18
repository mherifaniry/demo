package com.mherifaniry.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {
    double x, y;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =  PrincipalesView.getContruct();
        Parent root =  fxmlLoader.load();
        Scene scene = new Scene(root, 700, 500);
        stage.initStyle(StageStyle.TRANSPARENT);
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

                FXMLLoader rapportsView = new FXMLLoader(RapportsView.class.getResource("rapports.fxml"));
                BorderPane borderPane = (BorderPane) root.lookup("#middleBP");
                try {
                    borderPane.setCenter(rapportsView.load());
                    RapportsView rapportsView1 = rapportsView.getController();
                    rapportsView1.initialLoad();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


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