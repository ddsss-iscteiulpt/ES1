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

public class ReadNSGAIIResults {

	private File file, file1;
	private Queue<String> pesos = new LinkedList<>();
	private GUI g;
	private String FP;

	public ReadNSGAIIResults(){}
	
	public ReadNSGAIIResults(GUI g){
		this.g=g;
	}

	@SuppressWarnings("resource")
	public void read() throws IOException{

		file = new File("C:/Users/nuno/git/ES1-2017-METIA1-41(2)/"
				+ "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String[] columns = line.split(" ");
		ArrayList<String> aux = new ArrayList<>();
		aux.add(columns[1]);
		while((line = br.readLine()) != null) {
			System.out.println(line);
			columns = line.split(" ");
			aux.add(columns[1]);
		}
		br.close();
		int pos = aux.indexOf(Collections.min(aux));
		System.out.println(aux +"\n "+pos);
		extractPesos(pos);
		
	}

	private void extractPesos(int pos) throws IOException {
		file1 = new File("C:/Users/nuno/git/ES1-2017-METIA1-41(2)/"
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
				}
				break;
			}else{
				System.out.println("next");
				i++;
			}
		}	
		br.close();
	}
}
