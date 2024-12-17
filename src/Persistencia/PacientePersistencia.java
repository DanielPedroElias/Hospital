package Persistencia;

import entidades.Endereco;
import entidades.Paciente;
import entidades.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientePersistencia {

    // Método para salvar um paciente no banco de dados
    public static void salvar(Paciente paciente) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir o paciente
            String sql = "INSERT INTO Paciente (nome, dataNascimento, endereco_id, cpf, plano_nome) " +
                         "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o paciente
                statement.setString(1, paciente.getNome());
                statement.setDate(2, paciente.getDataNascimento());
                statement.setInt(3, paciente.getEndereco().getId());
                statement.setString(4, paciente.getCpf());
                statement.setString(5, paciente.getPlano().getNome()); // Associando o nome do plano ao paciente

                // Executa a consulta para inserir o paciente
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Paciente cadastrado com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar paciente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar paciente no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar um paciente do banco de dados por CPF
    public static Paciente recuperar(String cpf) {
        Paciente paciente = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um paciente pelo CPF
            String sql = "SELECT * FROM Paciente WHERE cpf = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, cpf);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o paciente
                if (resultSet.next()) {
                    // Recupera os dados do paciente do banco de dados
                    String nome = resultSet.getString("nome");
                    java.sql.Date dataNascimento = resultSet.getDate("dataNascimento");
                    int enderecoId = resultSet.getInt("endereco_id");
                    String planoNome = resultSet.getString("plano_nome");

                    // Recupera o endereço do paciente
                    Endereco endereco = EnderecoPersistencia.recuperar(enderecoId);
                    // Recupera o plano do paciente
                    Plano plano = PlanoPersistencia.recuperar(planoNome);

                    // Cria um novo objeto Paciente com os dados recuperados do banco de dados
                    paciente = new Paciente(nome, dataNascimento, endereco, cpf, plano);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar paciente do banco de dados: " + e.getMessage());
        }
        return paciente;
        
        
    }
    
 // Método para atualizar um paciente no banco de dados
    public static void atualizar(Paciente paciente) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar o paciente
            String sql = "UPDATE Paciente SET nome = ?, dataNascimento = ?, endereco_id = ?, plano_nome = ? " +
                         "WHERE cpf = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o paciente
                statement.setString(1, paciente.getNome());
                statement.setDate(2, paciente.getDataNascimento());
                statement.setInt(3, paciente.getEndereco().getId());
                statement.setString(4, paciente.getPlano().getNome()); // Associando o nome do plano ao paciente
                statement.setString(5, paciente.getCpf());

                // Executa a consulta para atualizar o paciente
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Paciente atualizado com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar paciente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar paciente no banco de dados: " + e.getMessage());
        }
    }

    // Método para excluir um paciente do banco de dados por CPF
    public static void excluir(String cpf) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir o paciente
            String sql = "DELETE FROM Paciente WHERE cpf = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, cpf);

                // Executa a consulta para excluir o paciente
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Paciente excluído com sucesso!");
                } else {
                    System.out.println("Falha ao excluir paciente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir paciente do banco de dados: " + e.getMessage());
        }
    }
}
