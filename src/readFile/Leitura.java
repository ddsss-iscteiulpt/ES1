package readFile;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import readRules.*;

public class Leitura {

	private File[] files;
	private int c = 0;
	private ReadFiles readFiles;
	public int FP;
	public int FN;
	
	public  int getFP(){
		return FP;
	}
	public int getFN(){
		return FN;
	}

	public void setFP(int FP) {
	      this.FP = FP;
	    }
	public  void setFN(int FN) {
	       this.FN = FN;
	    }
	
	public Leitura(ReadFiles readFiles) throws IOException {

		this.readFiles = readFiles;
		lerFicheiros();
	}

	private void lerFicheiros() throws IOException {

		files = new File("Ficheiros").listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {

				// se retornar verdadeiro, f ser� incluido

				if (f.getName().endsWith("txt"))
					return true;

				return false;
			}
		});

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

					for(int j = 0; j< divisao.length; j++){
						//System.out.println("vamos ver o que esta na divisao " + j + " " + divisao[j]);
					}
					//String[] divisao = s.nextLine().split("	");

					lerColuna(divisao, i);


				}

			} catch (FileNotFoundException e) {
				System.out.println("Erro no Scanner");
			}
		}
		System.out.println("\n FP: " + FP + "\n FN: " + FN);
		
	}

	private void lerColuna(String[] divisao, int file) throws IOException{


		//Aten��o vai dar erro (NullPointerException) existem 2 regras que nao estao 
		//no rules mas aparecem no spam.log --> FM_IS_IT_OUR_ACCOUNT FROM_DOMAIN_NOVOWEL
		
			double pesoFinal = 0;
			for(int i=1; i<divisao.length; i++){
				String rule = divisao[i];
				//pesquisar divisao[i] no hashMap e substituir pelo peso
				//write no ficheiro
				String peso = readFiles.getRegras().get(divisao[i]);
				System.out.println("\n estamos aqui " + divisao[i] + " - " + peso);
				System.out.println("------> " + peso );
				double pesoAux =  Double.parseDouble(peso);
				System.out.println("PesoAux: " + pesoAux);
				pesoFinal += pesoAux; 
			}
			if(pesoFinal>5 && file == 0){
				FP++;
				System.out.println("peso final: " + pesoFinal + " Ficheiro ham --> Esta Linha deu maior que 5 \n");
			}else if(pesoFinal<5 && file!=0){
				FN++;
				System.out.println("peso final: " + pesoFinal + " Ficheiro spam --> Esta Linha deu menor que 5 \n");
			}


	}
	
	
	
	
	
	
	
	
	
	
	
}
