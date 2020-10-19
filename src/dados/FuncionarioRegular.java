package dados;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionarioRegular extends Pessoa {

	public FuncionarioRegular(String nome, String cpf, Date dataNascimento) {
		super(nome, cpf, dataNascimento);
	}

	@Override
	public float calculaSalario() {
		return super.PISO + (super.PISO * (10 / 100));
	}
	
	public String toString() {
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat mascaraDinheiro = new DecimalFormat("0.00");
		
		return "<tr>"+ 
					"<td>" + "FUNCIONARIO" + "</td>" +
					"<td>" + super.getNome() + "</td>" + 
					"<td>" + super.getCpf() + "</td>" +  
					"<td>" + mascaraData.format(super.getDataNascimento()) + "</td>" +
					"<td>" + mascaraDinheiro.format(calculaSalario()) + "</td>" +
					"<td> --- </td>" +
					"<td> --- </td>"
			 + "</tr>";
	}
	
}
