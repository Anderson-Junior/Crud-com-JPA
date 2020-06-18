package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.ContatoBo;
import classes.Contato;

public class ConsultarContato extends JFrame {

	private JPanel contentPane;
	private JTextField TxtNome;
	private JTextField TxtDataInicial;
	private JTextField TxtDataFinal;
	private JTextField txtValorInicial;
	private JTextField txtValorFinal;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarContato frame = new ConsultarContato();
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
	public ConsultarContato() {
		setTitle("Consultar Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 11, 48, 14);
		contentPane.add(lblNome);
		
		TxtNome = new JTextField();
		TxtNome.setBounds(24, 24, 148, 20);
		contentPane.add(TxtNome);
		TxtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data inicial");
		lblNewLabel.setBounds(24, 55, 93, 14);
		contentPane.add(lblNewLabel);
		
		TxtDataInicial = new JTextField();
		TxtDataInicial.setBounds(24, 68, 148, 20);
		contentPane.add(TxtDataInicial);
		TxtDataInicial.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("Data final");
		lblDataFinal.setBounds(24, 99, 48, 14);
		contentPane.add(lblDataFinal);
		
		TxtDataFinal = new JTextField();
		TxtDataFinal.setBounds(24, 112, 148, 20);
		contentPane.add(TxtDataFinal);
		TxtDataFinal.setColumns(10);
		
		JLabel lblValorInicial = new JLabel("Valor inicial");
		lblValorInicial.setBounds(24, 141, 93, 14);
		contentPane.add(lblValorInicial);
		
		txtValorInicial = new JTextField();
		txtValorInicial.setBounds(24, 155, 148, 20);
		contentPane.add(txtValorInicial);
		txtValorInicial.setColumns(10);
		
		JLabel lblValorFinal = new JLabel("Valor final");
		lblValorFinal.setBounds(24, 186, 78, 14);
		contentPane.add(lblValorFinal);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setBounds(24, 199, 148, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(208, 55, 196, 195);
		contentPane.add(table);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.green);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisar.setBounds(208, 23, 105, 23);
		contentPane.add(btnPesquisar);
	}
	
	public void pesquisar() {
		DefaultTableModel modelo =(DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		try {
			/*
			List<Contato> lista = new ContatoBo().listar(this.TxtDataInicial.getText(), this.TxtDataFinal.getText(),
					Double.parseDouble(this.txtValorInicial.getText()), Double.parseDouble(this.txtValorFinal.getText()),this.TxtNome.getText(),"consultar");
					*/
			List<Contato> lista = new ContatoBo().listar(this.TxtDataInicial.getText(), this.TxtDataFinal.getText() ,this.TxtNome.getText(),"consultar");
			for(Contato contato : lista) {
				modelo.addRow(new Object[] {contato.getNome()});
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
