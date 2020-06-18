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

import bo.TipoContatoBo;
import classes.TipoContato;
import dao.GenericDao;

public class TelaSalvarTipoContato extends JFrame implements MouseListener{
	// painel
	private JPanel painel;
	private JPanel painel_titulo;
	private JPanel painel2;

	// nome do contato
	private JLabel nome_contato;
	private JTextField txtnome_cont;

	private JLabel titulo;

	private JButton btnSalvar;
	private JButton voltar;

	public TelaSalvarTipoContato() {
			super("TELA SALVAR TIPO DE CONTATO");

			painel = new JPanel();

			painel_titulo = new JPanel();
			painel_titulo.setBackground(Color.yellow);

			titulo = new JLabel("SALVAR TIPO DE CONTATO");
			titulo.setForeground(Color.black);
			titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

			nome_contato = new JLabel("NOME:");
			txtnome_cont = new JTextField(30);

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

			painel.setLayout(new GridLayout(11, 2));
			painel.add(nome_contato);
			painel.add(txtnome_cont);


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
			
			TipoContato tipo = new TipoContato();
			tipo.setNome(txtnome_cont.getText());
			
			
			try {
				GenericDao<TipoContato> gene = new GenericDao<TipoContato>();
				gene.saveOrUpdate(tipo);
				
				JOptionPane.showMessageDialog(null, "TIPO CONTATO SALVADO COM SUCESSO!");
				
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, "ERRO AO SALVAR TIPO CONTATO");
			}
			
		}
		
		else if (e.getSource() == voltar) {
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

		TelaSalvarTipoContato tela = new TelaSalvarTipoContato();

	}

}
