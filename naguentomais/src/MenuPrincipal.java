import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuPrincipal extends JFrame 
{
	JPanel contentPane;
	private static String caminho;
	private JTable tabela;
	private JScrollPane scrollPane;
	
	public MenuPrincipal() 
	{
		setTitle("Animais em extincao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAnimais = new JMenu("Arquivo");
		menuBar.add(mnAnimais);
		
		JMenuItem mntmNovoAnimal = new JMenuItem("Importar");
		mntmNovoAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				procurarArquivo();
			}
		});
		mnAnimais.add(mntmNovoAnimal);
		
		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		mnAnimais.add(mntmExportar);
		
		JMenu mnAnimais_1 = new JMenu("Animais");
		menuBar.add(mnAnimais_1);
		
		JMenuItem mntmNovo = new JMenuItem("Adicionar");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NovoAnimal jNovo = new NovoAnimal();
				jNovo.setVisible(true);
			}
		});
		mnAnimais_1.add(mntmNovo);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				excluir();
			}
		});
		mnAnimais_1.add(mntmRemover);
		
		JMenuItem mntmOrdenar = new JMenuItem("Ordenar");
		mnAnimais_1.add(mntmOrdenar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 111, 1200, 500);
		contentPane.add(scrollPane);
		
		JLabel lblListaDeAnimais = new JLabel("Lista de animais em extincao");
		lblListaDeAnimais.setFont(new Font("Arial", Font.PLAIN, 24));
		lblListaDeAnimais.setBounds(30, 77, 372, 23);
		contentPane.add(lblListaDeAnimais);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				importarDados();

			}
		});
		btnAtualizar.setBounds(30, 626, 89, 23);
		contentPane.add(btnAtualizar);
	}
	
	public void procurarArquivo() 
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Buscar arquivo .txt"); // T�tulo
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Mostrar apenas arquivos

		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt"); // Filtro para extens�o
																						// .txt
		fileChooser.setFileFilter(filter);

		int decisao = fileChooser.showOpenDialog(null); // Verificador

		if (decisao == JFileChooser.APPROVE_OPTION) { // Verificar se o usu�rio abriu o arquivo ou cancelou

			File file = fileChooser.getSelectedFile(); // Pegar o arquivo selecionado
			//importarField.setText(file.getPath()); // Mostrar o caminho do arquivo no Text Field
			setCaminho(file.getPath());

			fileChooser.setAcceptAllFileFilterUsed(false);
			importarDados();
		}
	}
	
	public void importarDados() 
	{
		// parametros de leitura/escrita
		LerTxt leitura = new LerTxt();
		//ManipularArquivo io = new ManipularArquivo();
		FileSystemView system = FileSystemView.getFileSystemView();
		
		String conteudo = "";
		String nome = "";
		String cientifico = "";
		String extinto = "";
		String classe = "";
		String pais = "";

		tabela = new JTable();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		String [] colunas = {"Classe", "Nome", "Nome Cientifico","Ano Extinto", "Pais de origem"};
		modelo.setColumnIdentifiers(colunas);
		
		// LEITURA
		leitura.lerArquivo(getCaminho());

		for (int i = 0; i <leitura.arqTxt.size(); i++) 
		{					
			conteudo = leitura.linhasDocumento(i);
			classe = conteudo.split(";")[0];
			nome = conteudo.split(";")[1];
			cientifico = conteudo.split(";")[2];
			extinto = conteudo.split(";")[3];
			pais = conteudo.split(";")[4];

			String text = "Classe   :" + classe +"Nome   :" + nome + "\n" + "Nome Cientifico:" + cientifico + "\n"
					+ "Ano Extinto    :" + extinto + "\n" + "Pais de Origem :" + pais + "\n";
			System.out.println(text);
			Object[] objects = {classe, nome, cientifico,extinto,pais};
			modelo.addRow(objects);
		}
		scrollPane.setViewportView(tabela);
	}
	
	public void excluir() 
	{
		//ManipularArquivo io = new ManipularArquivo();
		RemoveTxt r = new RemoveTxt();
		int linha = tabela.getSelectedRow();
		
		if(linha >=0) 
		{			
			r.removeLine(linha);
			importarDados();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "� necess�rio selecionar uma linha.");
		}
	}

	public static String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}	
}
