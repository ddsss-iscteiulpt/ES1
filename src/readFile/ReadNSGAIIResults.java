package readFile;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import antiSpamFilter.GUI;

/**
 * 
 * @author nuno
 *Class respons�vel pela Leitura dos ficheiros onde constam os resultados
 *depois de correr o algoritmo NSGAII;
 */

public class ReadNSGAIIResults {

	private File[] files;
	private Queue<String> pesos = new LinkedList<>();
	private int pos;
	private HashMap<Integer,String> fps  = new HashMap<>();
	private ArrayList<String> aux = new ArrayList<>();

	public ReadNSGAIIResults(){
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
	 * fun��o respons�vel pela leitura do ficheiro AntiSpamFilterProblem.NSGAII.rf;
	 * Este ficheiro cont�m uma culuna com FPs e FNs calculados com o alghorithm NSGAII;
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
		
		extractPesos(pos);
		String fn = Collections.min(aux);
		GUI.getInstance().getFnAuto().setText(fn);
		
	}

	/**
	 * 
	 * @param pos --> par�metro que vem da fun��o read();
	 * posi��o onde se encontra o menor n�mero de FN;  
	 * Esta posi��o corresponde � mesma posi��o (linha) onde se encontram 
	 * os pesos, no ficheiro AntiSpamFilterProblem.NSGAII.rs, adequados para obter
	 * o menor numero de FNs
	 * 
	 * esta fun��o � respons�vel por retirar os pesos do ficheiro e p�-los na JtextArea
	 * 
	 * @throws IOException --> Exce��o lan�ada se o ficheiro n�o for encontrado.
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
					pesos.add(peso);
					GUI.getInstance().getWeightListAuto().append(peso + "\n");
				}
				break;
			}else{
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
	
	public void do_boxplot() {

		String[] params = new String[2];
		String[] envp = new String[1];

		params[0] = "C:\\Program Files\\R\\R-3.4.3\\bin\\x64\\Rscript.exe";
		params[1] = "C:\\Users\\nuno\\git\\ES1-2017-METIA1-41(2)\\experimentBaseDirectory\\AntiSpamStudy\\R\\HV.Boxplot.R";
		envp[0] = "Path = C:\\Program Files\\R\\R-3.4.3\\bin\\x64";

		try {
			Process p = Runtime.getRuntime().exec(params,envp, new File("C:\\Users\\nuno\\git\\ES1-2017-METIA1-41(2)\\experimentBaseDirectory\\AntiSpamStudy\\R"));
			System.out.println("Ficheiro esp done ");
		} catch (IOException e) {
			System.out.println("Erro a gerar os gr�ficos R");
		}


		String[] paramsLatex = new String[2];
		String[] envpLatex = new String[1];

		paramsLatex[0] = "C:\\Program Files\\MiKTeX 2.9\\miktex\\bin\\x64\\pdflatex.exe";
		paramsLatex[1] = "C:\\Users\\nuno\\git\\ES1-2017-METIA1-41(2)\\experimentBaseDirectory\\AntiSpamStudy\\latex\\AntiSpamStudy.tex";
		envpLatex[0] = "Path = C:\\Program Files\\MiKTeX 2.9\\miktex\\bin\\x64";

		try {
			Process p = Runtime.getRuntime().exec(paramsLatex,envpLatex, new File("C:\\Users\\nuno\\git\\ES1-2017-METIA1-41(2)\\experimentBaseDirectory\\AntiSpamStudy\\latex"));
			System.out.println("DONEEEEEEEEEEEEEEEEEEEEEEE");
		} catch (IOException e) {
			System.out.println("Erro a gerar os gr�ficos latex");
		}
	}
} 
