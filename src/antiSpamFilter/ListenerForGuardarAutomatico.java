package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ListenerForGuardarAutomatico implements ActionListener {

	private GUI gui;
	
	public ListenerForGuardarAutomatico(GUI gui) {
	
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("Carreguei no botao do automatico");
		
		if(!gui.getFnAuto().getText().equals("") && !gui.getFpAuto().getText().equals("")) {

			System.out.println("podes guardar valores");
			// System.out.println("cucu " + gui.getWeightList().getText().length());

			int contador = 0;
			File rulesFile = gui.getRulesFile();

			try {
				// Scanner rulesScanner = new Scanner(rulesFile);
				PrintWriter printRules = new PrintWriter("pesos.txt");
				// while (rulesScanner.hasNextLine()) {

				// for (Entry<String, String> entry : gui.getRf().getRegras().entrySet()) {

				for (int i = 0; i < gui.getRf().getRegras().size(); i++) {
					String ola = gui.getRf().getRegras().get(gui.getListaAuto().getElementAt(contador));
					System.out.println(contador + " ola: " + ola);

					printRules.println(gui.getListaAuto().getElementAt(contador) + "	" + ola);
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
