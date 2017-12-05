package readRules;

import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import antiSpamFilter.GUI;

// Os pesos aleatórios estão com casas décimais longas (nao arredondado)

public class ReadFiles {

	private GUI g;
	private double peso = 0.0;



	HashMap<String, String> regras = new HashMap<String, String>();
	File file; // Path deve ser diferente
	// Ficheiros rules.cf fica na mesma package que as classes

	FileReader reader = null;

	public ReadFiles(GUI g) {
		this.g = g;

	}

	@SuppressWarnings("resource")
	public void read() throws IOException {

				file = new File(g.getRulesPath().getText());
				Random rand = new Random();
				int i = 0;
				double rangeMin = -5;
				double rangeMax = 5;
				
				String line = null;
				Scanner sc;
				try {
					sc = new Scanner(file);

					// Leitura linha a linha do ficheiro e guardar no HashMap
					while (sc.hasNextLine()) {
						i++;
						peso = (rangeMin + (rangeMax - rangeMin) * rand.nextDouble());
						line = sc.next();
						regras.put(line, Double.toString(peso));
						String s = line;
						String pesos = Double.toString(peso);
						// System.out.println(line + " " + peso);
						g.getLista().addElement(s);
						g.getWeightList().append(pesos);
						g.getWeightList().append("\n");
					}
					sc.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public HashMap<String, String> getRegras() {
		return regras;
	}

	public File getFile() {
		return file;
	}

	public FileReader getReader() {
		return reader;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

}
