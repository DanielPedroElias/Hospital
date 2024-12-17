package Persistencia;

import entidades.Faringoplastia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FaringoplastiaPersistencia {

    // Método para salvar uma faringoplastia no banco de dados
    public static void salvar(Faringoplastia faringoplastia) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir a faringoplastia
            String sql = "INSERT INTO Faringoplastia (procedimento_id) VALUES (?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, faringoplastia.getId());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Faringoplastia cadastrada com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar faringoplastia.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar faringoplastia no banco de dados: " + e.getMessage());
        }
    }
}
