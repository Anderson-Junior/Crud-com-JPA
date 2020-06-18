package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.EmailBo;
import classes.Contato;
import classes.Email;
import classes.TipoEmail;

public class TelaAlterarEmail extends JFrame implements MouseListener{
	
	
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	// nome do contato
	private JLabel novo_email;
	private JTextField txtnovo_email;

	// numero do contato

	// tipo de contato: pessoal, comercial
	private JLabel idtipo_email;
	private JTextField txtidtipo_email;

	private JLabel titulo;

	private JButton atualizar;
	private JButton voltar;

	private JLabel idcontato;
	private JTextField idcont;
	
	private JLabel id_email;
	private JTextField txtid_email;

	public TelaAlterarEmail() {
		super("TELA ATUALIZAR EMAIL");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("ATUALIZAÇÃO DE EMAIL");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idcontato = new JLabel("DIGITE O ID DO CONTATO QUE DESEJA ATUALIZAR");
		idcontato.setBounds(10, 0, 374, 34);
		idcontato.setForeground(Color.black);
		idcont = new JTextField(3);
		idcont.setBounds(10, 25, 243, 34);
		
		id_email = new JLabel("DIGITE O ID DO EMAIL QUE DESEJA ATUALIZAR");
		id_email.setBounds(10, 70, 374, 34);
		txtid_email = new JTextField(30);
		txtid_email.setBounds(10, 94, 243, 34);
		
		novo_email = new JLabel("NOVO EMAIL");
		novo_email.setBounds(10, 135, 374, 34);
		txtnovo_email = new JTextField(30);
		txtnovo_email.setBounds(10, 159, 243, 34);

		idtipo_email = new JLabel("ID TIPO DE EMAIL");
		idtipo_email.setBounds(10, 204, 364, 34);
		txtidtipo_email = new JTextField(30);
		txtidtipo_email.setBounds(10, 230, 243, 34);


		/// botao salvar
		atualizar = new JButton("ATUALIZAR");
		atualizar.setBackground(Color.GREEN);
		atualizar.setForeground(Color.BLACK);
		atualizar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		atualizar.addMouseListener(this);
		
		voltar = new JButton("VOLTAR");
		voltar.setBackground(Color.green);
		voltar.setForeground(Color.black);
		voltar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		voltar.addMouseListener(this);
		
		painel_titulo.add(titulo);
		getContentPane().add(painel_titulo, BorderLayout.NORTH);
		painel.setLayout(null);
		
		painel.add(idcontato);
		painel.add(idcont);
		
		painel.add(id_email);
		painel.add(txtid_email);
		
		painel.add(novo_email);
		painel.add(txtnovo_email);

		painel.add(idtipo_email);
		painel.add(txtidtipo_email);
		
		getContentPane().add(painel, BorderLayout.CENTER);
		
		
		painel2 = new JPanel();
		painel2.setBackground(Color.yellow);
		painel2.add(atualizar);
		painel2.add(voltar);

		
		getContentPane().add(painel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(true);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == atualizar) {
			
			Email email = new Email();
			TipoEmail tipoe = new TipoEmail();
			Contato cont = new Contato();
			
			
			cont.setId(Integer.parseInt(idcont.getText()));
			email.setEmail(txtnovo_email.getText());
			email.setId(Integer.parseInt(txtid_email.getText()) );
			
			tipoe.setId(Integer.parseInt(txtidtipo_email.getText()));
			email.setTipo_email(tipoe);;
			email.setId_contato(cont);
			
			String bo;
			try {
				bo = new EmailBo().alterar(email);
				JOptionPane.showMessageDialog(null, "EMAIL ATUALIZAR COM SUCESSO");
			}
			catch(Exception ab) {
				JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR EMAIL");
			}
			
		}
		else if(e.getSource() == voltar) {
			dispose();
			new TelaEmail();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		TelaAlterarEmail tela = new TelaAlterarEmail();
	}
}
