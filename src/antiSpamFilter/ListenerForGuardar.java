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

public class ListenerForGuardar implements ActionListener {

	private GUI gui;

	public ListenerForGuardar(GUI gui) {
		this.gui = gui;
	}

	/**
	 * Este metodo é acionado quando o botão Guardar é carregado Primeiro é criado
	 * um ficheiro rules2 com os pesos associados a cada regrass
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// System.out.println("Estou a carregar no botao!!");
		if (!gui.getFnMan().getText().equals("") && !gui.getFpMan().getText().equals("")) {
			System.out.println("podes guardar valores");
			// System.out.println("cucu " + gui.getWeightList().getText().length());

			int contador = 0;
			File rulesFile = gui.getRulesFile();

			try {
				// Scanner rulesScanner = new Scanner(rulesFile);
				PrintWriter printRules = new PrintWriter(rulesFile);
				// while (rulesScanner.hasNextLine()) {

				// for (Entry<String, String> entry : gui.getRf().getRegras().entrySet()) {

				for (int i = 0; i < gui.getRf().getRegras().size(); i++) {
					String ola = gui.getRf().getRegras().get(gui.getLista().getElementAt(contador));

					printRules.println(gui.getLista().getElementAt(contador) + "	" + ola);
					contador++;
				}

				// }
				JOptionPane.showMessageDialog(gui.getFrame(), "Guardado em : rules.cf");
				// rulesScanner.close();
				printRules.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

		{
			JOptionPane.showMessageDialog(gui.getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
