package trabalhopoo.poo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class                                                                                                                                                                                                                                                TesteConexao {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    IConst.stringDeConexao,
                    IConst.usuario,
                    IConst.senha
            );
            if (connection != null) {
                System.out.println("conexão bem sucedida!");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }
}

