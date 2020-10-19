package saida;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import dados.EquipesDaEmpresa;
import dados.FuncionarioRegular;
import dados.GerenteDeEquipe;
import dados.PrestadorDeServico;

public class Visao {

	public static void msgConsole(String msg) {
		System.out.println(msg);
	}

	public static void msgErro(String msg) {
		System.err.print(msg);
	}

	public static void limpaConsole(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
	
	public static void exibeDados(EquipesDaEmpresa equipes) {
		StringBuilder tableHTML = new StringBuilder();
		
		tableHTML.append("<html>"
							+ "<table border='1'>"
								+ "<tr>"
									+ "<th>Categoria</th>"
									+ "<th>Nome Completo</th>"
									+ "<th>CPF</th>"
									+ "<th>Data de Nascimento</th>"
									+ "<th>Salário</th>"
									+ "<th>Horas Trabalhadas</th>"
									+ "<th>Quantidade de Projetos</th>"
								+ "</tr>");
		
		if (equipes.getFuncionarios() != null && !equipes.getFuncionarios().isEmpty())
			for (FuncionarioRegular funcionario : equipes.getFuncionarios()) {
				tableHTML.append(funcionario.toString());
			}

		if (equipes.getPrestadoresDeServicos() != null && !equipes.getPrestadoresDeServicos().isEmpty())
			for (PrestadorDeServico prestador : equipes.getPrestadoresDeServicos()) {
				tableHTML.append(prestador.toString());
			}
		
		if (equipes.getGerentes() != null && !equipes.getGerentes().isEmpty())
			for (GerenteDeEquipe gerente : equipes.getGerentes()) {
				tableHTML.append(gerente.toString());
			}
		tableHTML.append("<tr>"
							+ "<td>Total:</td>"
							+ "<td>" + equipes.getTotalColaboradores() + "</td>"
						+ "</tr>");
		
		tableHTML.append("</table>"
				+ "</html>");
		
		JOptionPane.showMessageDialog(null, tableHTML, "Colaboradores Cadastrados", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void exibeTotalSalarial(EquipesDaEmpresa equipes) {
		StringBuilder tableHTML = new StringBuilder();
		DecimalFormat mascara = new DecimalFormat("0.00");
		
		tableHTML.append("<html>"
							+ "<table border='1'>"
				
								+ "<tr>"
									+ "<th>Categorias</th>"
									+ "<th>Salário Total (A ser pago)</th>"
								+ "</tr>"
									
								+ "<tr>"
									+ "<td>Funcionários</td>"
									+ "<td>" + mascara.format(equipes.totalSalarialFuncionarios()) + "</td>"
								+ "</tr>"
									
								+ "<tr>"
									+ "<td>Prestador de Serviços</td>"
									+ "<td>" + mascara.format(equipes.totalSalarialPrestadoresServicos()) + "</td>"
								+ "</tr>"
									
								+ "<tr>"
									+ "<td>Gerente</td>"
									+ "<td>" + mascara.format(equipes.totalSalarialGerentes()) + "</td>"
								+ "</tr>"
									
								+ "<tr>"
									+ "<td>Soma total</td>"
									+ "<td>" + mascara.format(equipes.getSomaSalarialTotal()) + "</td>"
								+ "</tr>"
									
							+ "</table>"
						+ "</html>");
		
		JOptionPane.showMessageDialog(null, tableHTML, "Total salarial a ser pago", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void msgWarningDialog(String label, String fieldset) {
		JOptionPane.showMessageDialog(null, label, fieldset, JOptionPane.WARNING_MESSAGE);
	}
	
	public static void msgErrorDialog(String label, String fieldset) {
		JOptionPane.showMessageDialog(null, label, fieldset, JOptionPane.ERROR_MESSAGE);
	}

}
