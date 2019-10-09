import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
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

public class NovoAnimal extends JFrame 
{
	private JPanel contentPane;
	private JTextField nomeAnimal;
	private JTextField nomeCientifico;
	private JFormattedTextField anoExtinto;
	private JTextField paisPertence;
	private MaskFormatter mascaraAno;
	
	public NovoAnimal() {
		setTitle("Novo Animal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNovoAnimal = new JLabel("Novo Animal");
		lblNovoAnimal.setBounds(142, 27, 200, 32);
		lblNovoAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAnimal.setFont(new Font("Gadugi", Font.PLAIN, 24));
		contentPane.add(lblNovoAnimal);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(72, 110, 36, 14);
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);


		lblNewLabel.setBounds(65, 111, 36, 14);
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);

		nomeAnimal = new JTextField();
		nomeAnimal.setBounds(111, 109, 355, 20);
		contentPane.add(nomeAnimal);
		nomeAnimal.setColumns(10);

		JLabel lblNomeCientfico = new JLabel("Nome Cient\u00EDfico:");
		lblNomeCientfico.setBounds(10, 136, 91, 14);
		lblNomeCientfico.setFont(new Font("Gadugi", Font.PLAIN, 12));
		contentPane.add(lblNomeCientfico);

		nomeCientifico = new JTextField();
		nomeCientifico.setBounds(111, 134, 355, 20);
		nomeCientifico.setColumns(10);
		contentPane.add(nomeCientifico);

		JLabel lblAnoExtinto = new JLabel("Ano Extinto:");
		lblAnoExtinto.setBounds(37, 163, 64, 14);
		lblAnoExtinto.setFont(new Font("Gadugi", Font.PLAIN, 12));
		contentPane.add(lblAnoExtinto);

		anoExtinto = new JFormattedTextField();
		anoExtinto.setBounds(111, 161, 59, 20);
		contentPane.add(anoExtinto);
		anoExtinto.setColumns(10);

		//--------Formatar anoExtinto para ano---- Vê ai se coloco isso em um método, 
		//faço alguma coisa ou deixa assim mesmo...
		MaskFormatter formatarAno = new MaskFormatter(); 

		try {
			formatarAno.setMask("####");
			formatarAno.install(anoExtinto);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		catch ( Exception ex ) {

			ex.printStackTrace();
		}
		//---------------------------------------------------

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblDescricao.setBounds(47, 225, 54, 14);
		contentPane.add(lblDescricao);

		JLabel lblPasPertencente = new JLabel("Pa\u00EDs Pertencente:");
		lblPasPertencente.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPasPertencente.setBounds(17, 198, 91, 14);
		contentPane.add(lblPasPertencente);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(195, 330, 129, 45);
		lblPasPertencente.setBounds(10, 190, 91, 14);
		contentPane.add(lblPasPertencente);

		paisPertence = new JTextField();
		paisPertence.setBounds(111, 188, 129, 20);
		contentPane.add(paisPertence);
		paisPertence.setColumns(10);

		//WILLIAM OLHA AQUI, Gambiarra da classe LimiteJTextArea, para limitar o número de caracteres máximo, é treta, nem eu entendi direito
		JTextArea descricaoCampo = new JTextArea(); 
		// Ve ai se pode usar isso mesmo...
		descricaoCampo.setWrapStyleWord(true);
		descricaoCampo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		descricaoCampo.setLineWrap(true);
		descricaoCampo.setBounds(111, 224, 355, 98);
		contentPane.add(descricaoCampo);
		getContentPane().add(descricaoCampo);
		getContentPane().add(descricaoCampo);
		descricaoCampo.setDocument
		(new LimiteJTextArea(255)); // 413 caracteres é o valor que cabe naquela JTextArea daquele tamanho exato
		//----------------------------------------------
		
		JComboBox classeComboBox = new JComboBox();
		classeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mam\u00EDferos", "Aves", "R\u00E9pteis", "Anf\u00EDbios", "Peixes"}));
		classeComboBox.setBounds(111, 78, 91, 20);
		contentPane.add(classeComboBox);



		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String classe = classeComboBox.getSelectedItem().toString();
				String nome = nomeAnimal.getText();
				String nome_cientifico = nomeCientifico.getText();
				int ano_extinto = Integer.parseInt(anoExtinto.getText());
				String desc_animal = descricaoCampo.getText();
				String pais_pertencente = paisPertence.getText();

				BD.connect("database.db3");				
				BD.execQuery("INSERT INTO Animais (classe, nome, nome_cientifico, ano_extinto, pais_pertencente, descricao)"
						+ " VALUES ('" + classe + " ','" + nome + " ','" + nome_cientifico 
						+ "'," + ano_extinto + ",'"+ pais_pertencente + "','" + desc_animal + "');");

				//----Limpar os campos após salvar-----
				nomeAnimal.setText(null);
				nomeCientifico.setText(null);
				anoExtinto.setText(null);
				paisPertence.setText(null);
				descricaoCampo.setText(null);
				//--------------------------------------

			}

		});

		btnSalvar.setBounds(188, 330, 129, 45);
		contentPane.add(btnSalvar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 691, 21);
		contentPane.add(menuBar);

		JMenu mnMenuPrincipal = new JMenu("Menu Principal");

		mnMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				setVisible(false); // Remove a visibilidade da janela atual "Novo Animal", para retornar ao Menu Principal  
				dispose();
				VoltarMenu();
			}
		});

		menuBar.add(mnMenuPrincipal);

		JMenu mnSair = new JMenu("Sair");

		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});

		menuBar.add(mnSair);

		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setBounds(65, 81, 46, 14);
		contentPane.add(lblClasse);
	}
	
	// Método para voltar ao Menu, ou melhor, fazer ele aparecer novamente...
	public void VoltarMenu()
	{ 
		MenuPrincipal Menu = new MenuPrincipal();
		Menu.setVisible(true);
		//-------------------------------------------------------------------
	}
}

