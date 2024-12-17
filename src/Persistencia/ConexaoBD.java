package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "d4nny";
    private static final String SENHA = "senhafoda";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Carrega o driver do MySQL (necessário apenas em versões antigas do JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public static void main(String[] args) {
        conectar();
    }
}
