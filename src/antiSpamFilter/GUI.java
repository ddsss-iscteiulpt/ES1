package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {
	
	private JFrame frame;

//Comment

	public GUI() {
		super();
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buildGui();
		frame.pack();
	}
	
	private void buildGui() {
		JPanel selectFiles = new JPanel();
		
		JPanel pathPanel = new JPanel();
		pathPanel.setLayout(new GridLayout(3,1));
		
		for(int i = 0; i < 3; i++){
			JTextField insertPath = new JTextField();
			insertPath.setPreferredSize(new Dimension(1000,30));
			pathPanel.add(insertPath);
		}
		
		JPanel okPanel = new JPanel();
		okPanel.setLayout(new GridLayout(3,1));
		
		for(int i = 0; i < 3; i++){
			JButton ok = new JButton("OK");
			ok.setPreferredSize(new Dimension(280,30));
			okPanel.add(ok);
		}
		
		selectFiles.add(pathPanel);
		selectFiles.add(okPanel);
		
		frame.add(selectFiles,BorderLayout.NORTH);
		
		JPanel manualConfig = new JPanel();
		
		JPanel rulesPanel = new JPanel();
		
		JList<String> rulesList = new JList<String>();
		rulesList.setPreferredSize(new Dimension(500,500));
		rulesPanel.add(rulesList);
		
		JTextArea weightList = new JTextArea();
		weightList.setPreferredSize(new Dimension(500,500));
		rulesPanel.add(weightList);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2,1));
		
		JButton avQualidade = new JButton("Av. qualidade");
		avQualidade.setPreferredSize(new Dimension(120,30));
		buttonsPanel.add(avQualidade);
		
		JButton guardar = new JButton("Guardar");
		guardar.setPreferredSize(new Dimension(120,30));
		buttonsPanel.add(guardar);
		
		manualConfig.add(rulesPanel);
		manualConfig.add(buttonsPanel);
		
		JPanel fpFn = new JPanel();
		
		JLabel fpLabel = new JLabel("FP");
		fpFn.add(fpLabel);
		
		JTextField fp = new JTextField();
		fp.setPreferredSize(new Dimension(50,50));
		fpFn.add(fp);
		
		JLabel fnLabel = new JLabel("FN");
		fpFn.add(fnLabel);
		
		JTextField fn = new JTextField();
		fn.setPreferredSize(new Dimension(50,50));
		fpFn.add(fn);
		
		manualConfig.add(fpFn);
		
		frame.add(manualConfig, BorderLayout.CENTER);
		
		JPanel autoConfig = new JPanel();
		
		JPanel rulesPanelAuto = new JPanel();
		
		JList<String> rulesListAuto = new JList<String>();
		rulesListAuto.setPreferredSize(new Dimension(500,500));
		rulesPanelAuto.add(rulesListAuto);
		
		JTextArea weightListAuto = new JTextArea();
		weightListAuto.setPreferredSize(new Dimension(500,500));
		rulesPanelAuto.add(weightListAuto);
		
		JPanel buttonsPanelAuto = new JPanel();
		buttonsPanelAuto.setLayout(new GridLayout(2,1));
		
		JButton avQualidadeAuto = new JButton("Av. qualidade");
		avQualidadeAuto.setPreferredSize(new Dimension(120,30));
		buttonsPanelAuto.add(avQualidadeAuto);
		
		JButton guardarAuto = new JButton("Guardar");
		guardarAuto.setPreferredSize(new Dimension(120,30));
		buttonsPanelAuto.add(guardarAuto);
		
		autoConfig.add(rulesPanelAuto);
		autoConfig.add(buttonsPanelAuto);
		
		JPanel fpFnAuto = new JPanel();
		
		JLabel fpLabelAuto = new JLabel("FP");
		fpFnAuto.add(fpLabelAuto);
		
		JTextField fpAuto = new JTextField();
		fpAuto.setPreferredSize(new Dimension(50,50));
		fpFnAuto.add(fpAuto);
		
		JLabel fnLabelAuto = new JLabel("FN");
		fpFnAuto.add(fnLabelAuto);
		
		JTextField fnAuto = new JTextField();
		fnAuto.setPreferredSize(new Dimension(50,50));
		fpFnAuto.add(fnAuto);
		
		autoConfig.add(fpFnAuto);
		
		frame.add(autoConfig, BorderLayout.SOUTH);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public void open(){
		frame.setVisible(true);
	}
	
	
	
	

}
