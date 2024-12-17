package Principal;

import Persistencia.ConsultaPersistencia;
import Persistencia.EnderecoPersistencia;
import Persistencia.EspecialidadePersistencia;
import Persistencia.MedicoPersistencia;
import Persistencia.PacientePersistencia;
import Persistencia.PessoaPersistencia;
import Persistencia.PlanoPersistencia;
import Persistencia.ProcedimentoPersistencia;
import Persistencia.SalaPersistencia;
import entidades.Consulta;
import entidades.Endereco;
import entidades.Especialidade;
import entidades.Medico;
import entidades.Paciente;
import entidades.Pessoa;
import entidades.Plano;
import entidades.Procedimento;
import entidades.Sala;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando um endereço
        Endereco endereco1 = new Endereco(1, "Rua ABC", 123, "Centro", "12345-678");
        // Salvando o endereço no banco de dados
        EnderecoPersistencia.salvar(endereco1);

        // Criando uma pessoa
        Date dataNascimento1 = Date.valueOf("1990-01-01");
        Pessoa pessoa1 = new Pessoa("Fulano", dataNascimento1, endereco1);
        // Salvando a pessoa no banco de dados
        PessoaPersistencia.salvar(pessoa1);

        // Criando especialidades
        Especialidade cardiologia = new Especialidade("Cardiologia");
        Especialidade dermatologia = new Especialidade("Dermatologia");
        Especialidade pediatria = new Especialidade("Pediatria");
        // Salvando as especialidades no banco de dados
        EspecialidadePersistencia.salvar(cardiologia);
        EspecialidadePersistencia.salvar(dermatologia);
        EspecialidadePersistencia.salvar(pediatria);
        
        Especialidade pediatria1 = new Especialidade("Pediatria1");
        EspecialidadePersistencia.salvar(pediatria1);



        // Criando uma lista de especialidades para o médico
        List<Especialidade> especialidadesMedico = new ArrayList<>();
        especialidadesMedico.add(cardiologia);
        especialidadesMedico.add(dermatologia);

        // Criando um médico
        Medico medico = new Medico("Fulano", dataNascimento1, endereco1, 12345, especialidadesMedico, 100.0);
        // Salvando o médico no banco de dados
        MedicoPersistencia.salvar(medico);

        // Recuperando o médico pelo CRM
        Medico medicoRecuperado = MedicoPersistencia.recuperarPorCRM(12345);
        if (medicoRecuperado != null) {
            System.out.println("Médico recuperado: " + medicoRecuperado);
        } else {
            System.out.println("Médico não encontrado.");
        }

        
        // Criando um endereço
        Endereco endereco2 = new Endereco(2, "Rua 123", 123, "Centro", "12645-678");
        // Salvando o endereço no banco de dados
        EnderecoPersistencia.salvar(endereco1);

        // Criando uma pessoa
        Date dataNascimento2 = Date.valueOf("1990-01-01");
        Pessoa pessoa2 = new Pessoa("Ciclano", dataNascimento2, endereco2);
        // Salvando a pessoa no banco de dados
        PessoaPersistencia.salvar(pessoa2);
        
        // Testando a classe Paciente
        // Criando um plano
        Plano plano = new Plano("Plano de Saúde A", 200.0);
        // Salvando o plano no banco de dados
        PlanoPersistencia.salvar(plano);
          
        // Criando um paciente
        Paciente paciente = new Paciente("Ciclano", dataNascimento2, endereco2, "12345678901", plano);
        // Salvando o paciente no banco de dados
        PacientePersistencia.salvar(paciente);

        // Recuperando o paciente por CPF
        Paciente pacienteRecuperado = PacientePersistencia.recuperar("12345678901");
        if (pacienteRecuperado != null) {
            System.out.println("Paciente recuperado: " + pacienteRecuperado);
        } else {
            System.out.println("Paciente não encontrado.");
        }
                
        
     // Testando a atualização de um endereço
        
     // Criando um endereço
        Endereco endereco3 = new Endereco(3, "Rua fds", 123, "Centro", "54321-678");
        // Salvando o endereço no banco de dados
        EnderecoPersistencia.salvar(endereco3);
     // Recuperando um endereço do banco de dados pelo ID
     Endereco enderecoParaAtualizar = EnderecoPersistencia.recuperar(3);
     if (enderecoParaAtualizar != null) {
         // Modificando os dados do endereço
         enderecoParaAtualizar.setLogradouro("Nova Rua");
         enderecoParaAtualizar.setNumero(456);
         enderecoParaAtualizar.setBairro("Novo Bairro");
         enderecoParaAtualizar.setCep("54321-987");

         // Atualizando o endereço no banco de dados
         EnderecoPersistencia.atualizar(enderecoParaAtualizar);
     } else {
         System.out.println("Endereço não encontrado para atualização.");
     }

     // Testando a exclusão de um endereço
     // Recuperando um endereço do banco de dados pelo ID
     Endereco enderecoParaExcluir = EnderecoPersistencia.recuperar(3);
     if (enderecoParaExcluir != null) {
         // Excluindo o endereço do banco de dados
         EnderecoPersistencia.excluir(enderecoParaExcluir);
     } else {
         System.out.println("Endereço não encontrado para exclusão.");
     }
          
     // Testando a classe Consulta
     
     // Marcar uma consulta
     Consulta consulta1 = new Consulta(1, pacienteRecuperado, medicoRecuperado, Date.valueOf("2024-04-15"));
     ConsultaPersistencia.salvar(consulta1);

     // Recuperando consultas por paciente
     List<Consulta> consultasDoPaciente = ConsultaPersistencia.recuperarPorPaciente(pacienteRecuperado);
     System.out.println("Consultas do paciente " + pacienteRecuperado.getNome() + ":");
     for (Consulta consulta : consultasDoPaciente) {
         System.out.println(consulta);
     }
     
  // Modificar a data da consulta para um dia depois
     consulta1.setData(Date.valueOf("2024-04-17"));
     ConsultaPersistencia.atualizar(consulta1);
     
  // Recuperando consultas por paciente
     List<Consulta> consultasDoPacienteatt = ConsultaPersistencia.recuperarPorPaciente(pacienteRecuperado);
     System.out.println("Consultas do paciente " + pacienteRecuperado.getNome() + ":");
     for (Consulta consulta : consultasDoPacienteatt) {
         System.out.println(consulta);
     }
     
     // Cancelar uma consulta
     ConsultaPersistencia.cancelar(consulta1);

     
     // Testando a atualização de uma especialidade
     Especialidade especialidadeParaAtualizar = EspecialidadePersistencia.recuperar("Pediatria");
     if (especialidadeParaAtualizar != null) {
         // Modificando o nome da especialidade
         especialidadeParaAtualizar.setNome("Cardiologia Clínica");

         // Atualizando a especialidade no banco de dados
         EspecialidadePersistencia.atualizar("Pediatria", especialidadeParaAtualizar);
     } else {
         System.out.println("Especialidade não encontrada para atualização.");
     }


     // Testando a exclusão de uma especialidade
     Especialidade especialidadeParaExcluir = EspecialidadePersistencia.recuperar("Cardiologia Clínica");
     if (especialidadeParaExcluir != null) {
         // Excluindo a especialidade do banco de dados
         EspecialidadePersistencia.excluir(especialidadeParaExcluir);
     } else {
         System.out.println("Especialidade não encontrada para exclusão.");
     }
     
     // Testando Plano
    
     // Salvando um plano no banco de dados
     Plano plano1 = new Plano("Plano B", 150.0);
     PlanoPersistencia.salvar(plano1);

     // Testando a atualização de um plano
     Plano planoParaAtualizar = PlanoPersistencia.recuperar("Plano B");
     if (planoParaAtualizar != null) {
         System.out.println("Plano recuperado: " + planoParaAtualizar);

         // Atualizando o plano com um novo nome e nova mensalidade
         Plano novoPlano = new Plano("Plano Bc", 200.0);
         PlanoPersistencia.atualizar(planoParaAtualizar, novoPlano.getNome(), novoPlano.getMensalidade());

         // Recuperando o plano atualizado pelo novo nome
         Plano planoAtualizado = PlanoPersistencia.recuperar(novoPlano.getNome());
         if (planoAtualizado != null) {
             System.out.println("Plano atualizado: " + planoAtualizado);
         } else {
             System.out.println("Plano não encontrado após atualização.");
         }
     } else {
         System.out.println("Plano não encontrado para atualização.");
     }

     // Testando a exclusão de um plano
     PlanoPersistencia.excluir("Plano AAA");
    
     // testando sala
     
     // Criando uma sala
     Sala sala = new Sala("Sala A");
     Sala sala1 = new Sala("Sala C");
     
     // Salvando a sala no banco de dados
     SalaPersistencia.salvar(sala);
     SalaPersistencia.salvar(sala1);
     
        
     // Testando a atualização de uma especialidade
     Sala salaParaAtualizar = SalaPersistencia.recuperar("Sala A");
     if (salaParaAtualizar != null) {
         // Modificando o nome da especialidade
    	 salaParaAtualizar.setNome("Sala B");

         // Atualizando a especialidade no banco de dados
    	 SalaPersistencia.atualizar("Sala A", salaParaAtualizar);
     } else {
         System.out.println("Sala não encontrada para atualização.");
     }
     // Excluindo a sala
     SalaPersistencia.excluir("Sala A");
    
     
     
     // Testando Procedimento

     // Criando uma lista de médicos para o procedimento
     List<Medico> medicosProcedimento = new ArrayList<>();
     medicosProcedimento.add(medicoRecuperado);

     // Criando um procedimento
     Procedimento procedimento = new Procedimento(1, pacienteRecuperado.getCpf(), medicoRecuperado.getNome(),
             Date.valueOf("2024-04-16"), sala1.getNome(), 150.0, 60);
     // Salvando o procedimento no banco de dados
     ProcedimentoPersistencia.salvar(procedimento);

     // Recuperando o procedimento pelo ID
     Procedimento procedimentoRecuperado = ProcedimentoPersistencia.recuperar(1);
     if (procedimentoRecuperado != null) {
         System.out.println("Procedimento recuperado: " + procedimentoRecuperado);
     } else {
         System.out.println("Procedimento não encontrado.");
     }

     // Testando a atualização de um procedimento
     if (procedimentoRecuperado != null) {
         // Modificando a data do procedimento
         procedimentoRecuperado.setData(Date.valueOf("2024-04-18"));

         // Atualizando o procedimento no banco de dados
         ProcedimentoPersistencia.atualizar(procedimentoRecuperado);
     } else {
         System.out.println("Procedimento não encontrado para atualização.");
     }

     // Testando a exclusão de um procedimento
     ProcedimentoPersistencia.excluir(1);

  // Criando um endereço
     Endereco endereco4 = new Endereco(4, "AVenida fds", 987, "Centro", "12345-678");
     // Salvando o endereço no banco de dados
     EnderecoPersistencia.salvar(endereco4);
     
  // Criando uma pessoa
     Date dataNascimento3 = Date.valueOf("1990-01-01");
     Pessoa pessoa3 = new Pessoa("beto", dataNascimento3, endereco4);
     // Salvando a pessoa no banco de dados
     PessoaPersistencia.salvar(pessoa3);
     
  // Testando a classe Paciente
     // Criando um plano
     Plano plano4 = new Plano("Plano de Saúde A", 200.0);
     // Salvando o plano no banco de dados
     PlanoPersistencia.salvar(plano4);
       
     // Criando um paciente
     Paciente paciente2 = new Paciente("beto", dataNascimento3, endereco4, "98765432109", plano4);
     // Salvando o paciente no banco de dados
     PacientePersistencia.salvar(paciente2);
     
     // Testando atualização de paciente
     paciente.setNome("beto");
     paciente.setDataNascimento(Date.valueOf("1980-01-01"));
     paciente.setCpf("98765432109");
     PacientePersistencia.atualizar(paciente2);
     
     // Testando exclusão de paciente
     PacientePersistencia.excluir("98765432109");

     // Recuperando paciente após exclusão (deve retornar null)
     Paciente pacienteRecuperado2 = PacientePersistencia.recuperar("98765432109");
     if (pacienteRecuperado != null) {
         System.out.println("Paciente recuperado após exclusão: " + pacienteRecuperado2);
     } else {
         System.out.println("Paciente não encontrado após exclusão.");
     }

    }
}
