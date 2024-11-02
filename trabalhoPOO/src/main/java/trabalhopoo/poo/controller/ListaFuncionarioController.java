package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.SQLException;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;
import trabalhopoo.poo.dao.FuncionarioDAO;
import trabalhopoo.poo.model.Funcionario;

public class ListaFuncionarioController {

    @FXML
    private ListView<String> listViewFuncionarios;

    @FXML
    public void initialize() {
        atualizarListaFuncionarios();
    }

    private void atualizarListaFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            listViewFuncionarios.getItems().clear();
            for (Funcionario funcionario : funcionarioDAO.listarTodos()) {
                listViewFuncionarios.getItems().add(funcionario.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void voltarOnAction(ActionEvent event) {
        // Fecha a tela atual
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
