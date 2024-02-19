package com.mherifaniry.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class PrincipalesView {


    @FXML
    private static BorderPane middleBP;
    @FXML
    private static Button rapportsBtn, budgetsBtn, transactionsBtn, planningBtn, paramètresBtn;
    private static  FXMLLoader fxmlLoader;
    private static  RapportsView rapportsView;
    private static  Parent root;

    public static void setMiddleBP() throws IOException {
        fxmlLoader = new FXMLLoader(PrincipalesView.class.getResource("principale.fxml"));
        root = fxmlLoader.load();
        middleBP = (BorderPane) root.lookup("#middleBP");

        //btn initialisation & event intialization
        rapportsBtn = (Button) root.lookup("#rapportsBtn");
        budgetsBtn = (Button) root.lookup("#budgetsBtn");
        transactionsBtn = (Button) root.lookup("#transactionsBtn");
        planningBtn = (Button) root.lookup("#planningBtn");
        paramètresBtn = (Button) root.lookup("#paramètresBtn");

        // Event Btn "Rapports" on click
        rapportsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    initializeRapportsContents(RapportsView.class, "rapports.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Event btn "Budgets" on click
        budgetsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    initializeRapportsContents(BudgetsView.class, "budgets.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public static   BorderPane getMiddleBP() {
        return middleBP;
    }

    public static   FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public static  RapportsView getRapportsView() {
        return rapportsView;
    }

    public static  Parent getRoot() {
        return root;
    }

    public static void initializeRapportsContents(Class<?> theClass, String xmlfile) throws IOException{
        FXMLLoader theclassViewFxml = new FXMLLoader(theClass.getResource(xmlfile));
        getMiddleBP().setCenter(theclassViewFxml.load());
        switch (theClass.getName())
        {
            case "com.mherifaniry.view.RapportsView":
                rapportsView = theclassViewFxml.getController();
                rapportsView.initialLoad();
                System.out.print("passing here");
                break;
        }
    }


}
