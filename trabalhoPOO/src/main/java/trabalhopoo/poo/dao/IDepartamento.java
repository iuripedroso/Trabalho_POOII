package trabalhopoo.poo.dao;

import trabalhopoo.poo.model.Departamento;
import java.sql.SQLException;
import java.util.List;

public interface IDepartamento {
    void inserir(Departamento departamento) throws SQLException;
    void excluir(int id) throws SQLException; // Para excluir um departamento
    Departamento buscarPorID(int id) throws SQLException; // Para buscar um departamento pelo ID
    List<Departamento> listarTodos() throws SQLException; // Para listar todos os departamentos
}
