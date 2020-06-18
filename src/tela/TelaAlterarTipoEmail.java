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

import bo.TipoEmailBo;
import classes.TipoEmail;

public class TelaAlterarTipoEmail extends JFrame implements MouseListener{
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	// nome do contato
	private JLabel nometipo_email;
	private JTextField txtnometipo_email;

	private JLabel titulo;

	private JButton atualizar;
	private JButton voltar;

	private JLabel idtipo_email;
	private JTextField idtp_email;

	public TelaAlterarTipoEmail() {
		super("TELA ALTERAR TIPO EMAIL");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("ATUALIZAÇÃO DE TIPO EMAIL");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idtipo_email = new JLabel("DIGITE O ID DO TIPO EMAIL QUE DESEJA ATUALIZAR");
		idtipo_email.setBounds(10, 0, 374, 25);
		idtipo_email.setForeground(Color.black);
		
		idtp_email = new JTextField(3);
		idtp_email.setBounds(10, 21, 193, 25);
		
		nometipo_email = new JLabel("NOVO NOME DO TIPO EMAIL:");
		nometipo_email.setBounds(10, 50, 374, 25);
		txtnometipo_email = new JTextField(30);
		txtnometipo_email.setBounds(10, 71, 193, 25);


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
		
		painel.add(idtipo_email);
		painel.add(idtp_email);
		
		painel.add(nometipo_email);
		painel.add(txtnometipo_email);
		
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
		if(e.getSource()== atualizar) {
			
			TipoEmail tipo = new TipoEmail();
			
			tipo.setId(Integer.parseInt(idtp_email.getText()));
			tipo.setNome(txtnometipo_email.getText());
			
			String bo;
			try {
				bo = new TipoEmailBo().alterar(tipo);
				JOptionPane.showMessageDialog(null, "TIPO EMAIL ALTERADO COM SUCESSO");
				
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR TIPO EMAIL");
			}
			
		}
		else if(e.getSource()==voltar){
			dispose();
			new TelaTipoEmail();
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

		TelaAlterarTipoEmail tela = new TelaAlterarTipoEmail();

	}
}
