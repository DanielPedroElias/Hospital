package Persistencia;

import entidades.Endereco;
import entidades.Especialidade;
import entidades.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoPersistencia {

    // Método para salvar um médico no banco de dados
	public static void salvar(Medico medico) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para inserir um médico
            String sql = "INSERT INTO Medico (nome, CRM, valorHora, dataNascimento, endereco_id) " +
                         "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o médico
                statement.setString(1, medico.getNome());
                statement.setInt(2, medico.getCrm());
                statement.setDouble(3, medico.getValorHora());
                statement.setDate(4, new java.sql.Date(medico.getDataNascimento().getTime()));
                statement.setInt(5, medico.getEndereco().getId());

                // Executa a consulta para inserir o médico
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Médico cadastrado com sucesso!");
                    // Associar as especialidades existentes ao médico
                    salvarEspecialidades(medico, conexao);
                } else {
                    System.out.println("Falha ao cadastrar médico.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar médico no banco de dados: " + e.getMessage());
        }
    }

	// Método para salvar as especialidades de um médico no banco de dados
    private static void salvarEspecialidades(Medico medico, Connection conexao) throws SQLException {
        // Prepara a consulta SQL para inserir as especialidades do médico
        String sql = "INSERT INTO Medico_Especialidade (medico_crm, especialidade) VALUES (?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            for (Especialidade especialidade : medico.getEspecialidades()) {
                statement.setInt(1, medico.getCrm());
                statement.setString(2, especialidade.getNome());
                statement.addBatch(); // Adiciona a consulta ao batch para execução em lote
            }

            // Executa o batch de consultas para inserir as especialidades
            int[] linhasAfetadas = statement.executeBatch();
            if (linhasAfetadas.length > 0) {
                System.out.println("Especialidades cadastradas com sucesso!");
            } else {
                System.out.println("Falha ao cadastrar especialidades.");
            }
        }
    }

 // Método para recuperar um médico do banco de dados com base no CRM
    public static Medico recuperarPorCRM(int crm) {
        Medico medico = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um médico pelo CRM
            String sql = "SELECT * FROM Medico WHERE CRM = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setInt(1, crm);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o médico
                if (resultSet.next()) {
                    // Recuperando o endereço do médico
                    Endereco endereco = EnderecoPersistencia.recuperar(resultSet.getInt("endereco_id"));
                    
                    // Recuperando as especialidades do médico
                    List<Especialidade> especialidades = new ArrayList<>();
                    String sqlEspecialidades = "SELECT especialidade FROM Medico_Especialidade WHERE medico_crm = ?";
                    try (PreparedStatement statementEspecialidades = conexao.prepareStatement(sqlEspecialidades)) {
                        statementEspecialidades.setInt(1, crm);
                        ResultSet resultSetEspecialidades = statementEspecialidades.executeQuery();
                        while (resultSetEspecialidades.next()) {
                            String nomeEspecialidade = resultSetEspecialidades.getString("especialidade");
                            Especialidade especialidade = EspecialidadePersistencia.recuperar(nomeEspecialidade);
                            if (especialidade != null) {
                                especialidades.add(especialidade);
                            }
                        }
                    }
                    
                    // Cria um novo objeto Medico com os dados recuperados do banco de dados
                    medico = new Medico(
                            resultSet.getString("nome"),
                            resultSet.getDate("dataNascimento"),
                            endereco,
                            resultSet.getInt("CRM"),
                            especialidades,
                            resultSet.getDouble("valorHora")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar médico do banco de dados: " + e.getMessage());
        }
        return medico;
    }
    
 // Método para recuperar um médico pelo nome
    public static Medico recuperarPorNome(String nome) {
        Medico medico = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para recuperar um médico pelo nome
            String sql = "SELECT * FROM Medico WHERE nome = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta
                statement.setString(1, nome);

                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                // Verifica se encontrou o médico
                if (resultSet.next()) {
                    // Recupera o CRM do médico
                    int crm = resultSet.getInt("CRM");
                    // Recupera outras informações do médico
                    // (endereço, especialidades, etc.) como no método recuperarPorCRM
                    // Aqui você pode chamar o método recuperarPorCRM se a lógica for a mesma
                    medico = recuperarPorCRM(crm);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar médico do banco de dados: " + e.getMessage());
        }
        return medico;
    }
    
 // Método para atualizar um médico no banco de dados
    public static void atualizar(Medico medicoAtualizado) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para atualizar um médico
            String sql = "UPDATE Medico SET nome = ?, valorHora = ?, dataNascimento = ?, endereco_id = ? WHERE CRM = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define os valores dos parâmetros da consulta para o médico
                statement.setString(1, medicoAtualizado.getNome());
                statement.setDouble(2, medicoAtualizado.getValorHora());
                statement.setDate(3, new java.sql.Date(medicoAtualizado.getDataNascimento().getTime()));
                statement.setInt(4, medicoAtualizado.getEndereco().getId());
                statement.setInt(5, medicoAtualizado.getCrm());

                // Executa a consulta para atualizar o médico
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Médico atualizado com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar médico.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar médico no banco de dados: " + e.getMessage());
        }
    }
 // Método para excluir um médico do banco de dados
    public static void excluir(int crm) {
        try (Connection conexao = ConexaoBD.conectar()) {
            // Prepara a consulta SQL para excluir um médico
            String sql = "DELETE FROM Medico WHERE CRM = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                // Define o valor do parâmetro da consulta para o CRM do médico
                statement.setInt(1, crm);

                // Executa a consulta para excluir o médico
                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Médico excluído com sucesso!");
                } else {
                    System.out.println("Falha ao excluir médico.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir médico do banco de dados: " + e.getMessage());
        }
    }
    
}
