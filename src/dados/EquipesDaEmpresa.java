package dados;

import java.util.ArrayList;

public class EquipesDaEmpresa {

	private ArrayList<FuncionarioRegular> funcionarios;
	private ArrayList<PrestadorDeServico> prestadoresDeServicos;
	private ArrayList<GerenteDeEquipe> gerentes;
	
	public EquipesDaEmpresa() {
		super();
		this.funcionarios = new ArrayList<FuncionarioRegular>();
		this.prestadoresDeServicos = new ArrayList<PrestadorDeServico>();
		this.gerentes = new ArrayList<GerenteDeEquipe>();
	}
	
	public float totalSalarialFuncionarios() {
		float soma = 0;
		for (FuncionarioRegular funcionario : this.funcionarios) {
			soma += funcionario.calculaSalario();
		}
		return soma;
	}
	
	public float totalSalarialPrestadoresServicos() {
		float soma = 0;
		for (PrestadorDeServico prestador : this.prestadoresDeServicos) {
			soma += prestador.calculaSalario();
		}
		return soma;
	}
	
	public float totalSalarialGerentes() {
		float soma = 0;
		for (GerenteDeEquipe gerente : this.gerentes) {
			soma += gerente.calculaSalario();
		}
		return soma;
	}

	public int getTotalColaboradores() {
		return this.funcionarios.size() + this.gerentes.size() + this.prestadoresDeServicos.size();
	}
	
	public ArrayList<FuncionarioRegular> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(FuncionarioRegular funcionario) {
		this.funcionarios.add(funcionario);
	}

	public ArrayList<PrestadorDeServico> getPrestadoresDeServicos() {
		return prestadoresDeServicos;
	}

	public void setPrestadoresDeServicos(PrestadorDeServico prestadorDeServico) {
		this.prestadoresDeServicos.add(prestadorDeServico);
	}

	public ArrayList<GerenteDeEquipe> getGerentes() {
		return gerentes;
	}

	public void setGerentes(GerenteDeEquipe gerente) {
		this.gerentes.add(gerente);
	}

	public float getSomaSalarialTotal() {
		return this.totalSalarialFuncionarios() + this.totalSalarialPrestadoresServicos() + this.totalSalarialGerentes();
	}
	
}
