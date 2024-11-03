package trabalhopoo.poo.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ApresentacaoController {

    @FXML
    private Text textoApresentacao;

    @FXML
    public void initialize() {

        textoApresentacao.setFill(javafx.scene.paint.Color.web("#0000FF"));

        // Criando a transição de entrada
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), textoApresentacao);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Criando a transição de saída
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), textoApresentacao);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setDelay(Duration.seconds(2)); // Delay antes da saída

        // Encadeando as transições
        fadeIn.setOnFinished(event -> fadeOut.play());
        fadeOut.setOnFinished(event -> ((Stage) textoApresentacao.getScene().getWindow()).close());

        fadeIn.play();
    }
}
