package entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    
    // Atributos específicos da classe Paciente
    private String cpf;
    private Plano plano;

    // Lista para armazenar os pacientes cadastrados (simulando um armazenamento temporário)
    private static List<Paciente> pacientesCadastrados = new ArrayList<>();

    // Construtor da classe Paciente
    public Paciente(String nome, Date dataNascimento, Endereco endereco, String cpf, Plano plano) {
        // Chama o construtor da classe pai (Pessoa) usando a palavra-chave "super"
        super(nome, dataNascimento, endereco);
        // Inicializa os atributos específicos do paciente
        this.cpf = cpf;
        this.plano = plano;
    }

    // Getters e setters para os atributos da classe Paciente

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    // Procedimentos

    // Método para cadastrar um paciente
    public static void cadastrar(Paciente paciente) {
        pacientesCadastrados.add(paciente);
        System.out.println("Paciente cadastrado: " + paciente.getNome());
    }

    // Método para alterar um paciente
    public static void alterar(Paciente paciente) {
        // Verifica se o paciente está na lista antes de tentar alterar
        if (pacientesCadastrados.contains(paciente)) {
            // Lógica para alterar o paciente (por exemplo, atualizar na lista, salvar no banco de dados, etc.)
            System.out.println("Paciente alterado: " + paciente.getNome());
        } else {
            System.out.println("Paciente não encontrado para alteração.");
        }
    }

    // Método para excluir um paciente
    public static void excluir(Paciente paciente) {
        // Verifica se o paciente está na lista antes de tentar excluir
        if (pacientesCadastrados.contains(paciente)) {
            pacientesCadastrados.remove(paciente);
            System.out.println("Paciente excluído: " + paciente.getNome());
        } else {
            System.out.println("Paciente não encontrado para exclusão.");
        }
    }

    // Método para consultar um paciente por CPF
    public static Paciente consultarPorCpf(String cpf) {
        // Lógica para consultar o paciente por CPF (por exemplo, buscar na lista, buscar no banco de dados, etc.)
        for (Paciente paciente : pacientesCadastrados) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("Paciente encontrado por CPF: " + paciente.getNome());
                return paciente;
            } else {
                System.out.println("Paciente não encontrado com o CPF informado " + cpf + ".");
            }
        }
        return null;
    }

    // Método para consultar pacientes por nome e data de nascimento
    public static List<Paciente> consultarPorNomePaciente(String nome, Date dataNascimento) {
        // Lógica para consultar pacientes por nome e data de nascimento (por exemplo, buscar na lista, buscar no banco de dados, etc.)
        List<Paciente> pacientesEncontrados = new ArrayList<>();
        for (Paciente paciente : pacientesCadastrados) {
            if (paciente.getNome().equals(nome) && paciente.getDataNascimento().equals(dataNascimento)) {
                pacientesEncontrados.add(paciente);
            }
        }
		return pacientesEncontrados;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", plano=" + plano + "]";
	}
    
    
}
