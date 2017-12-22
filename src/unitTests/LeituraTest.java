package unitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import antiSpamFilter.GUI;
import readFile.Leitura;
import readRules.ReadRules;

public class LeituraTest {

	File file = new File("/Users/Diogo/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf");

	
	@Test
	public void testGetFP() throws IOException {
		ReadRules read = new ReadRules();
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.addToHashMap();
		
		
		GUI.getInstance().getSearchHam().doClick();
		GUI.getInstance().getSearchSpam().doClick();
		l.lerFicheirosHAMSPAM();
		
		assertEquals(0, l.getFP());
	}
 
	@Test
	public void testGetFN() throws IOException {
		ReadRules read = new ReadRules();
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.addToHashMap();
		
		GUI.getInstance().getSearchHam().doClick();
		GUI.getInstance().getSearchSpam().doClick();
		
		
		l.lerFicheirosHAMSPAM();
		
	
		assertEquals(239, l.getFN());
	}

	@Test
	public void testLeitura() throws IOException {

		ReadRules read = new ReadRules();
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
