package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TelaPrincipal extends JFrame implements MouseListener{
	
	//paineis
	private JPanel painel;
	private JPanel painelTitulo;
	
	//JLabel "selecione a opcao desejada"
	private JLabel opc;
	private JLabel titulo;
	
	
	//botoes para selcionar oq deseja fazer
	private JButton contato;
	private JButton email;
	private JButton tipocontato;
	private JButton tipoemail;
	
	
	public TelaPrincipal(){
		super("TELA PRINCIPAL");
		
		painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.yellow);
		titulo = new JLabel("SELECIONE A OPÇÃO DESEJADA");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		contato = new JButton("CONTATO");
		contato.setBounds(0, 0, 193, 161);
		contato.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contato.setBackground(Color.green);
		contato.setForeground(Color.black);
		contato.addMouseListener(this);
		
		
		email = new JButton("EMAIL");
		email.setBounds(191, 0, 193, 161);
		email.setFont(new Font("Arial Black", Font.PLAIN, 15));
		email.setBackground(Color.green);
		email.setForeground(Color.black);
		email.addMouseListener(this);
		
		
		tipoemail = new JButton("TIPO EMAIL");
		tipoemail.setBounds(0, 161, 193, 161);
		tipoemail.setFont(new Font("Arial Black", Font.PLAIN, 15));
		tipoemail.setBackground(Color.green);
		tipoemail.setForeground(Color.black);
		tipoemail.addMouseListener(this);
		
		tipocontato = new JButton("TIPO CONTATO");
		tipocontato.setBounds(191, 161, 193, 161);
		tipocontato.setFont(new Font("Arial Black", Font.PLAIN, 15));
		tipocontato.setBackground(Color.green);
		tipocontato.setForeground(Color.black);
		tipocontato.addMouseListener(this);
		
		
		painelTitulo.add(titulo);
		getContentPane().add(painelTitulo, BorderLayout.NORTH);
		
		painel = new JPanel();
		painel.setLayout(null);
		
		painel.add(contato);
		painel.add(email);
		painel.add(tipocontato);
		painel.add(tipoemail);
		
		getContentPane().add(painel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		TelaPrincipal tela = new TelaPrincipal();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == contato) {
			dispose();
			new TelaContato();
		}
		else if(e.getSource()== email) {
			dispose();
			new TelaEmail();
		}
		else if(e.getSource() == tipocontato) {
			dispose();
			new TelaTipoContato();
		}
		else if(e.getSource() == tipoemail) {
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
	
	
	
	
	
}
