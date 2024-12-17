package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Sala;

public class SalaPersistencia {

    // Método para salvar uma sala no banco de dados
    public static void salvar(Sala sala) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir a sala
            String sql = "INSERT INTO Sala (nome) VALUES (?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, sala.getNome());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Sala cadastrada com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar sala.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar sala no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar uma sala do banco de dados pelo nome
    public static Sala recuperar(String nome) {
        Sala sala = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar uma sala pelo nome
            String sql = "SELECT * FROM Sala WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou a sala
                if (resultSet.next()) {
                    // Cria um novo objeto Sala com os dados recuperados do banco de dados
                    sala = new Sala(resultSet.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar sala do banco de dados: " + e.getMessage());
        }
        return sala;
    }

 // Método para atualizar uma sala no banco de dados
    public static void atualizar(String nomeOriginal, Sala novaSala) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se a sala existe no banco de dados
            if (recuperar(nomeOriginal) == null) {
                System.out.println("A sala não está cadastrada no banco de dados para atualização.");
                return;
            }

            // Prepara a consulta SQL para atualizar a sala
            String sql = "UPDATE Sala SET nome = ? WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a atualização
                statement.setString(1, novaSala.getNome());
                statement.setString(2, nomeOriginal); // Usamos o nome original para identificar a sala

                // Executa a consulta para atualizar a sala
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Sala atualizada com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar sala.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar sala no banco de dados: " + e.getMessage());
        }
    }

    // Método para excluir uma sala do banco de dados pelo nome
    public static void excluir(String nome) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se a sala existe no banco de dados
            if (recuperar(nome) == null) {
                System.out.println("A sala não está cadastrada no banco de dados para exclusão.");
                return;
            }

            // Prepara a consulta SQL para excluir a sala
            String sql = "DELETE FROM Sala WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta para excluir a sala
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Sala excluída com sucesso!");
                } else {
                    System.out.println("Falha ao excluir sala.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir sala no banco de dados: " + e.getMessage());
        }
    }
}
