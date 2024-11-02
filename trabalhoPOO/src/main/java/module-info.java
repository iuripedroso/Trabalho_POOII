

module trabalhopoo.poo {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires org.kordamp.bootstrapfx.core;
        requires transitive java.sql;

        opens trabalhopoo.poo.controller to javafx.fxml;
        exports trabalhopoo.poo.controller;

        opens trabalhopoo.poo.model to javafx.fxml;
        exports trabalhopoo.poo.model;

        opens trabalhopoo.poo.main to javafx.fxml;
        exports trabalhopoo.poo.main;

        opens trabalhopoo.poo.dao to javafx.fxml;
        exports trabalhopoo.poo.dao;

}
