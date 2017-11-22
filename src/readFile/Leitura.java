package readFile;


import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

import readRules.*;

public class Leitura {

	private File[] files;
	private int c = 0;
	private ReadFiles readFiles;

	public Leitura(ReadFiles readFiles) {

		this.readFiles = readFiles;
		lerFicheiros();
	}

	private void lerFicheiros() {

		files = new File("Ficheiros").listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {

				// se retornar verdadeiro, f será incluido

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
					System.out.println("ver linhas " + line);
					
					String[] divisao = line.split("	");
					
					for(int j = 0; j< divisao.length; j++){
						//System.out.println("vamos ver o que esta na divisao " + j + " " + divisao[j]);
					}
					//String[] divisao = s.nextLine().split("	");
					
					//lerColuna(divisao);
					
					
				}
				System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////contador: " + c);
				
			} catch (FileNotFoundException e) {
				System.out.println("Erro no Scanner");
			}
		}

	}

	private void lerColuna(String[] divisao) {
		
		
		for(int i=1; i<divisao.length; i++){
			String rule = divisao[i];
			//pesquisar divisao[i] no hashMap e substituir pelo peso
			//write no ficheiro
			String peso = readFiles.getRegras().get(divisao[i]);
			System.out.println("estamos aqui " + divisao[i] + " - " + peso);
			
			
			
		}
		
	}
}
