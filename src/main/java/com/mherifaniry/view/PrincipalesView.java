package com.mherifaniry.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PrincipalesView {


    @FXML
    private static BorderPane middleBP;
    @FXML
    private static Button rapportsBtn, budgetsBtn, transactionsBtn, planningBtn, parametresBtn;
    private static  FXMLLoader principaleFxmlLoader;

    private static  RapportsView rapportsView;
    private static BudgetsView budgetsView;
    private static TransactionsView transactionsView;
    private static PlanningsViews planningsViews;
    private static ParametresViews parametresViews;
    private static  Parent root;
    private static Map<Button, Class<?>> listBtnPbLeft;

    public static void putParametersBtn(String id, Button btn, String file, Class<?> hisClass)
    {
        btn = (Button) root.lookup(id); // get btn by id
        btn.setUserData(file); // add default value to the btn
        listBtnPbLeft.put(btn, hisClass);
    }

    public static void setMiddleBP() throws IOException {

        principaleFxmlLoader = new FXMLLoader(PrincipalesView.class.getResource("principale.fxml"));
        root = principaleFxmlLoader.load();
        middleBP = (BorderPane) root.lookup("#middleBP");

        //btn initialisation & event intialization
        listBtnPbLeft = new HashMap<>();
        putParametersBtn("#rapportsBtn",rapportsBtn, "rapports.fxml", RapportsView.class);
        putParametersBtn("#budgetsBtn",budgetsBtn, "budgets.fxml", BudgetsView.class);
        putParametersBtn("#transactionsBtn",transactionsBtn, "transactions.fxml", TransactionsView.class);
        putParametersBtn("#planningBtn",planningBtn, "plannings.fxml", PlanningsViews.class);
        putParametersBtn("#parametresBtn",parametresBtn, "parametres.fxml", ParametresViews.class);

        // adding event listenr to all btn
        for(Button btn: listBtnPbLeft.keySet())
        {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        initializeRapportsContents((Class<?>) listBtnPbLeft.get(btn),(String) btn.getUserData());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }

    public static   BorderPane getMiddleBP() {
        return middleBP;
    }

    public static   FXMLLoader getPrincipaleFxmlLoader() {
        return principaleFxmlLoader;
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
        View rapportsView = theclassViewFxml.getController();
        rapportsView.initialLoad();

    }


}
