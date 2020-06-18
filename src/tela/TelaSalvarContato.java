package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.ContatoBo;
import bo.TipoContatoBo;
import classes.Contato;
import classes.TipoContato;

public class TelaSalvarContato extends JFrame {

	// painel
	private JPanel painel;
	private JPanel painel_titulo;
	private JPanel painel2;
	
	// nome do contato
	private JLabel nome_contato;
	private JTextField txtnome_cont;

	// tipo de contato: pessoal, comercial
	private JLabel tipo_contato;

	private JLabel titulo;

	private JButton btnSalvar;
	private JButton voltar;
	
	private JComboBox boxTipoContato;
	private JLabel data;
	private JLabel lblValor;
	private JTextField txtValor;
	
	public TelaSalvarContato() {
		super("TELA CADASTRO DE CONTATOS");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);

		titulo = new JLabel("CADASTRO DE CONTATOS");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		nome_contato = new JLabel("Nome");
		nome_contato.setBounds(10, 21, 183, 21);
		txtnome_cont = new JTextField(30);
		txtnome_cont.setBounds(10, 38, 183, 21);


		tipo_contato = new JLabel("Tipo contato");
		tipo_contato.setBounds(10, 70, 183, 21);
		
		
		painel_titulo.add(titulo);
		getContentPane().add(painel_titulo, BorderLayout.NORTH);
		painel.setLayout(null);
		painel.add(nome_contato);
		painel.add(txtnome_cont);

		painel.add(tipo_contato);
		
		getContentPane().add(painel, BorderLayout.CENTER);
		
		boxTipoContato = new JComboBox();
		carregarComboTipoContato();
		boxTipoContato.setBounds(10, 88, 183, 22);
		painel.add(boxTipoContato);
		
		data = new JLabel();
		carregarData();
		data.setBounds(10, 180, 78, 14);
		painel.add(data);
		
		
				/// botao salvar
				btnSalvar = new JButton("SALVAR");
				btnSalvar.setBounds(116, 225, 163, 37);
				painel.add(btnSalvar);
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvarContato();
					}
				});
				btnSalvar.setBackground(Color.GREEN);
				btnSalvar.setForeground(Color.BLACK);
				btnSalvar.setFont(new Font("Arial Black", Font.PLAIN, 20));
				
				
				voltar = new JButton("CADASTRAR E-MAIL");
				voltar.setBounds(10, 273, 364, 37);
				painel.add(voltar);
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new TelaSalvarEmail();
					}
				});
				voltar.setBackground(Color.green);
				voltar.setForeground(Color.black);
				voltar.setFont(new Font("Arial Black", Font.PLAIN, 20));
				
				lblValor = new JLabel("Valor");
				lblValor.setBounds(10, 121, 48, 14);
				painel.add(lblValor);
				
				txtValor = new JTextField();
				txtValor.setBounds(10, 135, 96, 20);
				painel.add(txtValor);
				txtValor.setColumns(10);
		
		
		painel2 = new JPanel();
		painel2.setBackground(Color.yellow);
		painel2.setLayout(null);

		
		getContentPane().add(painel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(true);
		this.setVisible(true);

	}
	
	public void salvarContato() {
		
		TipoContato tipoContato = (TipoContato)boxTipoContato.getSelectedItem();
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate data = LocalDate.now();
		
		Contato contato = new Contato();
		contato.setNome(txtnome_cont.getText());
		contato.setTipo(tipoContato);
		contato.setValor(Double.parseDouble(this.txtValor.getText()));
		contato.setData(data);
		
		try {
			
			new ContatoBo().salvar(contato);
			JOptionPane.showMessageDialog(null, "CONTATO SALVO!");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO AO SALVAR CONTATO");
		}
		
	}
	
	public void carregarComboTipoContato() {
		
		try {
			List<TipoContato> lista = new TipoContatoBo().listar();
			for(TipoContato tipo : lista) {
				boxTipoContato.addItem(tipo);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	public void carregarData() {
		LocalDate data = LocalDate.now();
		String formatada = data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		this.data.setText(formatada);
		
	}
	
	public static void main(String[] args) {

		TelaSalvarContato tela = new TelaSalvarContato();

	}
}
