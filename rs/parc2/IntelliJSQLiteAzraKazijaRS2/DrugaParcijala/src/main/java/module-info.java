module com.example.drugaparcijala {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drugaparcijala to javafx.fxml;
    opens com.example.drugaparcijala.models to javafx.base, org.hibernate.orm.core;
    opens com.example.drugaparcijala.controllers to javafx.fxml;
    exports com.example.drugaparcijala;
    exports com.example.drugaparcijala.models;
    exports com.example.drugaparcijala.repository;

    requires java.sql;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.desktop;
}