package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trabalhopoo.poo.dao.DepartamentoDAO;
import trabalhopoo.poo.model.Departamento;

import java.sql.SQLException;

public class IncluiDepartamentoController {

    @FXML
    private TextField txtNomeDep;

    @FXML
    private Button btnConfirmaDep;

    @FXML
    private Button btnVoltarDep;

    @FXML
    private void btnConfirmaDepOnAction(ActionEvent event) {
        Departamento departamento = new Departamento();
        departamento.setNome(txtNomeDep.getText());

        DepartamentoDAO depDAO = new DepartamentoDAO();
        try {
            depDAO.inserir(departamento);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Departamento cadastrado com sucesso!");
            alert.show();

            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageAtual.close();


        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao cadastrar departamento.");
            alert.show();
            e.printStackTrace();
        }
    }

    @FXML
    private void btnVoltarDepOnAction(ActionEvent event) {
        // Fecha a tela atual
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
