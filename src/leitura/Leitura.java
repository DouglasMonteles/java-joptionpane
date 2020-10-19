package leitura;

import javax.swing.JOptionPane;

public class Leitura {

	// CAIXA DE TEXTO
	public static String lerShowInputDialog(String msg, String label) {
		return JOptionPane.showInputDialog(null, msg, label, JOptionPane.QUESTION_MESSAGE);
	}
	
	// OK OU CANCELAR
	public static int lerOptionDialog(String label, String fieldset) {
		return JOptionPane.showOptionDialog(null, label, fieldset, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);
	}
	
	// SELECIONAR A OPCAO
	public static String lerSelectDialog(String fieldset, String label, String[] opcoes, String header) {
		return String.valueOf(JOptionPane.showInputDialog(null, fieldset, label, JOptionPane.PLAIN_MESSAGE, 
				null ,opcoes, header));
	}
	
}
