package com.mherifaniry.view;

import com.mherifaniry.wcontroller.TransactionsController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mherifaniry.entity.Transactions;

import java.sql.Timestamp;

public class RapportsView implements View{
    @FXML
    private TableView<Transactions> table_transactions;
    @FXML private TableColumn<Transactions, Long> id;
    @FXML private TableColumn<Transactions, Timestamp> dateDeTransaction;
    @FXML private TableColumn<Transactions, String> categorie;
    @FXML private TableColumn<Transactions, String> personne;
    @FXML private TableColumn<Transactions, Double> montant;
    @FXML private TableColumn<Transactions, String> description;
    @FXML private TableColumn<Transactions, String> types;



    @Override
    public void initialLoad(){
        this.loadTransationOnTable(table_transactions, id, dateDeTransaction, categorie, personne, montant, description, types);
    }

    private void loadTransationOnTable(
            TableView<Transactions> table_transactions,
            TableColumn<Transactions, Long> id,
            TableColumn<Transactions, Timestamp> dateDeTransaction,
            TableColumn<Transactions, String> categorie,
            TableColumn<Transactions, String> personne,
            TableColumn<Transactions, Double> montant,
            TableColumn<Transactions, String> description,
            TableColumn<Transactions, String> types
    ){

        ObservableList<Transactions> list = null;
        TransactionsController transactionsController = new TransactionsController();
        list = FXCollections.observableArrayList(transactionsController.list());
        id.setCellValueFactory(new PropertyValueFactory<Transactions, Long>("id"));
        dateDeTransaction.setCellValueFactory(new PropertyValueFactory<Transactions, Timestamp>("dateDeTransaction"));

        categorie.setCellValueFactory( cellData -> {
                    Transactions transactions = cellData.getValue();
                    if (transactions != null && transactions.getCategorie() != null) {
                        return new SimpleStringProperty(transactions.getCategorie().getLibelle());
                    } else {
                        return new SimpleStringProperty("");
                    }
                }
        );

        personne.setCellValueFactory(cellData -> {
            Transactions transaction = cellData.getValue();
            if (transaction != null && transaction.getPersonne() != null) {
                return new SimpleStringProperty(transaction.getPersonne().getName());
            } else {
                return new SimpleStringProperty("");
            }
        });
        montant.setCellValueFactory(new PropertyValueFactory<Transactions, Double>("montant"));
        description.setCellValueFactory(new PropertyValueFactory<Transactions, String>("description"));
        types.setCellValueFactory(new PropertyValueFactory<Transactions, String>("types"));;
        table_transactions.setItems(list);
    }

    public void revenusBtn(){
        System.out.println("Working");
    }

}
