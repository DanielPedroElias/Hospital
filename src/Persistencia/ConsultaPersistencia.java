package Persistencia;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaPersistencia {

    // Método para salvar uma consulta no banco de dados
    public static void salvar(Consulta consulta) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir a consulta
            String sql = "INSERT INTO Consulta (paciente_cpf, medico_nome, data) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a consulta
                statement.setString(1, consulta.getPaciente().getCpf());
                statement.setString(2, consulta.getMedico().getNome());
                statement.setDate(3, consulta.getData());

                // Executa a consulta para inserir a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Consulta marcada com sucesso!");
                } else {
                    System.out.println("Falha ao marcar consulta.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar consulta no banco de dados: " + e.getMessage());
        }
    }

    // Método para cancelar uma consulta
    public static void cancelar(Consulta consulta) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir a consulta
            String sql = "DELETE FROM Consulta WHERE paciente_cpf = ? AND medico_nome = ? AND data = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para cancelar a consulta
                statement.setString(1, consulta.getPaciente().getCpf());
                statement.setString(2, consulta.getMedico().getNome());
                statement.setDate(3, consulta.getData());

                // Executa a consulta para cancelar a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Consulta cancelada com sucesso!");
                } else {
                    System.out.println("Falha ao cancelar consulta.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cancelar consulta no banco de dados: " + e.getMessage());
        }
    }

    // Método para recuperar consultas por paciente
    public static List<Consulta> recuperarPorPaciente(Paciente paciente) {
        List<Consulta> consultasDoPaciente = new ArrayList<>();
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar consultas por paciente
            String sql = "SELECT * FROM Consulta WHERE paciente_cpf = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, paciente.getCpf());

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Itera sobre os resultados e cria objetos Consulta
                while (resultSet.next()) {
                    // Recupera os dados da consulta do resultado
                    int codigo = resultSet.getInt("codigo");
                    Date data = resultSet.getDate("data");
                    // Recupera o nome do médico associado à consulta
                    String nomeMedico = resultSet.getString("medico_nome");
                    // Recupera o médico usando o método adequado da classe MedicoPersistencia
                    Medico medico = MedicoPersistencia.recuperarPorNome(nomeMedico);
                    // Cria um novo objeto Consulta
                    Consulta consulta = new Consulta(codigo, paciente, medico, data);
                    // Adiciona a consulta à lista de consultas do paciente
                    consultasDoPaciente.add(consulta);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar consultas do paciente do banco de dados: " + e.getMessage());
        }
        return consultasDoPaciente;
    }
    
 // Método para atualizar uma consulta no banco de dados
    public static void atualizar(Consulta consulta) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar a consulta
            String sql = "UPDATE Consulta SET medico_nome = ?, data = ? WHERE paciente_cpf = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para a atualização
                statement.setString(1, consulta.getMedico().getNome());
                statement.setDate(2, consulta.getData());
                statement.setString(3, consulta.getPaciente().getCpf());

                // Executa a consulta para atualizar a consulta
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Consulta atualizada com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar consulta.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar consulta no banco de dados: " + e.getMessage());
        }
    }


}
