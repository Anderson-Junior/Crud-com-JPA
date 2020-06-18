package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.ContatoBo;
import classes.Contato;
import classes.TipoContato;

public class TelaDeletarContato extends JFrame implements MouseListener{
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	private JLabel titulo;

	private JButton deletar;
	private JButton voltar;

	private JLabel idcontato;
	private JTextField idcont;

	public TelaDeletarContato() {
		super("TELA DELETAR CONTATO");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("DELETAR CONTATO");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idcontato = new JLabel("DIGITE O ID DO CONTATO QUE DESEJA DELETAR");
		idcontato.setForeground(Color.black);
		
		idcont = new JTextField(3);

		/// botao salvar
		deletar = new JButton("DELETAR CONTATO");
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
		
		
	
		painel.setLayout(new GridLayout(2,1));
		painel.add(idcontato);
		painel.add(idcont);
	
		getContentPane().add(painel, BorderLayout.CENTER);
		
		
		painel2 = new JPanel();
		painel2.setBackground(Color.yellow);
		painel2.add(deletar);
		painel2.add(voltar);

		
		getContentPane().add(painel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 500);
		this.setResizable(true);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == deletar) {
			Contato cont = new Contato();
			cont.setId(Integer.parseInt(idcont.getText()));
			try {
				String bo = new ContatoBo().deletar(cont);
				JOptionPane.showMessageDialog(null, "CONTATO DELETADO COM SUCESSO!");
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, "ERRO AO DELETAR CONTATO");
			}
		}
		else if(e.getSource() == voltar) {
			dispose();
			new TelaPrincipal();
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

		TelaDeletarContato tela = new TelaDeletarContato();

	}
}
