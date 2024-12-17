package Persistencia;

import entidades.Pessoa;
import entidades.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class PessoaPersistencia {

    // Método para salvar uma pessoa no banco de dados
    public static void salvar(Pessoa pessoa) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir uma pessoa
            String sql = "INSERT INTO Pessoa (nome, dataNascimento, endereco_id) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a pessoa
                statement.setString(1, pessoa.getNome());
                statement.setDate(2, pessoa.getDataNascimento());
                statement.setInt(3, pessoa.getEndereco().getId());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Pessoa cadastrada com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar pessoa.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pessoa no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar uma pessoa do banco de dados com base no nome
    public static Pessoa recuperar(String nome) {
    Pessoa pessoa = null;
    try (Connection conexao = ConexaoBD.conectar()) {
        // Prepara a consulta SQL para recuperar uma pessoa pelo nome
        String sql = "SELECT nome, dataNascimento, endereco_id FROM Pessoa WHERE nome = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            // Define o valor do parâmetro da consulta
            statement.setString(1, nome);

            // Executa a consulta
            ResultSet resultSet = statement.executeQuery();
            // Verifica se encontrou a pessoa
            if (resultSet.next()) {
                // Recupera os dados da pessoa do resultado da consulta
                String nomePessoa = resultSet.getString("nome");
                Date dataNascimento = resultSet.getDate("dataNascimento");
                int idEndereco = resultSet.getInt("endereco_id");

                // Recupera o endereço usando o ID recuperado
                Endereco endereco = EnderecoPersistencia.recuperar(idEndereco);

                // Cria um novo objeto Pessoa com os dados recuperados do banco de dados
                pessoa = new Pessoa(nomePessoa, dataNascimento, endereco);
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao recuperar pessoa do banco de dados: " + e.getMessage());
    }
    return pessoa;
}

    
 // Método para atualizar uma pessoa no banco de dados
    public static void atualizar(Pessoa pessoa) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar uma pessoa
            String sql = "UPDATE Pessoa SET dataNascimento = ?, endereco_id = ? WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a atualização
                statement.setDate(1, pessoa.getDataNascimento());
                statement.setInt(2, pessoa.getEndereco().getId());
                statement.setString(3, pessoa.getNome());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Pessoa atualizada com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar pessoa.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa no banco de dados: " + e.getMessage());
        }
    }

    // Método para excluir uma pessoa do banco de dados
    public static void excluir(String nome) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir uma pessoa
            String sql = "DELETE FROM Pessoa WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta para a exclusão
                statement.setString(1, nome);

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Pessoa excluída com sucesso!");
                } else {
                    System.out.println("Falha ao excluir pessoa.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pessoa do banco de dados: " + e.getMessage());
        }
    }

}
