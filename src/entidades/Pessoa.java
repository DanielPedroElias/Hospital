package entidades;

import java.sql.Date;

public class Pessoa {
    
    // Atributos da classe Pessoa
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    // Construtor da classe Pessoa
    public Pessoa(String nome, Date dataNascimento, Endereco endereco) {
        // Inicializa os atributos da classe com os valores passados como parâmetro
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Getters e setters para os atributos da classe Pessoa

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
