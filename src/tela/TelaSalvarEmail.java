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
import bo.EmailBo;
import bo.TipoEmailBo;
import classes.Contato;
import classes.Email;
import classes.TipoEmail;

public class TelaSalvarEmail extends JFrame{
	// painel
		private JPanel painel;
		private JPanel painel_titulo;
		private JPanel painel2;
		
		// nome do contato
		private JLabel email;
		private JTextField txtemail;
		
		
		private JLabel titulo;

		private JButton btnSalvar;
		private JButton voltar;
		
		private JComboBox tipoEmailBox;
		private JComboBox contatoBox;
		
		private JLabel data;
		
		public TelaSalvarEmail() {
			super("TELA CADASTRO DE EMAILS");

			painel = new JPanel();

			painel_titulo = new JPanel();
			painel_titulo.setBackground(Color.yellow);

			titulo = new JLabel("CADASTRO DE EMAIL");
			titulo.setForeground(Color.black);
			titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

			email = new JLabel("E-EMAIL:");
			email.setBounds(10, 0, 54, 25);
			txtemail = new JTextField(30);
			txtemail.setBounds(10, 25, 234, 25);


			/// botao salvar
			btnSalvar = new JButton("SALVAR");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salvarEmail();
				}
			});
			btnSalvar.setBackground(Color.GREEN);
			btnSalvar.setForeground(Color.BLACK);
			btnSalvar.setFont(new Font("Arial Black", Font.PLAIN, 20));
			
			
			voltar = new JButton("VOLTAR");
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new TelaEmail();
				}
			});
			voltar.setBackground(Color.green);
			voltar.setForeground(Color.black);
			voltar.setFont(new Font("Arial Black", Font.PLAIN, 20));
			
			
			painel_titulo.add(titulo);
			getContentPane().add(painel_titulo, BorderLayout.NORTH);
			painel.setLayout(null);
			
			painel.add(email);
			painel.add(txtemail);
			
			getContentPane().add(painel, BorderLayout.CENTER);
			
			tipoEmailBox = new JComboBox();
			carregarComboTipoEmail();
			tipoEmailBox.setBounds(98, 77, 146, 22);
			painel.add(tipoEmailBox);
			
			JLabel lblSelecioneOTipo = new JLabel("Tipo e-mail");
			lblSelecioneOTipo.setBounds(10, 81, 114, 14);
			painel.add(lblSelecioneOTipo);
			
			JLabel lblSelecioneOContato = new JLabel("Contato");
			lblSelecioneOContato.setBounds(10, 135, 105, 14);
			painel.add(lblSelecioneOContato);
			
			contatoBox = new JComboBox();
			carregarComboContato();
			contatoBox.setBounds(98, 131, 146, 22);
			painel.add(contatoBox);
			
			data = new JLabel();
			carregarData();
			data.setBounds(10, 201, 77, 14);
			painel.add(data);
			
			
			painel2 = new JPanel();
			painel2.setBackground(Color.yellow);
			painel2.add(btnSalvar);
			painel2.add(voltar);

			
			getContentPane().add(painel2, BorderLayout.SOUTH);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400, 400);
			this.setResizable(true);
			this.setVisible(true);

		}
		
		public void salvarEmail() {	
			
			Contato contato = (Contato)contatoBox.getSelectedItem();
			TipoEmail tipo = (TipoEmail)tipoEmailBox.getSelectedItem();
			
			DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = LocalDate.now();
			
			Email email = new Email();
			email.setEmail(this.txtemail.getText());
			email.setData(data);
			email.setId_contato(contato);
			email.setTipo_email(tipo);
			
			try {
				new EmailBo().salvar(email);
				JOptionPane.showMessageDialog(null, "EMAIL SALVO");
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		
		public void carregarComboTipoEmail() {
			try {
				List<TipoEmail> lista = new TipoEmailBo().listar();
				for(TipoEmail tipo : lista) {
					tipoEmailBox.addItem(tipo);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		public void carregarComboContato() {
			try {
				List<Contato> lista = new ContatoBo().listar("","","","");
				for(Contato cont : lista) {
					contatoBox.addItem(cont);
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

			TelaSalvarEmail tela = new TelaSalvarEmail();
		}
}
