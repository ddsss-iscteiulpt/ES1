package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerForGuardarAutomatico implements ActionListener {

	private GUI gui;
	
	public ListenerForGuardarAutomatico(GUI gui) {
	
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Carreguei no botao do automatico");
		
		if(!gui.getFnAuto().getText().equals("") && !gui.getFpAuto().getText().equals("")) {
			System.out.println("podes guardar valores");
			gui.getWeightList().getText();
			
			
			
		}else {
			//System.out.println("Atenção primeiro tens de Av. qualidade!! ");
			JOptionPane.showMessageDialog(gui.getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
