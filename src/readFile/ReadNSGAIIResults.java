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
import java.util.HashMap;
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

	private File[] files;
	private Queue<String> pesos = new LinkedList<>();
	private GUI g;
	private int FP;
	private int pos;
	private HashMap<Integer,String> fps  = new HashMap<>();
	private ArrayList<String> aux = new ArrayList<>();

	public ReadNSGAIIResults(){}
	
	public ReadNSGAIIResults(GUI g){
		this.g=g;
		files = new File("experimentBaseDirectory/referenceFronts").listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {

				// se retornar verdadeiro, f e incluido

				if (f.getName().endsWith("rs")||f.getName().endsWith("rf")){
					return true;
				}else
					return false;
			}
		});
		
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

		BufferedReader br = new BufferedReader(new FileReader(files[0]));
		String line = br.readLine();
		String[] columns = line.split(" ");
//		ArrayList<String> aux = new ArrayList<>();
		aux.add(columns[1]);
		fps.put(0,columns[0]);
		int i = 1;
		while((line = br.readLine()) != null) {
			System.out.println(line);
			columns = line.split(" ");
			aux.add(columns[1]);
			fps.put(i, columns[0]);
			i++;
		}
		
		pos = aux.indexOf(Collections.min(aux));
		String fp = fps.get(pos);
		GUI.getInstance().getFpAuto().setText(fp); 
		br.close();
		//
		
		System.out.println(aux +"\n "+pos);
		extractPesos(pos);
		String fn = Collections.min(aux);
		GUI.getInstance().getFnAuto().setText(fn);
		
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
		
		BufferedReader br = new BufferedReader(new FileReader(files[1]));
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
