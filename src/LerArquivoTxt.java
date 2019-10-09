import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
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

public class LerArquivoTxt extends JFrame
{
	JPanel contentPane;
	private JTextField caminhoTxt;
	private String caminho;

	public LerArquivoTxt() {
		setTitle("Ler Arquivo .txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		caminhoTxt = new JTextField();
		caminhoTxt.setBounds(10, 150, 467, 20);
		contentPane.add(caminhoTxt);
		caminhoTxt.setColumns(10);

		JButton btnBuscarArquivo = new JButton("Buscar Arquivo");
		btnBuscarArquivo.setBounds(483, 149, 126, 23);
		contentPane.add(btnBuscarArquivo);
		btnBuscarArquivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Buscar arquivo .txt"); // Título
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Mostrar apenas arquivos

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt"); // Filtro para extensão
																								// .txt
				fileChooser.setFileFilter(filter);

				int decisao = fileChooser.showOpenDialog(null); // Verificador

				if (decisao == JFileChooser.APPROVE_OPTION) { // Verificar se o usuário abriu o arquivo ou cancelou

					File file = fileChooser.getSelectedFile(); // Pegar o arquivo selecionado
					caminhoTxt.setText(file.getPath()); // Mostrar o caminho do arquivo no Text Field
					caminho = file.getPath();

					fileChooser.setAcceptAllFileFilterUsed(false);
				}
			}
		});

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// parametros de leitura/escrita
				LerEscreverArq io = new LerEscreverArq();
				FileSystemView system = FileSystemView.getFileSystemView();

				String conteudo = "";
				String nome = "";
				String cientifico = "";
				String extinto = "";
				String descricao = "";
				String pais = "";

				// LEITURA
				io.Read(caminho);

				for (int i = 0; i < 4; i++) {
					conteudo = io.linhasDocumento(i);
					nome = conteudo.split(";")[0];
					cientifico = conteudo.split(";")[1];
					extinto = conteudo.split(";")[2];
					descricao = conteudo.split(";")[3];
					pais = conteudo.split(";")[4];

					String text = "Nome Popular   :" + nome + "\n" + "Nome Cientifico:" + cientifico + "\n"
							+ "Ano Extinto    :" + extinto + "\n" + "DescriÃ§Ã£o      :" + descricao + "\n"
							+ "PaÃ­s de Origem :" + pais + "\n";
					System.out.println(text);
				}
			}

		});
		btnImportar.setBounds(244, 203, 134, 57);
		contentPane.add(btnImportar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 619, 21);
		contentPane.add(menuBar);

		JMenu mnMenuPrincipal = new JMenu("Menu Principal");

		mnMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				setVisible(false); // Remove a visibilidade da janela atual "Novo Animal", para retornar ao Menu
									// Principal
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

		JLabel lblImportarArquivotxt = new JLabel("Importar Arquivo .txt");
		lblImportarArquivotxt.setFont(new Font("Gadugi", Font.BOLD, 24));
		lblImportarArquivotxt.setBounds(186, 72, 252, 40);
		contentPane.add(lblImportarArquivotxt);

	}

	// Método para voltar ao Menu, ou melhor, fazer ele aparecer novamente...
	public void VoltarMenu() {
		MenuPrincipal Menu = new MenuPrincipal();
		Menu.setVisible(true);
		// -------------------------------------------------------------------

	}
}
