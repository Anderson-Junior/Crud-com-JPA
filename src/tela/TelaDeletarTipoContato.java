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

import classes.TipoContato;
import dao.GenericDao;

public class TelaDeletarTipoContato extends JFrame implements MouseListener{
	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	private JLabel titulo;

	private JButton deletar;
	private JButton voltar;

	private JLabel idtipo_contato;
	private JTextField idtipo_cont;

	public TelaDeletarTipoContato() {
		super("TELA DELETAR TIPO CONTATO");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("DELETAR TIPO CONTATO");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idtipo_contato = new JLabel("DIGITE O ID DO TIPO CONTATO QUE DESEJA DELETAR");
		idtipo_contato.setBounds(38, 11, 314, 39);
		idtipo_contato.setForeground(Color.black);
		
		 idtipo_cont = new JTextField(3);
		 idtipo_cont.setBounds(38, 41, 113, 27);

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
		painel.add(idtipo_contato);
		painel.add(idtipo_cont);
	
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
		if(e.getSource()==deletar) {
			
			TipoContato tipo = new TipoContato();
			tipo.setId(Integer.parseInt(idtipo_cont.getText()));
			
			try {
				GenericDao<TipoContato> dao = new GenericDao<TipoContato>();
				dao.remove(TipoContato.class, tipo.getId());
				JOptionPane.showMessageDialog(null, "TIPO CONTATO DELETADO COM SUCESSO");
			
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, "ERRO AO DELETAR TIPO CONTATO");
			}
		}
		else if(e.getSource()==voltar) {
			dispose();
			new TelaTipoContato();
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

		TelaDeletarTipoContato tela = new TelaDeletarTipoContato();

	}
}
