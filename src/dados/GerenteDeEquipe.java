package dados;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenteDeEquipe extends FuncionarioRegular {
	
	private Integer quatidadeProjetos;

	public GerenteDeEquipe(String nome, String cpf, Date dataNascimento, int quatidadeProjetos) {
		super(nome, cpf, dataNascimento);
		this.quatidadeProjetos = quatidadeProjetos;
	}
	
	@Override
	public float calculaSalario() {
		return quatidadeProjetos * (super.PISO * (50 / 100) + super.PISO);
	}
	
	public Integer getQuatidadeProjetos() {
		return quatidadeProjetos;
	}

	public void setQuatidadeProjetos(Integer quatidadeProjetos) {
		this.quatidadeProjetos = quatidadeProjetos;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat mascaraDinheiro = new DecimalFormat("0.00");
		
		return "<tr>"+ 
					"<td>" + "GERENTE" + "</td>" + 
					"<td>" + super.getNome() + "</td>" + 
					"<td>" + super.getCpf() + "</td>" + 
					"<td>" + mascaraData.format(super.getDataNascimento()) + "</td>" + 
					"<td>" + mascaraDinheiro.format(calculaSalario()) + "</td>" +
					"<td> --- </td>" +
					"<td>" + quatidadeProjetos + "</td>" +
			   "</tr>";
	}

}
