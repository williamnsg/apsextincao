import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame 
{
	private JPanel contentPane;
	
	public MenuPrincipal() 
	{
		setResizable(false);
		setTitle("Animais em Perigo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 509);
		setLocationRelativeTo(null); //Abrir frame centralizado

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Animais");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Novo animal");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				NovoAnimal JNovoAnimal = new NovoAnimal();
				JNovoAnimal.setVisible(true);

			}
		});

		mnNewMenu.add(mntmNewMenuItem_1);


		JMenuItem mntmRemoverAnimais = new JMenuItem("Remover animais");
		mnNewMenu.add(mntmRemoverAnimais);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);

		JMenuItem mntmPesquisarAnimal = new JMenuItem("Pesquisar Animal");
		mnOpes.add(mntmPesquisarAnimal);
		mntmPesquisarAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				ListarAnimal JListarAnimal = new ListarAnimal();
				JListarAnimal.setVisible(true);

			}
		});

		JMenu mnAquivos = new JMenu("Aquivo");
		menuBar.add(mnAquivos);

		JMenuItem mnLerArquivoTxt = new JMenuItem("Ler arquivo .txt");
		mnLerArquivoTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				LerArquivoTxt LerArquivoTxt = new LerArquivoTxt();
				LerArquivoTxt.setVisible(true);

			}
		});
		
		mnAquivos.add(mnLerArquivoTxt);

		JMenuItem mntmSalvarEmArquivo = new JMenuItem("Salvar em arquivo .txt");
		mnAquivos.add(mntmSalvarEmArquivo);
		mntmSalvarEmArquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				SalvarArquivoTxt SalvarArquivoTxt = new SalvarArquivoTxt();
				SalvarArquivoTxt.setVisible(true);
			}
		});

		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		getContentPane().setLayout(null);

		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});


	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
