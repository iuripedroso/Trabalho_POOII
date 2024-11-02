package trabalhopoo.poo.dao;

import trabalhopoo.poo.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface IFuncionario {
    void inserir(Funcionario funcionario) throws SQLException;
    void altera(Funcionario funcionario) throws SQLException;
    void excluir(int id) throws SQLException; // Para excluir um funcionário
    Funcionario buscarPorID(int id) throws SQLException; // Para buscar um funcionário pelo ID
    List<Funcionario> listarTodos() throws SQLException; // Para listar todos os funcionários
}
