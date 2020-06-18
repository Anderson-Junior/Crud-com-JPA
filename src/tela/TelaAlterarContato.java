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

import bo.ContatoBo;
import classes.Contato;
import classes.TipoContato;

public class TelaAlterarContato extends JFrame implements MouseListener {
	// painel
	
		private JPanel painel_titulo; //titulo
		private JPanel painel;       //centro
		
		private JPanel painel2;      //botao salvar
		
		// nome do contato
		private JLabel nome_contato;
		private JTextField txtnome_cont;

		// numero do contato
	

		// tipo de contato: pessoal, comercial
		private JLabel tipo_contato;
		private JTextField txttipo_contato;

	
		private JLabel titulo;

		private JButton atualizar;
		private JButton voltar;
		
		private JLabel idcontato;
		private JTextField idcont;
		
		
		
		public TelaAlterarContato() {
			super("TELA ATUALIZAR CONTATO");

			painel = new JPanel();

			painel_titulo = new JPanel();
			painel_titulo.setBackground(Color.yellow);
			
			titulo = new JLabel("ATUALIZAÇÃO DE CONTATOS");
			titulo.setForeground(Color.black);
			titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));

			idcontato = new JLabel("DIGITE O ID DO CONTATO QUE DESEJA ATUALIZAR");
			idcontato.setForeground(Color.black);
			
			idcont = new JTextField(3);
			
			nome_contato = new JLabel("NOVO NOME:");
			txtnome_cont = new JTextField(30);

			tipo_contato = new JLabel("ID TIPO DE CONTATO:");
			txttipo_contato = new JTextField(30);


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

			painel.setLayout(new GridLayout(11, 2));
			
			painel.add(idcontato);
			painel.add(idcont);
			
			painel.add(nome_contato);
			painel.add(txtnome_cont);

			painel.add(tipo_contato);
			painel.add(txttipo_contato);
			
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
				
				Contato cont = new Contato();
				cont.setId(Integer.parseInt(idcont.getText()));
				cont.setNome(txtnome_cont.getText());
				cont.setTipo(new TipoContato(null,Integer.parseInt(txttipo_contato.getText()) ,null));
				
				try {
					String bo = new ContatoBo().alterar(cont);
					JOptionPane.showMessageDialog(null, "CONTATO ALTERADO COM SUCESSO!");
				}
				catch(Exception A) {
					JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR CONTATO");
				}
			}
			else if (e.getSource() == voltar) {
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

			TelaAlterarContato tela = new TelaAlterarContato();

		}
}
