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
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import javax.swing.text.Element;

import java.util.Random;
import java.util.Scanner;

import antiSpamFilter.GUI;

// Os pesos aleat�rios est�o com casas d�cimais longas (nao arredondado)

public class ReadRules {

	private GUI g;
	private double peso = 0.0;
	private int numLinhas;
	

	private String line = null;
	private String pesos;
	private String regras2;
	


	HashMap<String, String> regras = new HashMap<String, String>();
	Queue<String> nomeRegras = new LinkedList<String>();
	File file; // Path deve ser diferente

	// Ficheiros rules.cf fica na mesma package que as classes
	
	

	FileReader reader = null;

	public ReadRules(GUI g) {
		this.g = g;

	}

	@SuppressWarnings("resource")

	public void read(boolean manual, File file) throws IOException {


				Random rand = new Random();
				int i = 0;
				double rangeMin = -5;
				double rangeMax = 5;
				
				
				Scanner sc;
				try {
					sc = new Scanner(file);
					if(manual==true){
					// Leitura linha a linha do ficheiro e guardar no HashMap
					while (sc.hasNextLine()) {
						i++;
//						peso = (rangeMin + (rangeMax - rangeMin) * rand.nextDouble());
						peso = 0;
						line = sc.nextLine();
						//System.out.println("linha: " + line);
						String[] divisao = line.split("	");
						
						//regras.put(line, Double.toString(peso));
						//System.out.println("divisao no read rules: " + divisao[0]);
						String s = divisao[0];
						String pesos = Double.toString(peso);
						// System.out.println(line + " " + peso);
						g.getLista().addElement(s);
						g.getWeightList().append(pesos);
						g.getWeightList().append("\n");
					}
					}else{
						while (sc.hasNextLine()) {
							i++;
							line = sc.nextLine();
							String[] divisao = line.split("	");
							nomeRegras.add(divisao[0]);                                 //array com o nome das regras
							// 							System.out.println(line + " " + peso);
							//							g.getLista().addElement(s);
							//							g.getWeightList().append(pesos);
							//							g.getWeightList().append("\n");
							String s = line;
							g.getListaAuto().addElement(s);
						}
						

				
						
					}
					sc.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				numLinhas = g.getWeightList().getLineCount();
				//addToHashMap();
				
				
	}
	
	/**
	 * Ideia: Hash recebe o que esta na JList e na TextArea
	 */
	
	public void addToHashMap(){
		
		for(int t = 0 ; t < numLinhas -1 ; t++){
			
			regras2 = g.getLista().getElementAt(t);
			pesos = g.getWeightList().getText().split("\n")[t];
			
			//System.out.println("Peso " + g.getWeightList().getText().split("\n")[t]); // Obtem peso linha a linha
			
			//System.out.println("Regra " + g.getLista().getElementAt(t)); //Obter regra uma a uma da JList
		
			regras.put(regras2, pesos);
		
		
		
		}
		
		for (Entry<String, String> entry : regras.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
//		   System.out.println("Regra = " + key + ", Peso = " + value);
		}
	}
	
	
	public HashMap<String, String> getRegras() {
		return regras;
	}
	public Queue<String> getNomeRegras() {
		return nomeRegras;
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
	
	public int getNumLinhas() {
		return numLinhas;
	}

}
