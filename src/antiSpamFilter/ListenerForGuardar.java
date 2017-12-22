package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


/**
 * 
 * ListenerForGuarda - esta classe é chamada sempre que o utilizador carrega no botão guardar para o caso manual
 * o objetivo é atualizar o ficheiro rules com os dados da interface grafica
 *
 */

public class ListenerForGuardar implements ActionListener {


	public ListenerForGuardar() {
	}

	/**
	 * Este metodo é acionado quando o botão Guardar é carregado 
	 * Percorre o hash map e para cada peso adiciona a regra no ficheiro rules tal como está na 
	 * interface gráfica
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// System.out.println("Estou a carregar no botao!!");
		if (!GUI.getInstance().getFnMan().getText().equals("") && !GUI.getInstance().getFpMan().getText().equals("")) {
			System.out.println("podes guardar valores");

			int contador = 0;
			File rulesFile = GUI.getInstance().getRulesFile();

			try {

				PrintWriter printRules = new PrintWriter(rulesFile);

				for (int i = 0; i < GUI.getInstance().getRf().getRegras().size(); i++) {
					String ola = GUI.getInstance().getRf().getRegras().get(GUI.getInstance().getLista().getElementAt(contador));

					printRules.println(GUI.getInstance().getLista().getElementAt(contador) + "	" + ola);
					contador++;
				}

				JOptionPane.showMessageDialog(GUI.getInstance().getFrame(), "Guardado em : rules.cf");

				printRules.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

		{
			JOptionPane.showMessageDialog(GUI.getInstance().getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
