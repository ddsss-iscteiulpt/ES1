package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import readFile.Leitura;
import readRules.ReadFiles;

public class AntiSpamFilterManualConfiguration {

	private ReadFiles rf;

	public void init() {

		GUI.getInstance().getOk().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					rf = new ReadFiles(GUI.getInstance());
					rf.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		
		GUI.getInstance().getAvQualidade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					Leitura l = new Leitura(rf);
					l.setFN(0);
					l.setFP(0);

					GUI.getInstance().getFp().setText(Integer.toString(l.FP));
					GUI.getInstance().getFn().setText(Integer.toString(l.FN));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		
		

	}


}
