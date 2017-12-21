package unitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import antiSpamFilter.GUI;
import readFile.Leitura;
import readRules.ReadRules;

public class LeituraTest {

	File file = new File("/Users/Catarina/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf");

	/**
	 * Nao esta a ser testado............
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGetFP() throws IOException {
		GUI gui = new GUI();
		ReadRules read = new ReadRules(gui);
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.addToHashMap();
		l.lerFicheirosHAMSPAM();
		
		assertEquals(0, l.getFP());
	}

	@Test
	public void testGetFN() throws IOException {
		GUI gui = new GUI();
		ReadRules read = new ReadRules(gui);
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.addToHashMap();
		//l.setPesoFinal(0);
		l.lerFicheirosHAMSPAM();
		
	
		assertEquals(239, l.getFN());
	}

	@Test
	public void testLeitura() throws IOException {

		GUI gui = new GUI();
		ReadRules read = new ReadRules(gui);
		Leitura l = new Leitura(read);
		assertEquals(l.getReadFiles(), read);
	}

	@Test
	public void testLerFicheirosHAMSPAM() {
	
		
		}

	
	
	@Test
	public void testGetReadFiles() {
	}

}
