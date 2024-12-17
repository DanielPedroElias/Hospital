package Persistencia;

import entidades.Neurocirurgia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NeurocirurgiaPersistencia {

    // Método para salvar uma neurocirurgia no banco de dados
    public static void salvar(Neurocirurgia neurocirurgia) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir a neurocirurgia
            String sql = "INSERT INTO Neurocirurgia (procedimento_id) VALUES (?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, neurocirurgia.getId());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Neurocirurgia cadastrada com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar neurocirurgia.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar neurocirurgia no banco de dados: " + e.getMessage());
        }
    }
}
