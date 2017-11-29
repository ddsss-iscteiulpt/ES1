package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame;
	private JButton ok;
	private JList<String> rulesList;
	private JTextArea weightList;
	private DefaultListModel<String> lista;
	private JTextField rulesPath;
	private DefaultListModel<String> listaAuto;
	private JTextField spamPath;
	private JTextField hamPath;
	private JButton ok1;
	private JButton ok2;
	private JTextField fp;
	private JTextField fn;
	private JButton avQualidade;
	public static final GUI INSTANCE = new GUI();

	// Comment

	public static GUI getInstance() {
		return INSTANCE;
	}

	public GUI() {
		super();
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buildGui();
		frame.pack();
		frame.setVisible(true);
	}

	public void addPathPanel() {
		JPanel selectFiles = new JPanel();

		JPanel pathPanel = new JPanel();
		pathPanel.setLayout(new GridLayout(3, 1));

		rulesPath = new JTextField();
		rulesPath.setFont(new Font("Arial", Font.PLAIN, 16));
		rulesPath.setPreferredSize(new Dimension(500, 30));
		rulesPath.setText("/Users/mariana/git/ES1-2017-METIA1-41/src/antiSpamFilter/rules.cf"); // esta
																					// linha
																					// n�o
																					// �
																					// suposto
																					// existir
		pathPanel.add(rulesPath);

		spamPath = new JTextField();
		spamPath.setFont(new Font("Arial", Font.PLAIN, 16));
		spamPath.setPreferredSize(new Dimension(500, 30));
		pathPanel.add(spamPath);

		hamPath = new JTextField();
		hamPath.setFont(new Font("Arial", Font.PLAIN, 16));
		hamPath.setPreferredSize(new Dimension(500, 30));
		pathPanel.add(hamPath);

		JPanel okPanel = new JPanel();
		okPanel.setLayout(new GridLayout(3, 1));

		ok = new JButton("OK");
		ok.setPreferredSize(new Dimension(200, 30));
		okPanel.add(ok);

		ok1 = new JButton("OK");
		ok1.setPreferredSize(new Dimension(200, 30));
		okPanel.add(ok1);

		ok2 = new JButton("OK");
		ok2.setPreferredSize(new Dimension(200, 30));
		okPanel.add(ok2);

		selectFiles.add(pathPanel);
		selectFiles.add(okPanel);

		frame.add(selectFiles, BorderLayout.NORTH);

	}

	public void addManualConfig() {
		lista = new DefaultListModel<String>();

		JPanel manualConfig = new JPanel();

		JPanel rulesPanel = new JPanel();
		rulesPanel.setLayout(new GridLayout(1, 2));
		rulesPanel.setSize(300, 300);

		rulesList = new JList<String>(lista);

		weightList = new JTextArea();
		
		
		
		/**
		 * FOI AQUI QUE ALTEREI!
		 * 
		 * NOTA: Desta forma as regras e os pesos ficam com uma scroll sincronizada
		 * Há um problema que talvez seja devido ao tamanho do GUI ou da forma como os elementos estão dispostos
		 * Aquilo que acontece é que não aparecem 20 linhas finais do ficheiro de regras...Mas de resto funciona 100%
		 * 
		 * Para voltarem ao código anterior basta "descomentar" o código que está comentado por baixo deste
		 */
		
		
		JScrollPane scrollArea1 = new JScrollPane(rulesList, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollArea2 = new JScrollPane(weightList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		scrollArea2.getVerticalScrollBar().setModel(scrollArea1.getVerticalScrollBar().getModel());
		
		
		
		
		rulesPanel.add(scrollArea1);
		rulesPanel.add(scrollArea2);
		
/*
		rulesPanel.add(rulesList);

		JScrollPane scrollArea = new JScrollPane(rulesList);
		rulesPanel.add(scrollArea);

		rulesPanel.add(weightList);

		JScrollPane scrollArea2 = new JScrollPane(weightList);
		rulesPanel.add(scrollArea2);
*/
		
		
		
		
		
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1));

		avQualidade = new JButton("Av. qualidade");
		avQualidade.setPreferredSize(new Dimension(120, 30));
		buttonsPanel.add(avQualidade);

		JButton guardar = new JButton("Guardar");
		guardar.setPreferredSize(new Dimension(120, 30));
		buttonsPanel.add(guardar);

		manualConfig.add(rulesPanel);
		manualConfig.add(buttonsPanel);

		JPanel fpFn = new JPanel();

		JLabel fpLabel = new JLabel("FP");
		fpFn.add(fpLabel);

		fp = new JTextField();
		fp.setPreferredSize(new Dimension(50, 50));
		fpFn.add(fp);

		JLabel fnLabel = new JLabel("FN");
		fpFn.add(fnLabel);

		fn = new JTextField();
		fn.setPreferredSize(new Dimension(50, 50));
		fpFn.add(fn);

		manualConfig.add(fpFn);

		frame.add(manualConfig, BorderLayout.CENTER);

	}

	public JButton getAvQualidade() {
		return avQualidade;
	}

	public JTextField getFp() {
		return fp;
	}

	public JTextField getFn() {
		return fn;
	}

	public JTextField getRulesPath() {
		return rulesPath;
	}

	public void addAutoConfig() {
		listaAuto = new DefaultListModel<String>();

		JPanel autoConfig = new JPanel();

		JPanel rulesPanelAuto = new JPanel();
		rulesPanelAuto.setLayout(new GridLayout(1, 2));

		JList<String> rulesListAuto = new JList<String>(listaAuto);

		JTextArea weightListAuto = new JTextArea();

		rulesPanelAuto.add(rulesListAuto);

		JScrollPane scrollArea = new JScrollPane(rulesListAuto);
		rulesPanelAuto.add(scrollArea);

		rulesPanelAuto.add(weightListAuto);

		JScrollPane scrollArea2 = new JScrollPane(weightListAuto);
		rulesPanelAuto.add(scrollArea2);

		JPanel buttonsPanelAuto = new JPanel();
		buttonsPanelAuto.setLayout(new GridLayout(2, 1));

		JButton avQualidadeAuto = new JButton("Av. qualidade");
		avQualidadeAuto.setPreferredSize(new Dimension(120, 30));
		buttonsPanelAuto.add(avQualidadeAuto);

		JButton guardarAuto = new JButton("Guardar");
		guardarAuto.setPreferredSize(new Dimension(120, 30));
		buttonsPanelAuto.add(guardarAuto);

		autoConfig.add(rulesPanelAuto);
		autoConfig.add(buttonsPanelAuto);

		JPanel fpFnAuto = new JPanel();

		JLabel fpLabelAuto = new JLabel("FP");
		fpFnAuto.add(fpLabelAuto);

		JTextField fpAuto = new JTextField();
		fpAuto.setPreferredSize(new Dimension(50, 50));
		fpFnAuto.add(fpAuto);

		JLabel fnLabelAuto = new JLabel("FN");
		fpFnAuto.add(fnLabelAuto);

		JTextField fnAuto = new JTextField();
		fnAuto.setPreferredSize(new Dimension(50, 50));
		fpFnAuto.add(fnAuto);

		autoConfig.add(fpFnAuto);

		frame.add(autoConfig, BorderLayout.SOUTH);

	}

	public void buildGui() {

		addPathPanel();
		addManualConfig();
		addAutoConfig();

	}

	public DefaultListModel<String> getLista() {
		return lista;
	}

	public JButton getOk() {
		return ok;
	}

	public JList<String> getRulesList() {
		return rulesList;
	}

	public JTextArea getWeightList() {
		return weightList;
	}

}
