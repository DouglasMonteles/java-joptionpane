package validacao;

import java.util.Calendar;
import java.util.Date;

import dados.EquipesDaEmpresa;
import dados.FuncionarioRegular;
import dados.GerenteDeEquipe;
import dados.PrestadorDeServico;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	
	public static String validaNome() {
		String nome = Leitura.lerShowInputDialog("Informe o nome completo:", "Cadastro do nome");
		
		if (nome == null || nome.isEmpty() || !nome.contains(" ")) {
			Visao.msgWarningDialog("O nome nao pode ficar em branco ou ser incompleto! Tente novamente.", "Aviso");
			return validaNome();
		}
		
		return nome;
	}
	
	public static String validaCpf(EquipesDaEmpresa equipes) {
		String cpf = Leitura.lerShowInputDialog("Informe o CPF:", "Cadastro de CPF");
		
		if (cpf == null || cpf.isEmpty() || !isCpfNumero(cpf) || cpf.length() != 11 || cpf.contains(".")) {
			Visao.msgWarningDialog("O cpf precisa conter 11 [ONZE] numeros! Tente novamente.", "Aviso");
			return validaCpf(equipes);
		}
		
		if (isCpfRepetido(equipes, cpf)) {
			Visao.msgErrorDialog("Esse CPF ja esta cadastrado! Tente outro.", "Erro");
			return validaCpf(equipes);
		}
		
		return cpf;
	}
	
	private static boolean isCpfRepetido(EquipesDaEmpresa equipes, String cpf) {
		for (FuncionarioRegular f : equipes.getFuncionarios()) {
			if (f.getCpf().equals(cpf))
				return true;
		}
		
		for (PrestadorDeServico p : equipes.getPrestadoresDeServicos()) {
			if (p.getCpf().equals(cpf))
				return true;
		}
		
		for (GerenteDeEquipe g : equipes.getGerentes()) {
			if (g.getCpf().equals(cpf))
				return true;
		}
		return false;
	}

	public static boolean isCpfNumero(String cpf) {
		short contaNumeroCpf = 0;
		for (char str : cpf.toCharArray()) {
			if (Character.isDigit(str)) {
				contaNumeroCpf++;
			} 
		}
		return (contaNumeroCpf != 11) ? false : true;
	}
	
	public static Date validaDataNascimento() {
		int[] data = new int[3];
		Calendar calendar = Calendar.getInstance();
		Date dataCompleta;
		
		try {
			do {
				data[0] = Integer.parseInt(Leitura.lerShowInputDialog("Informe o dia:", "Data de Nascimento"));
				
				if (data[0] <= 0 || data[0] > 31)
					Visao.msgWarningDialog("O dia deve estar no intervalo de 1 a 31. Tente novamente.", "Aviso");
			} while (data[0] <= 0 || data[0] > 31);
			
			do {
				data[1] = Integer.parseInt(Leitura.lerShowInputDialog("Informe o mês:", "Data de Nascimento"));
				
				if (data[1] <= 0 || data[1] > 12)
					Visao.msgWarningDialog("O mes deve estar no intervalo de 1 a 12. Tente novamente.", "Aviso");
			} while (data[1] <= 0 || data[1] > 12);
			
			do {
				data[2] = Integer.parseInt(Leitura.lerShowInputDialog("Informe o ano:", "Data de nascimento"));
				
				if (data[2] < 1900)
					Visao.msgWarningDialog("O ano nao pode ser menor que 1900. Tente novamente.", "Aviso");
			} while (data[2] < 1900);
		
		} catch (NumberFormatException e) {
			Visao.msgErrorDialog("Entrada invalida! Tente novamente.", "Erro");
			return validaDataNascimento();
		}
		
		calendar.set(data[2], (data[1] - 1), data[0]); // Ano, Mes, Dia
		dataCompleta = calendar.getTime();
		
		return dataCompleta;
	}
	
	public static int validaHorasTrabalhadas() {
		int horas;
		try {
			horas = Integer.parseInt(Leitura.lerShowInputDialog("Informe as horas trabalhadas:", "Horas Trabalhadas"));
		} catch (NumberFormatException e) {
			Visao.msgErrorDialog("Entrada invalida. Tente novamente.", "Erro");
			return validaHorasTrabalhadas();
		}
		
		if (horas <= 0) {
			Visao.msgWarningDialog("As horas de trabalho nao pode ser menor ou igual a ZERO. Tente novamente.", "Aviso");
			return validaHorasTrabalhadas();
		}
		
		return horas;
	}

	public static int validaQtdProjetos() {
		int qtd;
		
		try {
			qtd = Integer.parseInt(Leitura.lerShowInputDialog("Informe a quatidade de projetos:", "Qtd. Projetos"));
		} catch (NumberFormatException e) {
			Visao.msgErrorDialog("Entrada invalida! Tente novamente.", "Erro");
			return validaQtdProjetos();
		}
		
		if (qtd < 0) {
			Visao.msgWarningDialog("A quantidade nao pode ser menor que ZERO. Tente novamente.", "Aviso");
			return validaQtdProjetos();
		}
		
		return qtd;
	}

	public static boolean validaContinua() {
		int resp = Leitura.lerOptionDialog("Deseja continuar?", "Pergunta");
		
		if (resp == -1) {
			Visao.msgWarningDialog("A seleção é obrigatória", "Aviso");
			return validaContinua();
		}
		
		return (resp == 0) ? true : false;
	}

	public static int validaOpcao() {
		String opc;
		String[] select = {"Cadastrar Funcionario Regular", "Prestador de Servicos", "Gerente de Equipe"};
		
		try {
			opc = Leitura.lerSelectDialog("Selecione uma opção", "Seleção de colaborador", select, "Cadastro");
		} catch (NullPointerException e) {
			Visao.msgErrorDialog("Selecione uma das opções", "Erro");
			return validaOpcao();
		}
	
		return (getPosicaoSelect(select, opc) == 0) ? validaOpcao() : getPosicaoSelect(select, opc);
	}

	public static int validaMenu() {
		String opc;
		
		String[] select = {"Total de funcionarios cadastrados em cada uma das três categorias", 
				"Total salarial a ser pago para cada categoria", "Encerrar o programa"};
		
		try {
			opc = Leitura.lerSelectDialog("O que você deseja exibir?", "Opções disponíveis", select, "Opções");
		} catch (NullPointerException e) {
			Visao.msgErrorDialog("Selecione uma das opções", "Erro");
			return validaMenu();
		}
		
		return (getPosicaoSelect(select, opc) == 0) ? validaMenu() : getPosicaoSelect(select, opc);
	}
	
	private static int getPosicaoSelect(String[] select, String opc) {
		for (int i = 0; i < select.length; i++) {
			if (opc.equals(select[i])) {
				return (i+1);
			}
		}
		
		Visao.msgWarningDialog("A seleção é obrigatória.", "Aviso");
		return 0;
	}
	
}
