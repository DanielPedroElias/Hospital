package entidades;

public class Sala {

    // Atributo da classe Sala
    private String nome;

    // Construtor da classe Sala
    public Sala(String nome) {
        // Inicializa o atributo da classe com o valor passado como parâmetro
        this.nome = nome;
    }

    // Getters e Setters para o atributo da classe Sala

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + '}';
    }
}
