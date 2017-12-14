package readFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import antiSpamFilter.GUI;

/**
 * 
 * @author nuno
 *Class responsável pela Leitura dos ficheiros onde constam os resultados
 *depois de correr o algoritmo NSGAII;
 */

public class ReadNSGAIIResults {

	private File file, file1;
	private Queue<String> pesos = new LinkedList<>();
	private GUI g;
	private String FP;
	private int pos;
	private ArrayList<String> aux = new ArrayList<>();

	public ReadNSGAIIResults(){}
	
	public ReadNSGAIIResults(GUI g){
		this.g=g;
	}

	/**
	 * função responsável pela leitura do ficheiro AntiSpamFilterProblem.NSGAII.rf;
	 * Este ficheiro contém uma culuna com FPs e FNs calculados com o alghorithm NSGAII;
	 * FNs econtram-se na segunda coluna, faz-se leitura da segunda coluna e retira-se
	 * o valor mais baixo;
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void read() throws IOException{

		file = new File("C:/Users/Diogo/git/ES1-2017-METIA1-41/"
				+ "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String[] columns = line.split(" ");
//		ArrayList<String> aux = new ArrayList<>();
		aux.add(columns[1]);
		while((line = br.readLine()) != null) {
			System.out.println(line);
			columns = line.split(" ");
			aux.add(columns[1]);
		}
		br.close();
		pos = aux.indexOf(Collections.min(aux));
		System.out.println(aux +"\n "+pos);
		extractPesos(pos);
		
		GUI.getInstance().getFnAuto().setText(Collections.min(aux));
		
	}

	/**
	 * 
	 * @param pos --> parâmetro que vem da função read();
	 * posição onde se encontra o menor número de FN;  
	 * Esta posição corresponde à mesma posição (linha) onde se encontram 
	 * os pesos, no ficheiro AntiSpamFilterProblem.NSGAII.rs, adequados para obter
	 * o menor numero de FNs
	 * 
	 * esta função é responsável por retirar os pesos do ficheiro e pô-los na JtextArea
	 * 
	 * @throws IOException --> Exceção lançada se o ficheiro não for encontrado.
	 */
	private void extractPesos(int pos) throws IOException {
		file1 = new File("C:/Users/Diogo/git/ES1-2017-METIA1-41/"
				+ "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");
		BufferedReader br = new BufferedReader(new FileReader(file1));
		String line = "";
		String[] columns = line.split(" ");
		int i = 0;
		while((line = br.readLine()) != null) {
			if(i==pos){
				columns = line.split(" ");
				for(int j=0; j<columns.length; j++){
					String peso = columns[j];
					System.out.println(peso);
					pesos.add(peso);
					g.getWeightListAuto().append(peso + "\n");
				}
				break;
			}else{
				System.out.println("next");
				i++;
			}
		}	
		br.close();
	}
	
	public Queue<String> getPesos(){
		return pesos;
	}
	
	public int getPos(){
		return pos;
	}
	
	public ArrayList<String> getAux(){
		return aux;
	}
}
