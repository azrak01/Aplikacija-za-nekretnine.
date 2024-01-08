package com.example.drugaparcijala;


import com.example.drugaparcijala.controllers.PocetniProzorController;
import com.example.drugaparcijala.repository.NekretninaRepository;
import com.example.drugaparcijala.repository.NekretninaRepositoryImpl;

import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        NekretninaRepository nekretninaRepository = new NekretninaRepositoryImpl();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pocetni_prozor.fxml"));
        Parent root = loader.load();


        PocetniProzorController controller = loader.getController();
        controller.setNekretninaRepository(nekretninaRepository);


        primaryStage.setTitle("Druga parcijala");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
