package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class ListenerForGuardar implements ActionListener {

	private GUI gui;
	
	public ListenerForGuardar(GUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("Estou a carregar no botao!!");
		if(!gui.getFn().getText().equals("") && !gui.getFp().getText().equals("")) {
			System.out.println("podes guardar valores");
			
			
			
		}else {
			//System.out.println("Atenção primeiro tens de Av. qualidade!! ");
			JOptionPane.showMessageDialog(gui.getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
