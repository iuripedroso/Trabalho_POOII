package trabalhopoo.poo.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FinalizacaoController {

    @FXML
    private Text textoFinalizacao;

    @FXML
    public void initialize() {

        textoFinalizacao.setFill(javafx.scene.paint.Color.web("#0000FF"));

        // Criando a transição de entrada
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), textoFinalizacao);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Criando a transição de saída
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), textoFinalizacao);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setDelay(Duration.seconds(2)); // Delay antes da saída

        // Encadeando as transições
        fadeIn.setOnFinished(event -> fadeOut.play());
        fadeOut.setOnFinished(event -> {
            // Fecha a tela de finalização
            ((Stage) textoFinalizacao.getScene().getWindow()).close();
        });

        fadeIn.play();
    }
}
