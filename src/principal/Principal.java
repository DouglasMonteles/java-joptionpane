package principal;

import dados.EquipesDaEmpresa;
import dados.FuncionarioRegular;
import dados.GerenteDeEquipe;
import dados.PrestadorDeServico;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		
		boolean aux = true;
		EquipesDaEmpresa equipes = new EquipesDaEmpresa();
		
		do {
			switch(Validacao.validaOpcao()) {
			case 1:
				FuncionarioRegular funcionarioRegular = new FuncionarioRegular(Validacao.validaNome(), 
						Validacao.validaCpf(equipes), Validacao.validaDataNascimento());
				equipes.setFuncionarios(funcionarioRegular);
				break;
				
			case 2:
				PrestadorDeServico prestadorDeServico = new PrestadorDeServico(Validacao.validaNome(), 
						Validacao.validaCpf(equipes), Validacao.validaDataNascimento(), Validacao.validaHorasTrabalhadas());
				equipes.setPrestadoresDeServicos(prestadorDeServico);
				break;
				
			case 3:
				GerenteDeEquipe gerenteDeEquipe = new GerenteDeEquipe(Validacao.validaNome(), 
						Validacao.validaCpf(equipes), Validacao.validaDataNascimento(), Validacao.validaQtdProjetos());
				equipes.setGerentes(gerenteDeEquipe);
				break;
			}
		} while (Validacao.validaContinua());
		
		do {
			switch (Validacao.validaMenu()) {
			case 1:
				Visao.exibeDados(equipes);				
				break;

			case 2:
				Visao.exibeTotalSalarial(equipes);
				break;
				
			case 3:
				aux = false;
				break;
			}
		} while (aux);
	}

}
