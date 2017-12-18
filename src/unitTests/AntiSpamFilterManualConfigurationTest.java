package unitTests;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import antiSpamFilter.GUI;
import readFile.Leitura;

public class AntiSpamFilterManualConfigurationTest {

	@Test
	public void testInit() throws IOException {
		
		/*
		 * Nao funciona
		 */
		Leitura l = new Leitura(GUI.getInstance().getRf());
		
		GUI.getInstance().getAvQualidadeMan().doClick();
	
		assertEquals(GUI.getInstance().getFpMan().getText(), l.getFP());
		
	
	}

}
