import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class JanelaOrdenacao extends JFrame 
{
	private static JTable tabelaSelection;
	private static DefaultTableModel modeloSelection;
	private static JScrollPane scrollPaneSelection;
	private static JTable tabelaBubble;
	private static DefaultTableModel modeloBubble;
	private static JScrollPane scrollPaneBubble;
	private JPanel contentPane;
	private static SelectionSort selection;
	private static BubbleSort bubble;
	private static String[] vetor;
	private static String[] selectionOrdenado;
	private static String[] bubbleOrdenado;
 	private ResultSet rs;
	
	public JanelaOrdenacao() 
	{		
		selection = new SelectionSort();
		bubble = new BubbleSort();
		tabelaSelection = new JTable();
		tabelaBubble = new JTable();
		
		DB.connect("database.db3");
		rs = DB.query("select count(nome_animal) as qntanimais from Animais");
		try 
		{
			vetor = new String[rs.getInt("qntanimais")];
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 982, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 978, 113);
		contentPane.add(panel);
		
		JLabel lblOrdenarOsDados = new JLabel("Ordenar os dados");
		lblOrdenarOsDados.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		lblOrdenarOsDados.setBounds(399, 21, 266, 49);
		panel.add(lblOrdenarOsDados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBounds(0, 107, 966, 534);
		contentPane.add(panel_1);
		
		scrollPaneSelection = new JScrollPane();
		scrollPaneSelection.setBounds(10, 51, 471, 318);
		panel_1.add(scrollPaneSelection);
		
		scrollPaneBubble = new JScrollPane();
		scrollPaneBubble.setBounds(496, 51, 459, 318);
		panel_1.add(scrollPaneBubble);
		
		JLabel lblInsertionSort = new JLabel("Bubble Sort");
		lblInsertionSort.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblInsertionSort.setBounds(639, 11, 194, 29);
		panel_1.add(lblInsertionSort);
		
		JLabel lblBubblesort = new JLabel("Selection Sort");
		lblBubblesort.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblBubblesort.setBounds(170, 11, 181, 29);
		panel_1.add(lblBubblesort);
		
		JTextPane bubbleTime = new JTextPane();
		bubbleTime.setEditable(false);
		bubbleTime.setBounds(65, 393, 75, 20);
		panel_1.add(bubbleTime);
		
		JLabel lblBubbleTime = new JLabel("Tempo:");
		lblBubbleTime.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBubbleTime.setBounds(10, 393, 75, 20);
		panel_1.add(lblBubbleTime);
		
		JLabel labelnsertion = new JLabel("Tempo:");
		labelnsertion.setFont(new Font("Arial", Font.PLAIN, 16));
		labelnsertion.setBounds(496, 393, 75, 20);
		panel_1.add(labelnsertion);
		
		JTextPane insertionTime = new JTextPane();
		insertionTime.setEditable(false);
		insertionTime.setBounds(553, 393, 75, 20);
		panel_1.add(insertionTime);
		
		puxarBanco();
		selectionOrdenado = selection.selectionSort(vetor);
		bubble.setVetor(vetor);
		bubbleOrdenado = bubble.getVetor();
		listarSelection();
		listarBubble();
	}
	
	public static void listarSelection() 
	{		
		modeloSelection = (DefaultTableModel) tabelaSelection.getModel();
		String[] colunas = {"Nome"};
		modeloSelection.setColumnIdentifiers(colunas);
		for(int i=0;i<vetor.length;i++)
		{
			Object[] objects = {selectionOrdenado[i]};
			modeloSelection.addRow(objects);
		}	
		
		scrollPaneSelection.setViewportView(tabelaSelection);
	}
	
	public static void listarBubble() 
	{		
		modeloBubble = (DefaultTableModel) tabelaBubble.getModel();
		String[] colunas = {"Nome"};
		modeloBubble.setColumnIdentifiers(colunas);
		for(int i=0;i<vetor.length;i++)
		{
			Object[] objects = {bubbleOrdenado[i]};
			modeloBubble.addRow(objects);
		}	
		
		scrollPaneBubble.setViewportView(tabelaBubble);
	}
	
	public void puxarBanco() 
	{
		int i=0;
		DB.connect("database.db3");
		ResultSet res = DB.query("select * from Animais;");
		
		try {
			while(res.next()) 
			{
				String nome = res.getString("nome_animal");
				criarVetor(nome,i);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static String[] criarVetor(String aux, int num) 
	{
		vetor[num] = aux;
		return vetor;
	}
}
