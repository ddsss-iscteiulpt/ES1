package antiSpamFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import readFile.Leitura;
import readRules.ReadRules;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	private ReadRules rf = new ReadRules(GUI.getInstance());
	
	  public AntiSpamFilterProblem() {
	    // 10 variables (anti-spam filter rules) by default 
	    this(337);
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){
//			System.out.println("-----------------------------------------------");
			double aux, xi, xj;
			File file = new File("/Users/Nanix/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf");
			double[] fx = new double[getNumberOfObjectives()];
			double[] x = new double[getNumberOfVariables()];
			try {
				rf.read(false,file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rf.getRegras();
			rf.getNomeRegras();
			
			//System.out.println("Numero de Regras " + rf.getNomeRegras().size() + 
			//		" Numero de variáveis: " + solution.getNumberOfVariables());
			
			for (int i = 0; i < solution.getNumberOfVariables(); i++){
				x[i] = solution.getVariableValue(i);
				String peso = solution.getVariableValue(i).toString();
				String name = rf.getNomeRegras().poll();
				rf.getRegras().put(name, peso);
//				//System.out.println(name +" "+peso+	 "\n");
			}

			try {
				Leitura l = new Leitura(rf);
				l.lerFicheirosHAMSPAM();
				fx[0]=l.getFP();
				fx[1]=l.getFN();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
//		    fx[0] = 0.0;
//		    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) {
//			  fx[0] += Math.abs(x[0]); // Example for testing
//		    }
//	
//		    fx[1] = 0.0;
//		    for (int var = 0; var < solution.getNumberOfVariables(); var++) {
//		    	fx[1] += Math.abs(x[1]); // Example for testing
//		    }
			

			solution.setObjective(0, fx[0]);
			solution.setObjective(1, fx[1]);
		}
	}
