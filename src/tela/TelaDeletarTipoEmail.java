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

public class TelaDeletarTipoEmail extends JFrame implements MouseListener{
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	private JLabel titulo;

	private JButton deletar;
	private JButton voltar;

	private JLabel idtipo_email;
	private JTextField idtipo_e;

	public TelaDeletarTipoEmail() {
		super("TELA DELETAR TIPO EMAIL");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("DELETAR TIPO EMAIL");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idtipo_email = new JLabel("DIGITE O ID DO TIPO EMAIL QUE DESEJA DELETAR");
		idtipo_email.setBounds(63, 11, 307, 43);
		idtipo_email.setForeground(Color.black);
		
		 idtipo_e = new JTextField(3);
		 idtipo_e.setBounds(63, 49, 248, 31);

		/// botao salvar
		deletar = new JButton("DELETAR");
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
		painel.add(idtipo_email);
		painel.add(idtipo_e);
	
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
			
			TipoEmail tipo = new TipoEmail();
			tipo.setId(Integer.parseInt(idtipo_e .getText()));
			
			String bo;
			try {
				bo = new TipoEmailBo().deletar(tipo);
				JOptionPane.showMessageDialog(null, "TIPO EMAIL DELETADO CO SUCESSO");
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, "ERRO AO DELETAR TIPO EMAIL");
			}
			
			
			
		}
		else if(e.getSource()==voltar) {
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

		TelaDeletarTipoEmail tela = new TelaDeletarTipoEmail();

	}
}
