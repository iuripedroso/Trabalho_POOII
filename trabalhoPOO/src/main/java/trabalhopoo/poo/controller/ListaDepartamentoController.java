package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.SQLException;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;
import trabalhopoo.poo.dao.DepartamentoDAO;
import trabalhopoo.poo.model.Departamento;

public class ListaDepartamentoController {

    @FXML
    private ListView<String> listViewDepartamentos;

    @FXML
    public void initialize() {
        atualizarListaDepartamentos();
    }

    private void atualizarListaDepartamentos() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {
            listViewDepartamentos.getItems().clear();
            for (Departamento departamento : departamentoDAO.listarTodos()) {
                listViewDepartamentos.getItems().add(departamento.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void voltarOnAction(ActionEvent event) {
        // Fecha a tela atual
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
