package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import classes.TipoContato;
import dao.GenericDao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaTipoContato extends JFrame implements MouseListener{
	// paineis
	private JPanel painel;
	private JPanel painelTitulo;

	// JLabel "selecione a opcao desejada"
	private JLabel titulo;

	// botoes para selcionar oq deseja fazer
	private JButton salvar;
	private JButton alterar;
	private JButton listar;
	private JButton deletar;

	
	private JFrame f;
	private JButton btnVoltar;
	public TelaTipoContato(){
		super("TELA TIPO CONTATO");
		
		painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.yellow);
		titulo = new JLabel("SELECIONE A OPÇÃO DESEJADA");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		salvar = new JButton("SALVAR NOVO TIPO CONTATO");
		salvar.setBounds(31, 11, 320, 52);
		salvar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		salvar.setBackground(Color.green);
		salvar.setForeground(Color.black);
		salvar.addMouseListener(this);
		
		
		alterar = new JButton("ATUALIZAR TIPO CONTATO");
		alterar.setBounds(31, 74, 320, 52);
		alterar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		alterar.setBackground(Color.green);
		alterar.setForeground(Color.black);
		alterar.addMouseListener(this);
		
		
		listar = new JButton("LISTAR TIPO CONTATOS SALVOS");
		listar.setBounds(31, 137, 320, 52);
		listar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		listar.setBackground(Color.green);
		listar.setForeground(Color.black);
		listar.addMouseListener(this);
		
		deletar = new JButton("DELETAR TIPO CONTATO");
		deletar.setBounds(31, 200, 320, 52);
		deletar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		deletar.setBackground(Color.green);
		deletar.setForeground(Color.black);
		deletar.addMouseListener(this);
		
		
		painelTitulo.add(titulo);
		getContentPane().add(painelTitulo, BorderLayout.NORTH);
		
		painel = new JPanel();
		painel.setLayout(null);
		
		painel.add(salvar);
		painel.add(alterar);
		painel.add(listar);
		painel.add(deletar);
		
		getContentPane().add(painel, BorderLayout.CENTER);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipal();
			}
		});
		btnVoltar.setBounds(146, 288, 89, 23);
		painel.add(btnVoltar);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(true);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == salvar) {
			dispose();
			new TelaSalvarTipoContato();
		} else if (e.getSource() == alterar) {
			dispose();
			new TelaAlterarTipoContato();
		} else if (e.getSource() == listar) {
			try {
				listar();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ERRO AO LISTAR TIPOS EMAIL'S");
			}
		} else if (e.getSource() == deletar) {
			dispose();
			new TelaDeletarTipoContato();
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

public void listar() throws Exception {
		
		f = new JFrame();
		String teste[][];
		String column[] = { "id", "nome" };
		
		List<TipoContato> lista = new GenericDao<TipoContato>().list(TipoContato.class);
		
		teste = new String[lista.size()][2];
		
		for(int i =0; i<lista.size(); i++) {
			teste[i][0] = lista.get(i).getId()+"";
			teste[i][1] = lista.get(i).getNome();
		}
		
		
		
		JTable jt = new JTable(teste, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		f.getContentPane().add(sp);
		f.setSize(750, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {

		TelaTipoContato tela = new TelaTipoContato();

	}
}
