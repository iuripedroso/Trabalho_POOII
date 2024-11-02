package trabalhopoo.poo.controller;

import javafx.scene.Node;
import trabalhopoo.poo.dao.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import trabalhopoo.poo.dao.FuncionarioDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class ExcluirFuncionarioController {

    @FXML
    private TextField txtIdFuncionario; // Campo para o ID do funcionário

    @FXML
    public void initialize() {
        // Inicializar qualquer lógica se necessário
    }

    @FXML
    private void btnExcluirOnAction(ActionEvent event) {
        // Obtendo o ID do funcionário a partir do campo de texto
        int funcionarioId = Integer.parseInt(txtIdFuncionario.getText());

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            // Chama o método excluir da classe FuncionarioDAO
            funcionarioDAO.excluir(funcionarioId);

            // Exibir uma mensagem de sucesso
            Alert alert = new Alert(AlertType.INFORMATION, "Funcionário excluído com sucesso!", ButtonType.OK);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.showAndWait();

            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageAtual.close();

        } catch (SQLException e) {
            // Exibir uma mensagem de erro
            Alert alert = new Alert(AlertType.ERROR, "Erro ao excluir funcionário!", ButtonType.OK);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {
        // Fecha a tela atual
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
