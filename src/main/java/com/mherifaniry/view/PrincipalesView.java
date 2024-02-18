package com.mherifaniry.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class PrincipalesView {


    @FXML
    private static BorderPane middleBP;
    private static FXMLLoader fxmlLoader;

    public static FXMLLoader getContruct(){
        return fxmlLoader = new FXMLLoader(PrincipalesView.class.getResource("principale.fxml"));
    }

    public static void setMiddleBP(FXMLLoader fxmlLoader) throws IOException {
        middleBP.setCenter(fxmlLoader.load());
    }

}
