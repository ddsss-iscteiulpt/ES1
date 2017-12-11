package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map.Entry;

import readFile.Leitura;
import readRules.ReadRules;

public class AntiSpamFilterManualConfiguration {

	private ReadRules rf;

	public void init() {

		GUI.getInstance().getOk().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					rf = new ReadRules(GUI.getInstance());
					rf.read(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		
		GUI.getInstance().getAvQualidadeMan().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {

					Leitura l = new Leitura(rf);
					
					rf.addToHashMap(); // Para atualizar HashMap
					l.lerFicheirosHAMSPAM();
					
					
					GUI.getInstance().getFpMan().setText(Integer.toString(l.getFP()));
					GUI.getInstance().getFnMan().setText(Integer.toString(l.getFN()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		
		

	}


}
