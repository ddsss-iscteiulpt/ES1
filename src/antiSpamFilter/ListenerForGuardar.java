package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


/**
 * 
 * ListenerForGuarda - esta classe � chamada sempre que o utilizador carrega no bot�o guardar para o caso manual
 * o objetivo � atualizar o ficheiro rules com os dados da interface grafica
 *
 */

public class ListenerForGuardar implements ActionListener {


	public ListenerForGuardar() {
	}

	/**
	 * Este metodo � acionado quando o bot�o Guardar � carregado 
	 * Percorre o hash map e para cada peso adiciona a regra no ficheiro rules tal como est� na 
	 * interface gr�fica
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
			JOptionPane.showMessageDialog(GUI.getInstance().getFrame(), "Aten��o primeiro tens de Av. qualidade!!");
		}

	}

}
