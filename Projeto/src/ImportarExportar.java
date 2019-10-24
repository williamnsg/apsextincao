import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ImportarExportar extends JFrame 
{
	NovoMenu menu = new NovoMenu();
	private JPanel contentPane;
	private JTextField importarField;
	private JTextField exportarField;	
	private JFrame self;
	public static String caminho;	
	
	
	public ImportarExportar() 
	{
		self = this;
		setTitle("Importa\u00E7\u00E3o e exporta\u00E7\u00E3o em txt");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 568, 57);
		contentPane.add(panel);
		
		JLabel lblImportaoEExportao = new JLabel("Importa\u00E7\u00E3o e exporta\u00E7\u00E3o em txt");
		lblImportaoEExportao.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportaoEExportao.setForeground(Color.WHITE);
		lblImportaoEExportao.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 24));
		lblImportaoEExportao.setBackground(Color.WHITE);
		lblImportaoEExportao.setBounds(98, 11, 363, 30);
		panel.add(lblImportaoEExportao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 0));
		panel_1.setBounds(52, 82, 497, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		importarField = new JTextField();
		importarField.setBounds(38, 50, 326, 20);
		panel_1.add(importarField);
		importarField.setColumns(10);
		
		JLabel lblImportar = new JLabel("Importar:");
		lblImportar.setForeground(Color.WHITE);
		lblImportar.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		lblImportar.setBounds(38, 19, 65, 20);
		panel_1.add(lblImportar);
		
		JButton btnImportar = new JButton("");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				procurarArquivo();
			}
		});
		btnImportar.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\import16.png"));
		btnImportar.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnImportar.setBackground(new Color(0, 102, 0));
		btnImportar.setBounds(374, 50, 49, 20);
		panel_1.add(btnImportar);
		
		JLabel lblExportar = new JLabel("Exportar:");
		lblExportar.setForeground(Color.WHITE);
		lblExportar.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 14));
		lblExportar.setBounds(38, 81, 65, 20);
		panel_1.add(lblExportar);
		
		JButton btnExportar = new JButton("");
		btnExportar.setIcon(new ImageIcon("C:\\Users\\Felipe\\Desktop\\export16.png"));
		btnExportar.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnExportar.setBackground(new Color(0, 102, 0));
		btnExportar.setBounds(375, 112, 49, 20);
		panel_1.add(btnExportar);
		
		exportarField = new JTextField();
		exportarField.setColumns(10);
		exportarField.setBounds(38, 112, 326, 20);
		panel_1.add(exportarField);
		
		JButton btnOkImp = new JButton("ok");
		btnOkImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				menu.listarDados();
				self.dispose();
			}
		});
		btnOkImp.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnOkImp.setBackground(new Color(0, 102, 0));
		btnOkImp.setBounds(433, 49, 49, 20);
		panel_1.add(btnOkImp);
		
		JButton btnOkExp = new JButton("ok");
		btnOkExp.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnOkExp.setBackground(new Color(0, 102, 0));
		btnOkExp.setBounds(434, 112, 49, 20);
		panel_1.add(btnOkExp);
	}
	
	public void procurarArquivo() 
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Buscar arquivo .txt"); // Título
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Mostrar apenas arquivos

		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt"); // Filtro para extensão
																						// .txt
		fileChooser.setFileFilter(filter);

		int decisao = fileChooser.showOpenDialog(null); // Verificador

		if (decisao == JFileChooser.APPROVE_OPTION) { // Verificar se o usuário abriu o arquivo ou cancelou

			File file = fileChooser.getSelectedFile(); // Pegar o arquivo selecionado
			importarField.setText(file.getPath()); // Mostrar o caminho do arquivo no Text Field
			caminho = file.getPath();

			fileChooser.setAcceptAllFileFilterUsed(false);
		}
	}
}
