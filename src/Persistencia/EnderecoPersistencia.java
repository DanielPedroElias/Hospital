package Persistencia;

import entidades.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoPersistencia {

    // Método para salvar um endereço no banco de dados
    public static void salvar(Endereco endereco) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir um endereço
            String sql = "INSERT INTO Endereco (id, logradouro, numero, bairro, cep) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o endereço
                statement.setInt(1, endereco.getId());
                statement.setString(2, endereco.getLogradouro());
                statement.setInt(3, endereco.getNumero());
                statement.setString(4, endereco.getBairro());
                statement.setString(5, endereco.getCep());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Endereço cadastrado com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar endereço.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereço no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar um endereço do banco de dados com base no ID
    public static Endereco recuperar(int id) {
        Endereco endereco = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um endereço pelo ID
            String sql = "SELECT * FROM Endereco WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, id);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o endereço
                if (resultSet.next()) {
                    // Cria um novo objeto Endereco com os dados recuperados do banco de dados
                    endereco = new Endereco(
                            resultSet.getInt("id"),
                            resultSet.getString("logradouro"),
                            resultSet.getInt("numero"),
                            resultSet.getString("bairro"),
                            resultSet.getString("cep")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar endereço do banco de dados: " + e.getMessage());
        }
        return endereco;
    }
    
    
 // Método para atualizar um endereço no banco de dados
    public static void atualizar(Endereco endereco) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar um endereço
            String sql = "UPDATE Endereco SET logradouro = ?, numero = ?, bairro = ?, cep = ? WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o endereço
                statement.setString(1, endereco.getLogradouro());
                statement.setInt(2, endereco.getNumero());
                statement.setString(3, endereco.getBairro());
                statement.setString(4, endereco.getCep());
                statement.setInt(5, endereco.getId());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Endereço atualizado com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar endereço.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar endereço no banco de dados: " + e.getMessage());
        }
    }

    // Método para excluir um endereço do banco de dados
    public static void excluir(Endereco endereco) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir um endereço
            String sql = "DELETE FROM Endereco WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta para o ID do endereço
                statement.setInt(1, endereco.getId());

                // Executa a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Endereço excluído com sucesso!");
                } else {
                    System.out.println("Falha ao excluir endereço.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir endereço do banco de dados: " + e.getMessage());
        }
    }

}
