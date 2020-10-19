package dados;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrestadorDeServico extends FuncionarioRegular {

	private Integer horasTrabalhadas;
	
	public PrestadorDeServico(String nome, String cpf, Date dataNascimento, int horasTrabalhadas) {
		super(nome, cpf, dataNascimento);
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public float calculaSalario() {
		return (this.horasTrabalhadas * 2) + super.PISO;
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat mascaraDinheiro = new DecimalFormat("0.00");
		
		return "<tr>"+ 
					"<td>" + "PRESTADOR S." + "</td>" +
					"<td>" + super.getNome() + "</td>" + 
					"<td>" + super.getCpf() + "</td>" +
					"<td>" + mascaraData.format(super.getDataNascimento()) + "</td>" + 
					"<td>" + mascaraDinheiro.format(calculaSalario()) + "</td>" +
					"<td>" + horasTrabalhadas + "</td>" +
					"<td> --- </td>" +
			   "</tr>";
	}

}
