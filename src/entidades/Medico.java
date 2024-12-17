package entidades;

import java.sql.Date;
import java.util.List;

public class Medico extends Pessoa {

    // Variável de instância para CRM (cada médico tem seu CRM)
    private int crm;

    // Lista de especialidades do médico
    private List<Especialidade> especialidades;

    // Valor da hora de trabalho do médico
    private double valorHora;

    // Construtor da classe Medico
    public Medico(String nome, Date dataNascimento, Endereco endereco, int crm, List<Especialidade> especialidades,
                  double valorHora) {
        // Chama o construtor da classe pai (Pessoa) usando a palavra-chave "super"
        super(nome, dataNascimento, endereco);
        // Inicializa os atributos específicos do médico
        this.crm = crm;
        this.especialidades = especialidades;
        this.valorHora = valorHora;
    }

    // Getters e setters para os atributos da classe

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }	
    
    @Override
    public String toString() {
        return "Medico: " +
                "nome='" + getNome() + '\'' +
                ", crm=" + crm +
                ", especialidades=" + especialidades +
                ", valorHora=" + valorHora;
    }


}
