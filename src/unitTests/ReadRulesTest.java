package unitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import antiSpamFilter.GUI;
import readRules.ReadRules;

public class ReadRulesTest {

	File file = new File("/Users/nanix/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf");
	
	GUI g = new GUI();
	ReadRules r = new ReadRules(g);
	
	@Test
	public void testReadRules() {
		

		
	} 

	@Test
	public void testRead() throws IOException {
		r.read(true, file);
		
		assertEquals(r.getNumLinhas(), 338);
	}

	@Test
	public void testAddToHashMap() throws IOException {
		
		r.read(true, file);
		r.addToHashMap();
		int tamanhoHash = r.getRegras().size();
		
		assertEquals(tamanhoHash, 337);
	}

	@Test
	public void testGetRegras() throws IOException {
		r.read(true, file);
		r.addToHashMap();

		Map.Entry<String,String> entry = r.getRegras().entrySet().iterator().next();
		String key = entry.getKey();
		
		assertEquals("DYN_RDNS_SHORT_HELO_HTML", key);
	}

	@Test
	public void testGetNomeRegras() throws IOException {
		
		r.getNomeRegras().add("Regra");
		
		assertEquals("Regra", r.getNomeRegras().poll());
	
	}

	@Test
	public void testGetPeso() throws IOException {
		r.read(true, file);
		r.addToHashMap();
		
		String pesoHash = g.getWeightList().getText().split("\n")[1];
		
		assertEquals(pesoHash, String.valueOf(r.getPeso()));
	}

	@Test
	public void testSetPeso() throws IOException {
		r.read(true, file);
		r.setPeso(0.0);
		r.addToHashMap();
		
		
		String peso = g.getWeightList().getText().split("\n")[1];
		
		assertEquals(peso, "0.0");
	}

	@Test
	public void testGetNumLinhas() throws IOException {
		
		r.read(true, file);
		
		assertEquals(r.getNumLinhas(), 338);
		
		
	}
	
	@Test
	public void testGetFile() {
		r.getFile();
	}

	@Test
	public void testGetReader() {
		r.getReader();
	}

}
