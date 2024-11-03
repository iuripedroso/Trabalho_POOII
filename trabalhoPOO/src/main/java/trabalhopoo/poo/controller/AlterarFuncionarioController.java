package trabalhopoo.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import trabalhopoo.poo.dao.DepartamentoDAO;
import trabalhopoo.poo.dao.FuncionarioDAO;
import trabalhopoo.poo.model.Departamento;
import trabalhopoo.poo.model.Funcionario;

import javafx.stage.Stage;
import javafx.scene.Node;

import java.sql.SQLException;
import java.util.List;

public class AlterarFuncionarioController {

    @FXML
    private TextField txtIdFuncionario;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private ComboBox<Departamento> cmbDepartamentos;

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    @FXML
    public void initialize() {
        // Preencher o ComboBox com os departamentos
        try {
            List<Departamento> departamentos = departamentoDAO.listarTodos();
            cmbDepartamentos.getItems().addAll(departamentos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void salvarAlteracoes(ActionEvent event) {
        try {
            int idFuncionario = Integer.parseInt(txtIdFuncionario.getText());
            String nomeFuncionario = txtNomeFuncionario.getText();
            Departamento departamentoSelecionado = cmbDepartamentos.getValue();

            // Buscar o funcionário pelo ID
            Funcionario funcionario = funcionarioDAO.buscarPorID(idFuncionario);

            if (funcionario != null) {
                // Alterar os dados do funcionário
                funcionario.setNome(nomeFuncionario);
                funcionario.setDepartamento(departamentoSelecionado);

                // Atualizar no banco de dados
                funcionarioDAO.altera(funcionario);

                System.out.println("Funcionário atualizado com sucesso.");


                Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stageAtual.close();


            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Funcionário com ID " + idFuncionario + " não encontrado.", ButtonType.OK);
                alert.setTitle("Sucesso");
                alert.setHeaderText(null);
                alert.showAndWait();

                System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
