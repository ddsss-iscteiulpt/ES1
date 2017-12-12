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

		GUI.getInstance().getSearchRules().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CF files", "cf");
				fileChooser.addChoosableFileFilter(filter);


//				try {
//					rf = new ReadRules(GUI.getInstance());
//					rf.read(true);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//					}

				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (fileChooser.getSelectedFile().isFile()) {
						File selectedFile = fileChooser.getSelectedFile();
						GUI.getInstance().getRulesPath().setText(selectedFile.getPath());
						try {
							rf = new ReadRules(GUI.getInstance());
							rf.read(true, selectedFile);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							// e1.printStackTrace();
							System.out.println("Ficheiro não localizado");
						}
					}

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
