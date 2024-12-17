package Persistencia;

import entidades.Procedimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedimentoPersistencia {

    // Método para salvar um procedimento no banco de dados
    public static void salvar(Procedimento procedimento) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir o procedimento
            String sql = "INSERT INTO Procedimento (id, paciente_cpf, medico_nome, data, sala, valor, tempoDuracao) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o procedimento
                statement.setInt(1, procedimento.getId());
                statement.setString(2, procedimento.getPacienteCPF());
                statement.setString(3, procedimento.getMedicoNome());
                statement.setDate(4, procedimento.getData());
                statement.setString(5, procedimento.getSalaNome());
                statement.setDouble(6, procedimento.getValor());
                statement.setInt(7, procedimento.getTempoDuracao());

                // Executa a consulta para inserir o procedimento
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Procedimento cadastrado com sucesso!");
                } else {
                    System.out.println("Falha ao cadastrar procedimento.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar procedimento no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar um procedimento do banco de dados pelo ID
    public static Procedimento recuperar(int id) {
        Procedimento procedimento = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um procedimento pelo ID
            String sql = "SELECT * FROM Procedimento WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, id);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o procedimento
                if (resultSet.next()) {
                    // Cria um novo objeto Procedimento com os dados recuperados do banco de dados
                    procedimento = new Procedimento(
                            resultSet.getInt("id"),
                            resultSet.getString("paciente_cpf"),
                            resultSet.getString("medico_nome"),
                            resultSet.getDate("data"),
                            resultSet.getString("sala"),
                            resultSet.getDouble("valor"),
                            resultSet.getInt("tempoDuracao")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar procedimento do banco de dados: " + e.getMessage());
        }
        return procedimento;
    }

    // Método para atualizar um procedimento no banco de dados
    public static void atualizar(Procedimento procedimento) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar o procedimento
            String sql = "UPDATE Procedimento SET paciente_cpf = ?, medico_nome = ?, data = ?, sala = ?, valor = ?, tempoDuracao = ? WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a atualização
                statement.setString(1, procedimento.getPacienteCPF());
                statement.setString(2, procedimento.getMedicoNome());
                statement.setDate(3, procedimento.getData());
                statement.setString(4, procedimento.getSalaNome());
                statement.setDouble(5, procedimento.getValor());
                statement.setInt(6, procedimento.getTempoDuracao());
                statement.setInt(7, procedimento.getId());

                // Executa a consulta para atualizar o procedimento
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Procedimento atualizado com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar procedimento.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar procedimento no banco de dados: " + e.getMessage());
        }
    }

    // Método para excluir um procedimento do banco de dados pelo ID
    public static void excluir(int id) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir o procedimento
            String sql = "DELETE FROM Procedimento WHERE id = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, id);

                // Executa a consulta para excluir o procedimento
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Procedimento excluído com sucesso!");
                } else {
                    System.out.println("Nenhum procedimento encontrado para exclusão.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir procedimento do banco de dados: " + e.getMessage());
        }
    }
}
