package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trabalhopoo.poo.dao.DepartamentoDAO;

import java.sql.SQLException;

public class ExcluirDepartamentoController {

    @FXML
    private TextField txtIdDepartamento;

    @FXML
    private void btnExcluirOnAction(ActionEvent event) {
        int idDepartamento = Integer.parseInt(txtIdDepartamento.getText());
        DepartamentoDAO departamentoDAO = new DepartamentoDAO(); // Ajuste os parâmetros conforme necessário

        try {
            departamentoDAO.excluir(idDepartamento);
            Alert alert = new Alert(AlertType.INFORMATION, "Departamento excluído com sucesso!", ButtonType.OK);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.showAndWait();
            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageAtual.close();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Erro ao excluir departamento!", ButtonType.OK);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    private void btnVoltarOnAction(ActionEvent event) {
        Stage stageAtual = (Stage) txtIdDepartamento.getScene().getWindow();
        stageAtual.close();
    }
}
