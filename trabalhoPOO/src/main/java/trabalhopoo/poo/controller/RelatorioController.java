package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;
import trabalhopoo.poo.dao.DepartamentoDAO;
import trabalhopoo.poo.dao.FuncionarioDAO;
import trabalhopoo.poo.model.Departamento;
import trabalhopoo.poo.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class RelatorioController {

    @FXML
    private ListView<String> listViewRelatorio;

    @FXML
    public void initialize() {
        gerarRelatorio();
    }

    private void gerarRelatorio() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            listViewRelatorio.getItems().clear();
            List<Departamento> departamentos = departamentoDAO.listarTodos();
            for (Departamento departamento : departamentos) {
                StringBuilder relatorio = new StringBuilder(departamento.getNome() + ":");
                List<Funcionario> funcionarios = funcionarioDAO.listarTodos();
                for (Funcionario funcionario : funcionarios) {
                    if (funcionario.getDepartamento().getDepartamentoID() == departamento.getDepartamentoID()) {
                        relatorio.append("\n - ").append(funcionario.getNome());
                    }
                }
                listViewRelatorio.getItems().add(relatorio.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void voltarOnAction(ActionEvent event) {
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
