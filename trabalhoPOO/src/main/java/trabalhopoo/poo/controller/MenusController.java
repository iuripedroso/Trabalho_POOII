package trabalhopoo.poo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenusController {

    @FXML
    private MenuItem menuEstudanteInclui;

    @FXML
    private MenuItem menuEstudanteAltera;

    @FXML
    private MenuItem menuFuncionarioInclui;  // Menu para incluir funcionário

    @FXML
    private MenuItem menuFuncionarioAltera;  // Menu para alterar funcionário

    @FXML
    private MenuItem menuFuncionarioListar;  // Menu para listar funcionários

    @FXML
    private MenuItem menuDepartamentoInclui;  // Menu para incluir departamento

    @FXML
    private MenuItem menuDepartamentoAltera;  // Menu para alterar departamento

    @FXML
    private MenuItem menuDepartamentoListar;  // Menu para listar departamentos




    @FXML
    void incluiFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/IncluiFuncionario.fxml", "Incluir Funcionário");
    }

    @FXML
    void alteraFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/AlterarFuncionario.fxml", "Alterar Funcionário");
    }

    @FXML
    void listaFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ListarFuncionarios.fxml", "Listar Funcionários");
    }

    @FXML
    void incluiDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/IncluiDepartamento.fxml", "Incluir Departamento");
    }

    @FXML
    void alteraDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/AlterarDepartamento.fxml", "Alterar Departamento");
    }

    @FXML
    void listaDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ListarDepartamentos.fxml", "Listar Departamentos");
    }

    @FXML
    public void excluirFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ExcluirFuncionario.fxml", "Excluir Funcionario");
    }

    public void excluirDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ExcluirDepartamento.fxml", "Excluir Departamento");
    }

    private void abrirTela(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage newStage = new Stage();
            Scene newScene = new Scene(root);
            newStage.setTitle(titulo);
            newStage.setScene(newScene);
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
