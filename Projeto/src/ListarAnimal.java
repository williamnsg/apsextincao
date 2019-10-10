import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListarAnimal extends JFrame {

	private JPanel contentPane;
	private ListarAnimal self;
	private JScrollPane scrollPane;
	private JTable tabela;

	public ListarAnimal() {
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadeAnimais = new JLabel("Lista de Animais");
		lblListadeAnimais.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblListadeAnimais.setBounds(135, 13, 186, 33);
		contentPane.add(lblListadeAnimais);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 44, 382, 176);
		contentPane.add(scrollPane);
		atualizaTabela();
		
	}
	public void atualizaTabela() 
	{
		tabela = new JTable();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		String [] colunas = {"ID", "Classe", "Nome", "Nome cientifico","Ano de extinção","País pertencente","Descricao"};
		modelo.setColumnIdentifiers(colunas);
		
		BD.connect("database.db3");
		ResultSet res = BD.query("Select * from Animais");
				
			try {
				while(res.next()) 
				{
					int id_animal = res.getInt("id_animal");
					String classe = res.getString("classe");
					String nome = res.getString("nome");
					String nome_cientifico = res.getString("nome_cientifico");
					int ano_extinto = res.getInt("ano_extinto");
					String pais_pertencente = res.getString("pais_pertencente");
					String descricao = res.getString("descricao");
					
					//System.out.println("ID: " +id+ " NOME: " +nome+ " LOGIN: " + login);
					Object[] objects = {id_animal,classe,nome,nome_cientifico,ano_extinto,pais_pertencente,descricao };
					modelo.addRow(objects);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			scrollPane.setViewportView(tabela);
			}
	
	public static void main(String[] args) 
	{
		ListarAnimal la = new ListarAnimal();
		la.setVisible(true);
	}
}