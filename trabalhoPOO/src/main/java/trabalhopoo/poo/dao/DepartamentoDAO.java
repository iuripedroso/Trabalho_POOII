package trabalhopoo.poo.dao;

import trabalhopoo.poo.model.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements IDepartamento, IConst {

    public List<Departamento> listarTodos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM Departamento"; // Declaração da variável 'sql'

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setDepartamentoID(rs.getInt("id"));
                departamento.setNome(rs.getString("nome"));
                departamentos.add(departamento);
            }
        }

        return departamentos;
    }

    public void inserir(Departamento departamento) throws SQLException {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, departamento.getNome());
            pstmt.executeUpdate();
        }
    }

    public Departamento buscarPorID(int id) throws SQLException {
        String sql = "SELECT * FROM departamento WHERE departamento_id = ?";
        Departamento departamento = null;

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                departamento = new Departamento(
                        rs.getInt("departamento_id"),
                        rs.getString("nome")
                );
            }
        }
        return departamento;
    }
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM departamento WHERE id = ?";

        try (Connection conexao = Conexao.getConexao(stringDeConexao, usuario, senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }


    public void salvar(Departamento departamento) throws SQLException {
        String sql;

        // Se o ID for 0 ou negativo, consideramos que é um novo departamento (inserir).
        // Caso contrário, atualizamos o departamento existente.
        if (departamento.getDepartamentoID() <= 0) {
            sql = "INSERT INTO departamentos (nome) VALUES (?)";
        } else {
            sql = "UPDATE departamentos SET nome = ? WHERE id = ?";
        }

        Connection conexao = Conexao.getConexao(stringDeConexao, usuario, senha);
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, departamento.getNome());

            if (departamento.getDepartamentoID() > 0) {
                stmt.setInt(2, departamento.getDepartamentoID());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao salvar o departamento: " + e.getMessage());
        }
    }

}
