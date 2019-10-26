import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class NovoMenu extends JFrame {

	private JPanel contentPane;
	JTable tabela;
	private Pilha p = new Pilha();
	JScrollPane scrollPane = new JScrollPane();
	
	public NovoMenu() 
	{				
		setTitle("Animais em extincao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel tituloAnimaisPanel = new Panel();
		tituloAnimaisPanel.setBackground(new Color(0, 102, 0));
		tituloAnimaisPanel.setBounds(0, 0, 832, 83);
		contentPane.add(tituloAnimaisPanel);
		tituloAnimaisPanel.setLayout(null);
		
		JLabel lblAnimaisEmExtin = new JLabel("Animais em extin\u00E7\u00E3o");
		lblAnimaisEmExtin.setBounds(317, 23, 338, 30);
		tituloAnimaisPanel.add(lblAnimaisEmExtin);
		lblAnimaisEmExtin.setForeground(new Color(255, 255, 255));
		lblAnimaisEmExtin.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 24));
		
		JPanel panelAn = new JPanel();
		panelAn.setBackground(new Color(51, 153, 0));
		panelAn.setBounds(0, 82, 832, 416);
		contentPane.add(panelAn);
		panelAn.setLayout(null);
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(new Color(0, 102, 0));
		panelLista.setBounds(455, 21, 348, 372);
		panelAn.add(panelLista);
		panelLista.setLayout(null);
		
		JLabel lblLista = new JLabel("Listagem");
		lblLista.setBounds(42, 11, 176, 31);
		panelLista.add(lblLista);
		lblLista.setForeground(new Color(255, 255, 255));
		lblLista.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 18));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 51, 272, 272);
		panelLista.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 102, 0));
		panel_3.setBounds(60, 24, 323, 158);
		panelAn.add(panel_3);
		
		JLabel lblOpcoes = new JLabel("Op\u00E7\u00F5es");
		lblOpcoes.setForeground(Color.WHITE);
		lblOpcoes.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 18));
		lblOpcoes.setBounds(140, 11, 78, 31);
		panel_3.add(lblOpcoes);
		
		JLabel lblCadastrarUmNovo = new JLabel("Cadastrar um novo animal");
		lblCadastrarUmNovo.setForeground(new Color(255, 255, 255));
		lblCadastrarUmNovo.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		lblCadastrarUmNovo.setBounds(10, 53, 217, 14);
		panel_3.add(lblCadastrarUmNovo);
		
		JLabel lblImportaoEExportao = new JLabel("Importa\u00E7\u00E3o e exporta\u00E7\u00E3o em txt");
		lblImportaoEExportao.setForeground(Color.WHITE);
		lblImportaoEExportao.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		lblImportaoEExportao.setBounds(10, 105, 268, 14);
		panel_3.add(lblImportaoEExportao);
		
		JButton btnCadastrarMenu = new JButton("");
		btnCadastrarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NovoAnimal jAnimal = new NovoAnimal();
				jAnimal.setVisible(true);
			}
		});
		btnCadastrarMenu.setBounds(227, 45, 49, 33);
		panel_3.add(btnCadastrarMenu);
		btnCadastrarMenu.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\edit.png"));
		btnCadastrarMenu.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnCadastrarMenu.setBackground(new Color(0, 102, 0));
		
		JButton btnImpExpMenu = new JButton("");
		btnImpExpMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ImportarExportar jImpExp = new ImportarExportar();
				jImpExp.setVisible(true);
			}
		});
		btnImpExpMenu.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\refresh.png"));
		btnImpExpMenu.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnImpExpMenu.setBackground(new Color(0, 102, 0));
		btnImpExpMenu.setBounds(228, 97, 49, 33);
		panel_3.add(btnImpExpMenu);
	}
	
	public void listarDados() 
	{
		LerEscreverArq io = new LerEscreverArq();
		FileSystemView system = FileSystemView.getFileSystemView();

		String conteudo = "";
		String classe = "";
		String nome = "";
		String cientifico = "";
		String extinto = "";

		// LEITURA
		io.Read(ImportarExportar.caminho);

		for (int i = 0; i < 4; i++) 
		{
			conteudo = io.linhasDocumento(i);
			classe = conteudo.split(";")[0];
			nome = conteudo.split(";")[1];
			cientifico = conteudo.split(";")[2];
			extinto = conteudo.split(";")[3];

			p.adicionar(classe + ";" + nome + ";" + cientifico + ";" + extinto + ";");			
		}			
		listarAnimais(classe,nome,cientifico,extinto);	
		p.mostrar();
	}
	
	public void listarAnimais(String classe,String nome,String nomeCient,String anoExt) 
	{
		tabela = new JTable();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		String [] colunas = {"Classe", "Nome", "Nome cientifico","Ano de extin��o"};
		modelo.setColumnIdentifiers(colunas);

		Object[] objects = {classe,nome,nomeCient,anoExt};		
		modelo.addRow(objects);
		
		scrollPane.setViewportView(tabela);
	}
}
