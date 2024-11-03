package trabalhopoo.poo.dao;

import trabalhopoo.poo.model.Funcionario;
import trabalhopoo.poo.model.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements IFuncionario, IConst {

    public void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, departamento_id) VALUES (?, ?)";

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setInt(2, funcionario.getDepartamento().getDepartamentoID());
            pstmt.executeUpdate();
        }
    }
    public List<Funcionario> listarTodos() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT f.id, f.nome, d.id AS dep_id, d.nome AS dep_nome FROM funcionario f " +
                "JOIN departamento d ON f.departamento_id = d.id";

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int funcionarioId = rs.getInt("id");
                String funcionarioNome = rs.getString("nome");
                int departamentoId = rs.getInt("dep_id");
                String departamentoNome = rs.getString("dep_nome");

                Departamento departamento = new Departamento(departamentoId, departamentoNome);
                Funcionario funcionario = new Funcionario(funcionarioId, funcionarioNome, departamento);
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    public Funcionario buscarPorID(int id) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setFuncionarioID(rs.getInt("id"));
                    funcionario.setNome(rs.getString("nome"));
                    // Adicionar mais campos, se houver
                    return funcionario;
                }
            }
        }
        return null;
    }

    public void altera(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, departamento_id = ? WHERE id = ?";

        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setInt(2, funcionario.getDepartamento().getDepartamentoID());
            pstmt.setInt(3, funcionario.getFuncionarioID());
            pstmt.executeUpdate();
        }
    }
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";

        try (Connection conexao = Conexao.getConexao(stringDeConexao, usuario, senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void salvar(Funcionario funcionario) throws SQLException {
        String sql;

        // Se o ID for 0 ou negativo, consideramos que é um novo funcionário (inserir).
        // Caso contrário, atualizamos o funcionário existente.
        if (funcionario.getFuncionarioID() <= 0) {
            sql = "INSERT INTO funcionarios (nome) VALUES (?)";
        } else {
            sql = "UPDATE funcionarios SET nome = ? WHERE id = ?";
        }
        Connection conexao = Conexao.getConexao(stringDeConexao, usuario, senha);
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());

            if (funcionario.getFuncionarioID() > 0) {
                stmt.setInt(2, funcionario.getFuncionarioID());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao salvar o funcionário: " + e.getMessage());
        }
    }
}
