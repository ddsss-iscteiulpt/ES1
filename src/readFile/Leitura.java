package readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import antiSpamFilter.GUI;
import readRules.*;

/**  
* Leitura.java - esta classe le os ficheiros HAM e SPAM e separa-os apenas restanto a coluna que contem nome das
* regras.  
* 
* 
*/
public class Leitura {

	private File[] files;
	private int c = 0;
	private ReadRules readFiles;
	private int FP;
	private int FN;
	
	public  int getFP(){
		return FP;
	}
	public int getFN(){
		return FN;
	}

	/**
	 * Constructor.
	 * @param readFiles (required) 
	 * @throws IOException
	 */
	
	public Leitura(ReadRules readFiles) throws IOException {
		files = new File[2];
		this.readFiles = readFiles;
		//lerFicheirosHAMSPAM();
	}

	/**
	 * Este metodo le os ficheiros ham e spam e divide-os restando os nomes das regras
	 * @throws IOException
	 */
	public void lerFicheirosHAMSPAM() throws IOException {

		files[0] = GUI.getInstance().getHamFile();
		files[1] = GUI.getInstance().getSpamFile();

		//System.out.println("tamanho do files: " + files.length);



		for (int i = 0; i < files.length; i++) {
			try {

				Scanner s = new Scanner(files[i]);
				String line = "";

				while (s.hasNextLine()) {
					c++;
					//line = line + s.nextLine() + "\n";

					line = s.nextLine();
					//System.out.println("ver linhas " + line);

					String[] divisao = line.split("	");

					

					calcularFPFN(divisao, i);


				}

			} catch (FileNotFoundException e) {
			}
		}
//		System.out.println("\n FP: " + FP + "\n FN: " + FN);
		
	}

	/**
	 * Este metodo calcula os valores de FP e FN
	 * @param divisao e o nome da regra
	 * @param file pode ser o HAM ou o SPAM
	 * @throws IOException
	 */
	private void calcularFPFN(String[] divisao, int file) throws IOException{

		//Aten��o vai dar erro (NullPointerException) existem 2 regras que nao estao 
		//no rules mas aparecem no spam.log --> FM_IS_IT_OUR_ACCOUNT FROM_DOMAIN_NOVOWEL
		
			double pesoFinal = 0;
			for(int i=1; i<divisao.length; i++){
				String rule = divisao[i];
				//pesquisar divisao[i] no hashMap e substituir pelo peso
				//write no ficheiro
				
				String peso = readFiles.getRegras().get(divisao[i]);
				
				   
//				System.out.println("\n estamos aqui " + divisao[i] + " - " + peso);
//				System.out.println("------> " + peso );
				double pesoAux =  Double.parseDouble(peso);
				//System.out.println("PesoAux: " + pesoAux);
				pesoFinal += pesoAux; 
			}
			if(pesoFinal>=5 && file == 0){
				FP++;
				//System.out.println("peso final: " + pesoFinal + " Ficheiro ham --> Esta Linha deu maior que 5 \n");
			}else if(pesoFinal<5 && file!=0){
				FN++;
				//System.out.println("peso final: " + pesoFinal + " Ficheiro spam --> Esta Linha deu menor que 5 \n");
			}
	}
	
	/**
	 * 
	 * @return o read rules que e passado no construtor
	 */
	public ReadRules getReadFiles() {
		return readFiles;
	}
	
	
	
	
	
	
	
	
	
	

}
