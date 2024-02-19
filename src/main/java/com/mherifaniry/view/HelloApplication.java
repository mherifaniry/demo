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
    private BorderPane borderPane;
    private FXMLLoader rapportsView;
    @Override
    public void start(Stage stage) throws IOException {

        // initialisation of principal variable

        PrincipalesView.setMiddleBP();

        //initialize scene
        Scene scene = new Scene(PrincipalesView.getRoot(), 700, 500);
        stage.initStyle(StageStyle.TRANSPARENT);

        PrincipalesView.getRoot().setOnMousePressed(evt ->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        PrincipalesView.getRoot().setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX() - x);
            stage.setY(evt.getScreenY() - y);
        });

        scene.getStylesheets().add(PrincipalesView.class.getResource("css/Styling.css").toExternalForm());

        stage.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                try {
                    PrincipalesView.initializeRapportsContents(RapportsView.class, "rapports.fxml");
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