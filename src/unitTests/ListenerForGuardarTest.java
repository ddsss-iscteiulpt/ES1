package unitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import antiSpamFilter.GUI;

public class ListenerForGuardarTest {
	
	File file = new File("/Users/nanix/git/ES1-2017-METIA1-41/ConfiguraçãoManual.txt");
	File file2 = new File("/Users/nanix/git/ES1-2017-METIA1-41/Teste.txt");

	@Test
	public void testListenerForGuardar() throws IOException {
	/*
		GUI gui = new GUI();
		gui.getSearchRules().doClick();
		
	
		
		gui.getAvQualidade().doClick();
		
		gui.getWeightList().setText("Teste");
		
		gui.getGuardar().doClick();
		
		assertTrue(FileUtils.contentEquals(file, file2));
		
		*/
		
		
	}

	@Test
	public void testActionPerformed() {
	}

}
