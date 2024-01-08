package com.example.drugaparcijala.controllers;

import com.example.drugaparcijala.models.Nekretnina;
import com.example.drugaparcijala.repository.NekretninaRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class IzmjenaNekretnineController {
    private NekretninaRepository nekretninaRepository;

    private Stage stage;
    private Nekretnina selektiranaNekretnina;

    @FXML
    private TextField jedinstveniBrojTextField;

    @FXML
    private TextField adresaTextField;

    @FXML
    private TextField gradTextField;

    @FXML
    private TextField cijenaTextField;

    @FXML
    private Button spremiButton;

    public void setNekretninaRepository(NekretninaRepository nekretninaRepository) {
        this.nekretninaRepository = nekretninaRepository;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSelektiranaNekretnina(Nekretnina selektiranaNekretnina) {
        this.selektiranaNekretnina = selektiranaNekretnina;
        fillForm();
    }

    @FXML
    private void initialize() {
        // Dodavanje listenera na polja za validaciju unosa
        jedinstveniBrojTextField.textProperty().addListener((obs, oldText, newText) -> {
            validateInput();
        });

        adresaTextField.textProperty().addListener((obs, oldText, newText) -> {
            validateInput();
        });

        gradTextField.textProperty().addListener((obs, oldText, newText) -> {
            validateInput();
        });

        cijenaTextField.textProperty().addListener((obs, oldText, newText) -> {
            validateInput();
        });
    }

    private void fillForm() {
        if (selektiranaNekretnina != null) {
            jedinstveniBrojTextField.setText(selektiranaNekretnina.getJedinstveniBroj());
            adresaTextField.setText(selektiranaNekretnina.getAdresa());
            gradTextField.setText(selektiranaNekretnina.getGrad());
            cijenaTextField.setText(String.valueOf(selektiranaNekretnina.getCijena()));
        }
    }

    @FXML
    private void spremiIzmjene() {
        if (selektiranaNekretnina != null) {
            selektiranaNekretnina.setJedinstveniBroj(jedinstveniBrojTextField.getText());
            selektiranaNekretnina.setAdresa(adresaTextField.getText());
            selektiranaNekretnina.setGrad(gradTextField.getText());
            selektiranaNekretnina.setCijena(Double.parseDouble(cijenaTextField.getText()));

            nekretninaRepository.save(selektiranaNekretnina);
        }


        stage.close();
    }

    @FXML
    private void zatvoriProzor() {
        stage.close();
    }

    private void validateInput() {
        boolean isJedinstveniBrojValid = !jedinstveniBrojTextField.getText().isEmpty();
        boolean isAdresaValid = !adresaTextField.getText().isEmpty();
        boolean isGradValid = !gradTextField.getText().isEmpty();
        boolean isCijenaValid = cijenaTextField.getText().matches("\\d+(\\.\\d+)?");

        spremiButton.setDisable(!(isJedinstveniBrojValid && isAdresaValid && isGradValid && isCijenaValid));
    }
}