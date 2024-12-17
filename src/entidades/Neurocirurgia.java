package entidades;

import java.sql.Date;

public class Neurocirurgia extends Procedimento {
	
    // Construtor da classe Neurocirurgia, que chama o construtor da classe pai (Procedimento)
	public Neurocirurgia(int id, String pacienteCPF, String medicoNome, Date data, String salaNome, double valor,
			int tempoDuracao) {
		super(id, pacienteCPF, medicoNome, data, salaNome, valor, tempoDuracao);
		// TODO Auto-generated constructor stub
	}

   
}
