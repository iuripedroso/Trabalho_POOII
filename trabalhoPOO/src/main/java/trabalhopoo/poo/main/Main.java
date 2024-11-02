package trabalhopoo.poo.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Carrega o arquivo FXML do menu principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/trabalhopoo/poo/view/Menus.fxml"));
        Parent root = loader.load();

        // Cria a cena e configura o stage
        Scene scene = new Scene(root);
        stage.setTitle("Gerenciamento de Funcionários e Departamentos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    } // launch é um metodo estatico da classe aplication
}
