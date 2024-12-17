package Persistencia;

import entidades.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecialidadePersistencia {

    // Método para salvar uma especialidade no banco de dados
    public static void salvar(Especialidade especialidade) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se a especialidade já existe no banco de dados
            if (recuperar(especialidade.getNome()) != null) {
                System.out.println("A especialidade já está cadastrada no banco de dados.");
                return;
            }

            // Prepara a consulta SQL para inserir a especialidade
            String sql = "INSERT INTO Especialidade (especialidade) VALUES (?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, especialidade.getNome());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Especialidade cadastrada com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar especialidade.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar especialidade no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar uma especialidade do banco de dados pelo nome
    public static Especialidade recuperar(String nome) {
        Especialidade especialidade = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar uma especialidade pelo nome
            String sql = "SELECT * FROM Especialidade WHERE especialidade = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta
                var resultSet = statement.executeQuery();
                // Verifica se encontrou a especialidade
                if (resultSet.next()) {
                    // Cria um novo objeto Especialidade com os dados recuperados do banco de dados
                    especialidade = new Especialidade(resultSet.getString("especialidade"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar especialidade do banco de dados: " + e.getMessage());
        }
        return especialidade;
    }
    
 // Método para atualizar uma especialidade no banco de dados
    public static void atualizar(String nomeOriginal, Especialidade novaEspecialidade) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se a especialidade existe no banco de dados
            if (recuperar(nomeOriginal) == null) {
                System.out.println("A especialidade não está cadastrada no banco de dados para atualização.");
                return;
            }

            // Prepara a consulta SQL para atualizar a especialidade
            String sql = "UPDATE Especialidade SET especialidade = ? WHERE especialidade = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a atualização
                statement.setString(1, novaEspecialidade.getNome());
                statement.setString(2, nomeOriginal); // Usamos o nome original para identificar a especialidade

                // Executa a consulta para atualizar a especialidade
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Especialidade atualizada com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar especialidade.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar especialidade no banco de dados: " + e.getMessage());
        }
    }


    // Método para excluir uma especialidade do banco de dados
    public static void excluir(Especialidade especialidade) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Verifica se a especialidade existe no banco de dados
            if (recuperar(especialidade.getNome()) == null) {
                System.out.println("A especialidade não está cadastrada no banco de dados para exclusão.");
                return;
            }

            // Prepara a consulta SQL para excluir a especialidade
            String sql = "DELETE FROM Especialidade WHERE especialidade = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta para a exclusão
                statement.setString(1, especialidade.getNome());

                // Executa a consulta para excluir a especialidade
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Especialidade excluída com sucesso!");
                } else {
                    System.out.println("Falha ao excluir especialidade.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir especialidade do banco de dados: " + e.getMessage());
        }
    }

}
