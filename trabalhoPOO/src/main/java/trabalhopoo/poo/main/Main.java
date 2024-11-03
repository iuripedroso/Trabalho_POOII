package trabalhopoo.poo.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        abrirTelaApresentacao();
    }

    private void abrirTelaApresentacao() throws IOException {
        Stage apresentacaoStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/trabalhopoo/poo/view/Apresentacao.fxml"));
        apresentacaoStage.setTitle("Apresentação");
        apresentacaoStage.setScene(new Scene(root, 400, 200));
        apresentacaoStage.setResizable(false);
        apresentacaoStage.show();

        apresentacaoStage.setOnHidden(event -> {
            try {
                abrirTelaPrincipal();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void abrirTelaPrincipal() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/trabalhopoo/poo/view/Menus.fxml"));
        primaryStage.setTitle("Gerenciamento de Funcionários e Departamentos");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Cancela o fechamento padrão
            abrirTelaFinalizacao();
        });
    }

    private void abrirTelaFinalizacao() {
        Stage finalizacaoStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/trabalhopoo/poo/view/Finalizacao.fxml"));
            finalizacaoStage.setTitle("Finalização");
            finalizacaoStage.setScene(new Scene(root, 400, 200));
            finalizacaoStage.setResizable(false);
            finalizacaoStage.show();

            finalizacaoStage.setOnHidden(event -> {
                primaryStage.close(); // Fecha o estágio principal após a tela de finalização
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
