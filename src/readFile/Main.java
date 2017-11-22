package readFile;

import java.io.IOException;

import readRules.ReadFiles;

public class Main {

	public static void main(String[] args) throws IOException {
		 ReadFiles rf = new ReadFiles();
		  rf.read();
		Leitura l = new Leitura(rf);

	}

}
