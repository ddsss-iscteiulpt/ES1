package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import readFile.Leitura;
import readRules.ReadRules;

public class AntiSpamFilterManualConfiguration {

	private ReadRules rf;

	public void init() {

		
		GUI.getInstance().getAvQualidadeMan().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
					rf = new ReadRules(GUI.getInstance());
					rf.read(true, GUI.getInstance().getRulesFile());

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
