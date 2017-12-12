import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import antiSpamFilter.GUI;
import readFile.Leitura;
import readRules.ReadRules;

public class TestLeitura {
	
	File file = new File("/Users/nanix/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf");

	
	@Test
	public final void testGetFP() throws IOException {
		GUI gui = new GUI();
		ReadRules read = new ReadRules(gui);
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.setPeso(0);
		read.addToHashMap();
		//Como é que ele sabe que ja pressionaram o botao (Dado que so le o valores ques ja 
		// estao na textArea??)
		assertEquals(0, l.getFP());
		
	}

	@Test
	public final void testGetFN() throws IOException {
		GUI gui = new GUI();
		ReadRules read = new ReadRules(gui);
		Leitura l = new Leitura(read);
		read.read(true, file);
		read.setPeso(0);
		read.addToHashMap();
		//Como é que ele sabe que ja pressionaram o botao (Dado que so le o valores ques ja 
		// estao na textArea??)
		assertEquals(239, l.getFN());
	}

	@Test
	public final void testSetFP() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetFN() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testLeitura() {
		fail("Not yet implemented"); // TODO
	}

}
