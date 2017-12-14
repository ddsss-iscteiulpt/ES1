package unitTests;
import static org.junit.Assert.*;

import java.io.IOException;

import readFile.*;

import org.junit.Test;

public class NSGAIITest {


	@SuppressWarnings("deprecation")
	@Test
	public void testReadNSGAIIResults() throws IOException {
		ReadNSGAIIResults rn = new ReadNSGAIIResults();
		rn.read();
		int indexMin = 0;
		double min = 0;
		for(int i = 0;i<rn.getAux().size();i++){
			String fnString = rn.getAux().get(i);
			System.out.println(fnString);
			double fn = Double.parseDouble(fnString);
			if(i==0){
				i=indexMin;min=fn;
			}else if(fn<min){
				min = fn;i=indexMin;
			}	
		}
		
		assertEquals(337, rn.getPesos().size());
		assertEquals(indexMin, rn.getPos());
	}

	@Test
	public void testReadNSGAIIResultsGUI() {
	}

	@Test
	public void testRead() {
	}

}
