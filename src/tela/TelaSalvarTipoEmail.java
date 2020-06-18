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

public class TelaSalvarTipoEmail extends JFrame implements MouseListener{
	// painel
	private JPanel painel;
	private JPanel painel_titulo;
	private JPanel painel2;

	// nome do contato
	private JLabel nometipo_email;
	private JTextField txttipo_email;

	private JLabel titulo;

	private JButton btnSalvar;
	private JButton voltar;

	public TelaSalvarTipoEmail() {
				super("TELA SALVAR TIPO DE EMAIL");

				painel = new JPanel();

				painel_titulo = new JPanel();
				painel_titulo.setBackground(Color.yellow);

				titulo = new JLabel("SALVAR TIPO DE EMAIL");
				titulo.setForeground(Color.black);
				titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

				nometipo_email = new JLabel("NOME TIPO EMAIL");
				nometipo_email.setBounds(10, 11, 357, 25);
				txttipo_email = new JTextField(30);
				txttipo_email.setBounds(10, 33, 203, 25);

				/// botao salvar
				btnSalvar = new JButton("SALVAR");
				btnSalvar.setBackground(Color.GREEN);
				btnSalvar.setForeground(Color.BLACK);
				btnSalvar.setFont(new Font("Arial Black", Font.PLAIN, 20));
				btnSalvar.addMouseListener(this);
				
				voltar = new JButton("VOLTAR");
				voltar.setBackground(Color.green);
				voltar.setForeground(Color.black);
				voltar.setFont(new Font("Arial Black", Font.PLAIN, 20));
				voltar.addMouseListener(this);
				
				painel_titulo.add(titulo);
				getContentPane().add(painel_titulo, BorderLayout.NORTH);
				painel.setLayout(null);
				painel.add(nometipo_email);
				painel.add(txttipo_email);


				getContentPane().add(painel, BorderLayout.CENTER);
				
				
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnSalvar) {
			
			TipoEmail tipo = new TipoEmail();
			tipo.setNome(txttipo_email.getText());			
			
			String bo;
			try {
				bo = new TipoEmailBo().salvar(tipo);
				JOptionPane.showMessageDialog(null, "TIPO DE EMAIL SALVO COM SUCESSO");
				
			}
			catch(Exception a ) {
				JOptionPane.showMessageDialog(null, "ERRO AO SALVAR TIPO DE EMAIL");
			}
			
			
			
		}
		else if(e.getSource() == voltar) {
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

		TelaSalvarTipoEmail tela = new TelaSalvarTipoEmail();

	}
}
