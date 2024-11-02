package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trabalhopoo.poo.dao.DepartamentoDAO;
import trabalhopoo.poo.dao.FuncionarioDAO;
import trabalhopoo.poo.model.Departamento;
import trabalhopoo.poo.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class IncluiFuncionarioController {

    @FXML
    private TextField txtNomeFunc;

    @FXML
    private ComboBox<Departamento> comboDepartamento;

    @FXML
    private Button btnConfirmaFunc;

    @FXML
    private Button btnVoltarFunc;

    @FXML
    public void initialize() {
        carregarDepartamentos();
    }

    private void carregarDepartamentos() {
        DepartamentoDAO depDAO = new DepartamentoDAO();
        try {
            List<Departamento> departamentos = depDAO.listarTodos();
            comboDepartamento.getItems().addAll(departamentos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnConfirmaFuncOnAction(ActionEvent event) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(txtNomeFunc.getText());
        funcionario.setDepartamento(comboDepartamento.getValue());

        FuncionarioDAO funcDAO = new FuncionarioDAO();
        try {
            funcDAO.inserir(funcionario);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Funcionário cadastrado com sucesso!");
            alert.show();


            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageAtual.close();

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao cadastrar funcionário.");
            alert.show();
            e.printStackTrace();
        }
    }

    @FXML
    private void btnVoltarFuncOnAction(ActionEvent event) {
        // Fecha a tela atual
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }

}
