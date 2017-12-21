package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import readRules.ReadRules;

/**
 * 
 * ListenerForGuarda - esta classe � chamada sempre que o utilizador carrega no bot�o guardar para o caso manual
 * o objetivo � atualizar o ficheiro rules com os dados da interface grafica
 *
 */

public class ListenerForGuardar implements ActionListener {

	private GUI gui;

	public ListenerForGuardar(GUI gui) {
		this.gui = gui;
	}

	/**
	 * Este metodo � acionado quando o bot�o Guardar � carregado 
	 * Percorre o hash map e para cada peso adiciona a regra no ficheiro rules tal como est� na 
	 * interface gr�fica
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// System.out.println("Estou a carregar no botao!!");
		if (!gui.getFnMan().getText().equals("") && !gui.getFpMan().getText().equals("")) {
			System.out.println("podes guardar valores");

			int contador = 0;
			File rulesFile = gui.getRulesFile();

			try {

				PrintWriter printRules = new PrintWriter(rulesFile);

				for (int i = 0; i < gui.getRf().getRegras().size(); i++) {
					String ola = gui.getRf().getRegras().get(gui.getLista().getElementAt(contador));

					printRules.println(gui.getLista().getElementAt(contador) + "	" + ola);
					contador++;
				}

				JOptionPane.showMessageDialog(gui.getFrame(), "Guardado em : rules.cf");

				printRules.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

		{
			JOptionPane.showMessageDialog(gui.getFrame(), "Aten��o primeiro tens de Av. qualidade!!");
		}

	}

}
