import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class SalvarArquivoTxt extends JFrame {

	private JPanel contentPane;
	private JTextField caminhoTxt;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalvarArquivoTxt frame = new SalvarArquivoTxt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public SalvarArquivoTxt() {
		setEnabled(false);
		setTitle("Salvar Arquivo .txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnSalvar = new JButton("Buscar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Selecione o local para salvar:"); // Título
				//fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Mostrar apenas arquivos

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt"); // Filtro para extensão .txt
				fileChooser.setFileFilter(filter);

				int decisao = fileChooser.showSaveDialog(null); // Verificador

				if(decisao == JFileChooser.APPROVE_OPTION) { // Verificar se o usuário abriu o arquivo ou cancelou

					File file = fileChooser.getSelectedFile(); // Pegar o arquivo selecionado
					caminhoTxt.setText(file.getPath()); // Mostrar o caminho do arquivo no Text Field

				}
				
			}});
		
		btnSalvar.setBounds(561, 411, 134, 21);
		contentPane.add(btnSalvar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 705, 21);
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

		JLabel lblImportarArquivotxt = new JLabel("Salvar Arquivo .txt");
		lblImportarArquivotxt.setFont(new Font("Gadugi", Font.BOLD, 24));
		lblImportarArquivotxt.setBounds(253, 45, 252, 40);
		contentPane.add(lblImportarArquivotxt);
		
		caminhoTxt = new JTextField();
		caminhoTxt.setBounds(31, 411, 520, 20);
		contentPane.add(caminhoTxt);
		caminhoTxt.setColumns(10);
		
		JLabel lblSelecioneOLocal = new JLabel("Selecione o local para salvar:");
		lblSelecioneOLocal.setBounds(31, 386, 172, 14);
		contentPane.add(lblSelecioneOLocal);
		
		JLabel lblBuscarAnimais = new JLabel("Buscar Animais:");
		lblBuscarAnimais.setBounds(31, 120, 109, 14);
		contentPane.add(lblBuscarAnimais);
		
		JButton btnNewButton = new JButton("Conclu\u00EDdo");
		btnNewButton.setBounds(561, 281, 102, 40);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(31, 153, 468, 168);
		contentPane.add(list);



	}

	// Método para voltar ao Menu, ou melhor, fazer ele aparecer novamente...
	public void VoltarMenu(){ 
		MenuPrincipal Menu = new MenuPrincipal();
		Menu.setVisible(true);
		//-------------------------------------------------------------------

	}
}
