import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class JanelaListar extends JFrame 
{

	private JPanel contentPane;

	public JanelaListar() 
	{
		setTitle("Listar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 982, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
	
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(new Color(153, 255, 255));
		panelLista.setBounds(0, 0, 978, 113);
		contentPane.add(panelLista);
		panelLista.setLayout(null);
		
		JLabel lblListagemDeAnimais = new JLabel("Lista de animais");
		lblListagemDeAnimais.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 30));
		lblListagemDeAnimais.setBounds(399, 21, 266, 49);
		panelLista.add(lblListagemDeAnimais);
		
		JPanel panelCorpoLista = new JPanel();
		panelCorpoLista.setBackground(new Color(204, 255, 255));
		panelCorpoLista.setBounds(0, 113, 978, 538);
		contentPane.add(panelCorpoLista);
		panelCorpoLista.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 471, 407);
		panelCorpoLista.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(496, 51, 472, 407);
		panelCorpoLista.add(scrollPane_1);
		
		JButton btnPush = new JButton("PUSH");
		btnPush.setBounds(95, 487, 89, 23);
		panelCorpoLista.add(btnPush);
		
		JButton btnPop = new JButton("POP");
		btnPop.setBounds(278, 487, 89, 23);
		panelCorpoLista.add(btnPop);
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.setBounds(587, 487, 89, 23);
		panelCorpoLista.add(btnInserir);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setBounds(790, 487, 104, 23);
		panelCorpoLista.add(btnRemover);
		
		JLabel lblFila = new JLabel("Fila");
		lblFila.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 22));
		lblFila.setBounds(716, 11, 56, 29);
		panelCorpoLista.add(lblFila);
		
		JLabel lblPilha = new JLabel("Pilha");
		lblPilha.setFont(new Font("Lato", Font.BOLD | Font.ITALIC, 22));
		lblPilha.setBounds(214, 11, 82, 29);
		panelCorpoLista.add(lblPilha);
	}
}
