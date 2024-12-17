package entidades;

public class Especialidade {
    
    // Declaração da variável de instância privada
    private String nome;

    // Construtor da classe
    public Especialidade(String nome) {
        // Inicializa a variável de instância "nome" com o valor passado como parâmetro
        this.nome = nome;
    }

    // Método getter para obter o nome da especialidade
    public String getNome() {
        // Retorna o valor da variável de instância "nome"
        return nome;
    }

    // Método setter para definir o nome da especialidade
    public void setNome(String nome) {
        // Define o valor da variável de instância "nome" com o valor passado como parâmetro
        this.nome = nome;
    }

	@Override
	public String toString() {
		return "[" + nome + "]";
	}
    
    
}
