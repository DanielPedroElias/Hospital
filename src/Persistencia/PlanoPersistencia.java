package Persistencia;

import entidades.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanoPersistencia {

    // Método para salvar um plano no banco de dados
    public static void salvar(Plano plano) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se o plano já existe no banco de dados
            if (recuperar(plano.getNome()) != null) {
                System.out.println("O plano já está cadastrado no banco de dados.");
                return;
            }

            // Prepara a consulta SQL para inserir o plano
            String sql = "INSERT INTO Plano (nome, mensalidade) VALUES (?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o plano
                statement.setString(1, plano.getNome());
                statement.setDouble(2, plano.getMensalidade());

                // Executa a consulta para inserir o plano
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Plano cadastrado com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar plano.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar plano no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar um plano do banco de dados pelo nome
    public static Plano recuperar(String nome) {
        Plano plano = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um plano pelo nome
            String sql = "SELECT * FROM Plano WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o plano
                if (resultSet.next()) {
                    // Cria um novo objeto Plano com os dados recuperados do banco de dados
                    plano = new Plano(
                            resultSet.getString("nome"),
                            resultSet.getDouble("mensalidade")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar plano do banco de dados: " + e.getMessage());
        }
        return plano;
    }
    
    // Método para excluir um plano do banco de dados pelo nome
    public static void excluir(String nome) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir o plano pelo nome
            String sql = "DELETE FROM Plano WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Plano excluído com sucesso!");
                } else {
                    System.out.println("Nenhum plano encontrado para exclusão.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir plano do banco de dados: " + e.getMessage());
        }
    }
    

// Método para atualizar um plano no banco de dados
public static void atualizar(Plano plano, String novoNome, double novaMensalidade) {
    try (Connection conexao = ConexaoBD.conectar()) {
        // Prepara a consulta SQL para atualizar o plano
        String sql = "UPDATE Plano SET nome = ?, mensalidade = ? WHERE nome = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            // Define os valores dos parâmetros da consulta para a atualização
            statement.setString(1, novoNome);
            statement.setDouble(2, novaMensalidade);
            statement.setString(3, plano.getNome());

            // Executa a consulta para atualizar o plano
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Plano atualizado com sucesso!");
            } else {
                System.out.println("Nenhum plano encontrado para atualização.");
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar plano do banco de dados: " + e.getMessage());
    }
}





}
