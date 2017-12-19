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

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

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
			System.out.println("cucu " + gui.getWeightList().getText().length());
			
			File filePesos = new File("pesos.txt");
			

			PrintWriter printPesos;
			try {
				printPesos = new PrintWriter("pesos.txt");
				printPesos.println(gui.getWeightList().getText());
				printPesos.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Scanner rulesCopia;
			Scanner rulesPesos;
			try {

				
				File fileRulesCopia = new File("rulesCopia.cf");
				PrintWriter print3 = new PrintWriter("rules.cf");

				rulesCopia = new Scanner(fileRulesCopia);
				rulesPesos = new Scanner(filePesos);

				while (rulesCopia.hasNextLine()) {

					print3.println(rulesCopia.nextLine() + "	" + rulesPesos.nextLine());

				}
				JOptionPane.showMessageDialog(gui.getFrame(), "Guardado em : rules.cf");
				// System.out.println("line: " + line);
				rulesCopia.close();
				rulesPesos.close();
				print3.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			// System.out.println("Atenção primeiro tens de Av. qualidade!! ");
			JOptionPane.showMessageDialog(gui.getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
