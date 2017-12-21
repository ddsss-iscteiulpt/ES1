package unitTests;

import static org.junit.Assert.*;

import javax.swing.JList;

import org.junit.Test;

import antiSpamFilter.GUI;

public class GUITest {
	
	GUI gui = new GUI();
	private JList<String> rulesListAuto;

	
	
	@Test
	public void testGetRf_automatico() {
		gui.getRf_automatico();
	}

	@Test
	public void testGetRulesListAuto() {
		gui.getRulesListAuto();
	}

	@Test
	public void testSetRulesListAuto() {
		gui.setRulesListAuto(rulesListAuto);
	}


	@Test
	public void testGetRf() {
		gui.getRf();
	}

	@Test
	public void testGetInstance() {
	}

	@Test
	public void testGetFrame() {
		gui.getFrame();
	}

	@Test
	public void testGUI() {
	}

	@Test
	public void testBuildGui() {
	}

	@Test
	public void testAddPathPanel() {
		
		gui.getSearchRules().doClick();
	}

	@Test
	public void testAddManualConfig() {
	}

	@Test
	public void testGetAvQualidadeMan() {
	}

	@Test
	public void testGetFpMan() {
		gui.getFpMan();
	}

	@Test
	public void testGetFnMan() {
		gui.getFnMan();
	}

	@Test
	public void testGetRulesPath() {
		gui.getRulesPath();
	}
	
	@Test
	public void testGetGuardar() {
		gui.getGuardar();
	}

	@Test
	public void testAddAutoConfig() {
	}

	@Test
	public void testGetFpAuto() {
		
		gui.getFpAuto();
	}

	@Test
	public void testGetFnAuto() {
		
		gui.getFnAuto();
	}

	@Test
	public void testGetListaAuto() {
		
		gui.getListaAuto();
	}

	@Test
	public void testGetWeightListAuto() {
		
		gui.getWeightListAuto();
	}

	@Test
	public void testGetAvQualidadeAuto() {
	}

	@Test
	public void testGetAvQualidade() {
		gui.getAvQualidade();
	}

	@Test
	
	public void testGetFp() {
		
		gui.getFp();
	}

	@Test
	public void testGetFn() {
		
		gui.getFn();
	}

	@Test
	public void testGetLista() {
	}

	@Test
	public void testGetSearchRules() {
		
		gui.getSearchRules();
		
		
	}

	@Test
	public void testGetRulesList() {
		
		gui.getRulesList();
	}

	@Test
	public void testGetWeightList() {
	}

	@Test
	public void testGetRulesFile() {
		
		gui.getRulesFile();
	}
	
	@Test
	public void testGetSearchHam() {
	gui.getSearchHam().doClick();
	}

	@Test
	public void testGetSearchSpam() {
	gui.getSearchSpam().doClick();
	
	}

}
