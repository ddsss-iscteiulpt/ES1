package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;

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
		if(!gui.getFnMan().getText().equals("") && !gui.getFpMan().getText().equals("")) {
			System.out.println("podes guardar valores");
			//System.out.println("cucu " + gui.getWeightList().getText());
			File file = new File("rules.cf");
			
			PrintWriter print;
			try {
				print = new PrintWriter("rules2.txt");
				print.println(gui.getWeightList().getText());
				print.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Scanner rules;
			Scanner rules2;
			try {
				
				File file2 = new File("rules2.txt");
				PrintWriter print3 = new PrintWriter("ConfiguraçãoManual.txt");
				
				
				rules = new Scanner(file);
				rules2 = new Scanner(file2);
				String line = "";
				
				while(rules.hasNextLine()) {
					//line = line + s.nextLine() + '\n';
					print3.println(rules.nextLine() + " " + rules2.nextLine());
					
					
				}
				JOptionPane.showMessageDialog(gui.getFrame(), "Guardado em : ConfiguraçãoManual.txt");
				//System.out.println("line: " + line);
				rules.close();
				rules2.close();
				print3.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			
		}else {
			//System.out.println("Atenção primeiro tens de Av. qualidade!! ");
			JOptionPane.showMessageDialog(gui.getFrame(), "Atenção primeiro tens de Av. qualidade!!");
		}

	}

}
