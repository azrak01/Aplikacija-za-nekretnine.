package com.example.drugaparcijala.controllers;

import com.example.drugaparcijala.models.Nekretnina;
import com.example.drugaparcijala.repository.NekretninaRepository;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javax.swing.*;
import java.time.LocalDate;

public class DodavanjeNekretnineController {
    private NekretninaRepository nekretninaRepository;

    private Stage stage;

    @FXML
    private TextField jedinstveniBrojTextField;

    @FXML
    private TextField adresaTextField;

    @FXML
    private TextField gradTextField;

    @FXML
    private TextField cijenaTextField;

    @FXML
    private DatePicker datumProdajeDatePicker;

    @FXML
    private TextField cijenaProdajeTextField;

    @FXML
    private TextArea komentarTextArea;

    @FXML
    private CheckBox nekretninaSeIProdajeCheckBox;

    public void setNekretninaRepository(NekretninaRepository nekretninaRepository) {
        this.nekretninaRepository = nekretninaRepository;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void dodajNekretninu() {
        String jedinstveniBroj = jedinstveniBrojTextField.getText();
        String adresa = adresaTextField.getText();
        String grad = gradTextField.getText();
        double cijena = Double.parseDouble(cijenaTextField.getText());
        LocalDate datumProdaje = datumProdajeDatePicker.getValue();
        double cijenaProdaje = Double.parseDouble(cijenaProdajeTextField.getText());
        String komentar = komentarTextArea.getText();
        boolean prodajaAktivna = nekretninaSeIProdajeCheckBox.isSelected();

        Nekretnina nekretnina = new Nekretnina(jedinstveniBroj, adresa, grad, cijena, datumProdaje,
                cijenaProdaje, komentar, prodajaAktivna);

        nekretninaRepository.save(nekretnina);


        stage.close();
    }

    @FXML
    private void spremiNekretninu() {
        String jedinstveniBroj = jedinstveniBrojTextField.getText();
        String adresa = adresaTextField.getText();
        String grad = gradTextField.getText();
        double cijena = Double.parseDouble(cijenaTextField.getText());
        LocalDate datumProdaje = datumProdajeDatePicker.getValue();
        double cijenaProdaje = Double.parseDouble(cijenaProdajeTextField.getText());
        String komentar = komentarTextArea.getText();
        boolean prodajaAktivna = nekretninaSeIProdajeCheckBox.isSelected();

        Nekretnina nekretnina = new Nekretnina(jedinstveniBroj, adresa, grad, cijena, datumProdaje, cijenaProdaje, komentar, prodajaAktivna);
        nekretninaRepository.dodajNekretninu(nekretnina);

        closeWindow();
    }

    @FXML
    private void cancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) jedinstveniBrojTextField.getScene().getWindow();
        stage.close();
    }

    public void setSelektiranaNekretnina(Nekretnina selectedNekretnina) {
    }
}