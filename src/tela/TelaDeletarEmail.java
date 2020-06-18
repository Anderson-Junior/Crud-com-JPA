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
import classes.Email;

public class TelaDeletarEmail extends JFrame implements MouseListener{
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	private JLabel titulo;

	private JButton deletar;
	private JButton voltar;

	private JLabel id_email;
	private JTextField txtid_email;

	public TelaDeletarEmail() {
		super("TELA DELETAR EMAIL");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("DELETAR CONTATO");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		id_email = new JLabel("DIGITE O ID DO EMAIL QUE DESEJA DELETAR");
		id_email.setBounds(84, 11, 244, 48);
		id_email.setForeground(Color.black);
		
		txtid_email = new JTextField(3);
		txtid_email.setBounds(127, 52, 126, 30);

		/// botao salvar
		deletar = new JButton("DELETAR EMAIL");
		deletar.setBackground(Color.GREEN);
		deletar.setForeground(Color.BLACK);
		deletar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		deletar.addMouseListener(this);
		
		voltar = new JButton("VOLTAR");
		voltar.setBackground(Color.green);
		voltar.setForeground(Color.black);
		voltar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		voltar.addMouseListener(this);
		
		painel_titulo.add(titulo);
		getContentPane().add(painel_titulo, BorderLayout.NORTH);
		painel.setLayout(null);
		painel.add(id_email);
		painel.add(txtid_email);
	
		getContentPane().add(painel, BorderLayout.CENTER);
		
		
		painel2 = new JPanel();
		painel2.setBackground(Color.yellow);
		painel2.add(deletar);
		painel2.add(voltar);

		
		getContentPane().add(painel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(true);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == deletar) {
			
			Email email = new Email();
			email.setId(Integer.parseInt(txtid_email.getText()));
			
			String bo;
			try {
				bo = new EmailBo().deletar(email);
				JOptionPane.showMessageDialog(null, "EMAL DELETADO COM SUCESSO");
				
			}
			catch(Exception aa) {
				JOptionPane.showMessageDialog(null, "ERRO AO DELETAR EMAIL");
			}
			
			
		}
		else if(e.getSource()==voltar) {
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
		
		TelaDeletarEmail tela = new TelaDeletarEmail();
		
	}
}


