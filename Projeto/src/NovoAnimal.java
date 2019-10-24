import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
//import javax.xml.bind.helpers.ParseConversionEventImpl;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.ImageIcon;

public class NovoAnimal extends JFrame 
{
	private JPanel contentPane;
	private JTextField nomeAnimal;
	private JTextField nomeCientifico;
	private JFormattedTextField anoExtinto;
	private JTextField paisPertence;
	private MaskFormatter mascaraAno;
	private JFrame self;
	
	public NovoAnimal() 
	{
		self = this;
		setTitle("Novo animal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		//--------Formatar anoExtinto para ano---- Vê ai se coloco isso em um método, 
		//faço alguma coisa ou deixa assim mesmo...
		MaskFormatter formatarAno = new MaskFormatter(); 

		try {
			formatarAno.setMask("####");
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		catch ( Exception ex ) {

			ex.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 576, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNovoAnimal = new JLabel("Novo animal");
		lblNovoAnimal.setForeground(new Color(255, 255, 255));
		lblNovoAnimal.setBounds(227, 11, 130, 30);
		panel.add(lblNovoAnimal);
		lblNovoAnimal.setBackground(new Color(255, 255, 255));
		lblNovoAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAnimal.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 24));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 0));
		panel_1.setBounds(28, 80, 510, 173);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setForeground(new Color(255, 255, 255));
		lblClasse.setBounds(71, 18, 49, 16);
		panel_1.add(lblClasse);
		lblClasse.setFont(new Font("Lato", Font.ITALIC, 14));
		//----------------------------------------------

		JComboBox classeComboBox = new JComboBox();
		classeComboBox.setBounds(130, 16, 84, 22);
		panel_1.add(classeComboBox);
		classeComboBox.setFont(new Font("Gadugi", Font.PLAIN, 12));
		classeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mam\u00EDferos", "Aves", "R\u00E9pteis", "Anf\u00EDbios", "Peixes"}));

		nomeAnimal = new JTextField();
		nomeAnimal.setBounds(130, 142, 124, 20);
		panel_1.add(nomeAnimal);
		nomeAnimal.setColumns(10);

		nomeCientifico = new JTextField();
		nomeCientifico.setBounds(130, 80, 355, 20);
		panel_1.add(nomeCientifico);
		nomeCientifico.setColumns(10);

		JLabel lblNomeCientfico = new JLabel("Nome cient\u00EDfico:");
		lblNomeCientfico.setForeground(new Color(255, 255, 255));
		lblNomeCientfico.setBackground(new Color(255, 255, 255));
		lblNomeCientfico.setBounds(19, 81, 101, 14);
		panel_1.add(lblNomeCientfico);
		lblNomeCientfico.setFont(new Font("Lato", Font.ITALIC, 14));

		JLabel lblAnoExtinto = new JLabel("Ano extinto:");
		lblAnoExtinto.setForeground(new Color(255, 255, 255));
		lblAnoExtinto.setBounds(42, 112, 78, 14);
		panel_1.add(lblAnoExtinto);
		lblAnoExtinto.setFont(new Font("Lato", Font.ITALIC, 14));

		paisPertence = new JTextField();
		paisPertence.setBounds(130, 49, 355, 20);
		panel_1.add(paisPertence);
		paisPertence.setColumns(10);

		anoExtinto = new JFormattedTextField();
		anoExtinto.setBounds(130, 111, 59, 20);
		panel_1.add(anoExtinto);
		anoExtinto.setColumns(10);
		formatarAno.install(anoExtinto);

		JLabel lblPasPertencente = new JLabel("Pa\u00EDs pertencente:");
		lblPasPertencente.setForeground(new Color(255, 255, 255));
		lblPasPertencente.setBounds(10, 143, 101, 14);
		panel_1.add(lblPasPertencente);
		lblPasPertencente.setFont(new Font("Lato", Font.ITALIC, 14));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Lato", Font.ITALIC, 14));
		lblNome.setBounds(71, 45, 44, 16);
		panel_1.add(lblNome);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 0));
		panel_2.setBounds(28, 264, 510, 133);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//---------------------------------------------------

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 21, 60, 17);
		panel_2.add(lblDescricao);
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Lato", Font.ITALIC, 14));
		
		JTextArea descricaoCampo = new JTextArea();
		descricaoCampo.setBounds(80, 22, 394, 82);
		panel_2.add(descricaoCampo);		
		descricaoCampo.setWrapStyleWord(true);
		descricaoCampo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		descricaoCampo.setLineWrap(true);
		descricaoCampo.setDocument
		(new LimiteJTextArea(255)); // 413 caracteres é o valor que cabe naquela JTextArea daquele tamanho exato
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 0));
		panel_3.setBounds(159, 408, 257, 95);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSalvar = new JLabel("Adicionar");
		lblSalvar.setBounds(172, 11, 60, 17);
		panel_3.add(lblSalvar);
		lblSalvar.setForeground(Color.WHITE);
		lblSalvar.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setBounds(35, 11, 60, 17);
		panel_3.add(lblVoltar);
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		
				JButton btnVoltar = new JButton("");
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						self.dispose();
					}
				});
				btnVoltar.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\back.png"));
				btnVoltar.setBounds(26, 36, 60, 35);
				panel_3.add(btnVoltar);
				btnVoltar.setBackground(new Color(0, 102, 0));
				
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						
					}
				});
				button.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\save.png"));
				button.setBackground(new Color(0, 102, 0));
				button.setBounds(172, 36, 60, 35);
				panel_3.add(button);
	}
}

