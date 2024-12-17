package entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Procedimento {
    
    // Atributos da classe Procedimento
    private int id;
    private String pacienteCPF; // Alteração: mudança para String para corresponder ao CPF no MySQL
    private String medicoNome; // Alteração: mudança para String para corresponder ao nome do médico no MySQL
    private Date data;
    private String salaNome; // Alteração: mudança para String para corresponder ao nome da sala no MySQL
    private double valor;
    private int tempoDuracao;

    // Construtor da classe Procedimento
    public Procedimento(int id, String pacienteCPF, String medicoNome, Date data, String salaNome, double valor,
            int tempoDuracao) {
        // Inicializa os atributos da classe com os valores passados como parâmetro
        this.id = id;
        this.pacienteCPF = pacienteCPF;
        this.medicoNome = medicoNome;
        this.data = data;
        this.salaNome = salaNome;
        this.valor = valor;
        this.tempoDuracao = tempoDuracao;
    }

    // Getters e Setters para os atributos da classe Procedimento

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacienteCPF() {
        return pacienteCPF;
    }

    public void setPacienteCPF(String pacienteCPF) {
        this.pacienteCPF = pacienteCPF;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSalaNome() {
        return salaNome;
    }

    public void setSalaNome(String salaNome) {
        this.salaNome = salaNome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    // Métodos adicionais conforme necessário
 // Método para marcar um procedimento
    public void marcar(Medico medico, Paciente paciente, Date data, Sala sala) {
        // Lógica para marcar o procedimento (por exemplo, adicionar à lista, salvar no banco de dados, etc.)
        System.out.println("Procedimento marcado para o médico " + medico.getNome() +
                " com o paciente " + paciente.getNome() + " na data " + data.toString() +
                " na sala " + sala.getNome());
    }

    // Método para cancelar um procedimento
    public void cancelar() {
        // Lógica para cancelar o procedimento (por exemplo, remover da lista, excluir do banco de dados, etc.)
        System.out.println("Procedimento cancelado para o médico " +
                this.getMedicoNome() +
                " com o paciente " + this.getPacienteCPF() +
                " na data " + this.getData().toString());
        this.setMedicoNome(null);
        this.setPacienteCPF(null);
        this.setData(null);
        this.setSalaNome(null);
    }

    // Método para pesquisar procedimentos por médico
    public static List<Procedimento> pesquisarPorMedico(Medico medico, List<Procedimento> procedimentos) {
        List<Procedimento> procedimentosDoMedico = new ArrayList<>();

        for (Procedimento procedimento : procedimentos) {
            // Verifica se o nome do médico corresponde
            if (procedimento.getMedicoNome() != null && procedimento.getMedicoNome().equals(medico.getNome())) {
                procedimentosDoMedico.add(procedimento);
            }
        }

        return procedimentosDoMedico;
    }

    // Método para calcular o valor total dos procedimentos
    public static double calcularTotal(List<Procedimento> procedimentos) {
        double total = 0;
        for (Procedimento procedimento : procedimentos) {
            total += procedimento.getValor();
        }
        return total;
    }


}
