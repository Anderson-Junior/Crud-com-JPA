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

public class TelaAlterarTipoContato extends JFrame implements MouseListener{

	private JPanel painel_titulo; // titulo
	private JPanel painel; // centro

	private JPanel painel2; // botao salvar

	// nome do contato
	private JLabel nometipo_contato;
	private JTextField txtnometipo_cont;

	private JLabel titulo;

	private JButton atualizar;
	private JButton voltar;

	private JLabel idtipo_contato;
	private JTextField idtipo_cont;

	public TelaAlterarTipoContato() {
		super("TELA ALTERAR TIPO CONTATO");

		painel = new JPanel();

		painel_titulo = new JPanel();
		painel_titulo.setBackground(Color.yellow);
		
		titulo = new JLabel("ATUALIZAÇÃO DE TIPO CONTATOS");
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

		idtipo_contato = new JLabel("DIGITE O ID DO TIPO CONTATO QUE DESEJA ATUALIZAR");
		idtipo_contato.setBounds(10, 0, 350, 25);
		idtipo_contato.setForeground(Color.black);
		
		idtipo_cont = new JTextField(3);
		idtipo_cont.setBounds(10, 24, 162, 25);
		
		nometipo_contato = new JLabel("NOVO NOME DO TIPO CONTATO");
		nometipo_contato.setBounds(10, 66, 374, 25);
		txtnometipo_cont = new JTextField(30);
		txtnometipo_cont.setBounds(10, 87, 162, 25);


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
		
		painel.add(idtipo_contato);
		painel.add(idtipo_cont);
		
		painel.add(nometipo_contato);
		painel.add(txtnometipo_cont);
		
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
		if(e.getSource()==atualizar) {
			
			TipoContato tipo = new TipoContato();
			tipo.setId(Integer.parseInt(idtipo_cont.getText()));
			tipo.setNome(txtnometipo_cont.getText());
			
			String bo;
			try {
				bo = new TipoContatoBo().alterar(tipo);
				JOptionPane.showMessageDialog(null, "NOVO TIPO DE CONTATO ATUALIZADO COM SUCESSO");
				
				
			}
			catch(Exception aa) {
				JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR O NOVO TIPO DE CONTATO");
			}
			
		}
		else if(e.getSource() == voltar) {
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

		TelaAlterarTipoContato tela = new TelaAlterarTipoContato();

	}
}
