package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import readRules.ReadRules;

/**
 * 
 * ListenerForGuardaAutomatico - esta classe � chamada sempre que o utilizador carrega no bot�o 
 * guardar para o caso automatico
 * o objetivo � atualizar o ficheiro rules com os dados da interface grafica
 *
 */
public class ListenerForGuardarAutomatico implements ActionListener {

	private GUI gui;
	
	public ListenerForGuardarAutomatico(GUI gui) {
	
		this.gui = gui;
	}

	/**
	 * Este metodo � acionado quando o bot�o Guardar � carregado 
	 * Percorre o hash map e para cada peso adiciona a regra no ficheiro rules tal como est� na 
	 * interface gr�fica
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("Carreguei no botao do automatico");
		
		if(!gui.getFnAuto().getText().equals("") && !gui.getFpAuto().getText().equals("")) {

			System.out.println("podes guardar valores");
			

			int contador = 0;
			File rulesFile = gui.getRulesFile();

			
			try {
				
				PrintWriter printRules = new PrintWriter(rulesFile);
			

				for (int i = 0; i < gui.getRf_automatico().getRegras().size(); i++) {
					String ola = gui.getRf_automatico().getRegras().get(gui.getListaAuto().getElementAt(contador));
					System.out.println(contador + " ola: " + ola);

					printRules.println(gui.getListaAuto().getElementAt(contador) + "	" + ola);
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
