package readFile;


import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leitura {

	private File[] files;
	

	public Leitura() {

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

		System.out.println("tamanho do files: " + files.length);

		for (int i = 0; i < files.length; i++) {
			try {
				Scanner s = new Scanner(files[i]);
				String line = "";
				
				
				while (s.hasNextLine()) {
					line = line + s.nextLine() + "\n";
					String[] divisao = line.split("	");
					
					
					System.out.println(divisao.length);
				}

			} catch (FileNotFoundException e) {
				System.out.println("Erro no Scanner");
			}
		}

	}
}
