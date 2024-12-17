package entidades;

public class Endereco {

	// Declaração de variáveis
	private int id;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cep;

	// Construtor da classe
	public Endereco(int id, String logradouro, int numero, String bairro, String cep) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}

    public Endereco(String endereco) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	// Métodos de acesso (getters e setters) para as variáveis de instância
	public int getId() {
		return id;
	}

        public void setId(int id) {
            this.id = id;
        }

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
        return String.format("ID: %d, %s, %d, %s, %s", id, logradouro, numero, bairro, cep);
	}

}
