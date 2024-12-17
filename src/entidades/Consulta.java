package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Consulta {

	// Declaração de variáveis de instância
	private int codigo;
	private Paciente paciente;
	private Medico medico;
	private Date data;

	// Construtor da classe
	public Consulta(int codigo, Paciente paciente, Medico medico, Date data) {
		this.codigo = codigo;
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}

	// Métodos de acesso (getters e setters)
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	

	// Procedimentos

	// Método para marcar uma consulta
	public void marcar(Medico medico, Paciente paciente, Date data) {
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		System.out.println("Consulta marcada para o médico " + medico.getNome() + " com o paciente "
				+ paciente.getNome() + " na data " + data.toString());
	}

	

	// Método para cancelar uma consulta
	public void cancelar(Consulta consulta) {
		System.out.println("Consulta cancelada para o médico " + consulta.getMedico().getNome() + " com o paciente "
				+ consulta.getPaciente().getNome() + " na data " + consulta.getData().toString());
		consulta.setMedico(null);
		consulta.setPaciente(null);
		consulta.setData(null);
	}

	// Método estático para pesquisar consultas por paciente
	public static Consulta[] pesquisarPorPaciente(Paciente paciente, Consulta[] consultas) {
		ArrayList<Consulta> consultasDoPaciente = new ArrayList<>();
		for (Consulta consulta : consultas) {
			// Verifica se a consulta não é nula e se o paciente associado não é nulo
			if (consulta != null && consulta.getPaciente() != null && consulta.getPaciente().equals(paciente)) {
				consultasDoPaciente.add(consulta);
			}
		}
		return consultasDoPaciente.toArray(new Consulta[0]);
	}

	@Override
	public String toString() {
		return "Consulta [codigo=" + codigo + ", paciente=" + paciente + ", medico=" + medico + ", data=" + data + "]";
	}
	
	
	
}
