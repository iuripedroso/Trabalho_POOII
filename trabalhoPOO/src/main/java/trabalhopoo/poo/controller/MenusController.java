package trabalhopoo.poo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private MenuItem menuRelatorio; // Adicionado para o relatório



    @FXML
    public void relatorioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/Relatorio.fxml", "Relatório de Departamentos e Funcionários");
    }

    @FXML
    public void incluiFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/IncluiFuncionario.fxml", "Incluir Funcionário");
        mostrarNotificacao("Incluir Funcionário", "Tela de inclusão de funcionário aberta.");
    }

    @FXML
    public void alteraFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/AlterarFuncionario.fxml", "Alterar Funcionário");
        mostrarNotificacao("Alterar Funcionário", "Tela de alteração de funcionário aberta.");
    }

    @FXML
    public void listaFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ListarFuncionarios.fxml", "Listar Funcionários");
        mostrarNotificacao("Listar Funcionários", "Tela de listagem de funcionários aberta.");
    }

    @FXML
    public void incluiDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/IncluiDepartamento.fxml", "Incluir Departamento");
        mostrarNotificacao("Incluir Departamento", "Tela de inclusão de departamento aberta.");
    }

    @FXML
    public void alteraDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/AlterarDepartamento.fxml", "Alterar Departamento");
        mostrarNotificacao("Alterar Departamento", "Tela de alteração de departamento aberta.");
    }

    @FXML
    public void listaDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ListarDepartamentos.fxml", "Listar Departamentos");
        mostrarNotificacao("Listar Departamentos", "Tela de listagem de departamentos aberta.");
    }

    @FXML
    public void excluirFuncionarioOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ExcluirFuncionario.fxml", "Excluir Funcionário");
        mostrarNotificacao("Excluir Funcionário", "Tela de exclusão de funcionário aberta.");
    }

    @FXML
    public void excluirDepartamentoOnAction(ActionEvent event) {
        abrirTela("/trabalhopoo/poo/view/ExcluirDepartamento.fxml", "Excluir Departamento");
        mostrarNotificacao("Excluir Departamento", "Tela de exclusão de departamento aberta.");
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
            mostrarNotificacao("Erro", "Não foi possível abrir a tela: " + e.getMessage());
        }
    }

    private void mostrarNotificacao(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
