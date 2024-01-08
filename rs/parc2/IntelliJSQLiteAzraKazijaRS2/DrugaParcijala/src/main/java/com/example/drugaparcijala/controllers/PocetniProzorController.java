package com.example.drugaparcijala.controllers;

import com.example.drugaparcijala.models.Nekretnina;
import com.example.drugaparcijala.repository.NekretninaRepository;
import com.example.drugaparcijala.controllers.DodavanjeNekretnineController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class PocetniProzorController {
    private NekretninaRepository nekretninaRepository;

    private Stage stage;

    @FXML
    private TableView<Nekretnina> nekretnineTableView;

    @FXML
    private TableColumn<Nekretnina, String> datumDodavanjaColumn;

    @FXML
    private TableColumn<Nekretnina, String> jedinstveniBrojColumn;

    @FXML
    private TableColumn<Nekretnina, String> adresaColumn;

    @FXML
    private TableColumn<Nekretnina, Double> cijenaColumn;

    @FXML
    private Button dodajNekretninuButton;

    public void setNekretninaRepository(NekretninaRepository nekretninaRepository) {
        this.nekretninaRepository = nekretninaRepository;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {

        datumDodavanjaColumn.setCellValueFactory(new PropertyValueFactory<>("datumDodavanja"));
        jedinstveniBrojColumn.setCellValueFactory(new PropertyValueFactory<>("jedinstveniBroj"));
        adresaColumn.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        cijenaColumn.setCellValueFactory(new PropertyValueFactory<>("cijena"));


        List<Nekretnina> nekretnine = nekretninaRepository.findAll();
        nekretnineTableView.getItems().addAll(nekretnine);


        nekretnineTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                dodajNekretninuButton.setDisable(false);
            } else {

                dodajNekretninuButton.setDisable(true);
            }
        });
    }

    @FXML
    private void dodajNekretninu() {

        Nekretnina selectedNekretnina = nekretnineTableView.getSelectionModel().getSelectedItem();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/forma.fxml"));
            Stage formaStage = new Stage();
            formaStage.setScene(new Scene(loader.load()));
            formaStage.setTitle("Dodavanje nove nekretnine");
            DodavanjeNekretnineController controller = loader.getController();
            controller.setNekretninaRepository(nekretninaRepository);
            controller.setStage(formaStage);


            if (selectedNekretnina != null) {
                controller.setSelektiranaNekretnina(selectedNekretnina);
            }

            formaStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

