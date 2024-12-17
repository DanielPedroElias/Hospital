package entidades;

public class Plano {

    // Atributos da classe Plano
    private String nome;
    private double mensalidade;

    // Construtor da classe Plano
    public Plano(String nome, double mensalidade) {
        // Inicializa os atributos da classe com os valores passados como parâmetro
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    // Getters e Setters para os atributos da classe Plano

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

	@Override
	public String toString() {
		return "Plano [nome=" + nome + ", mensalidade=" + mensalidade + "]";
	}


}
