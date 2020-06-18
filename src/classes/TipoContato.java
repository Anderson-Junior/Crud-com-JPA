package classes;

import java.util.List;

import javax.persistence.*;

@Entity

public class TipoContato implements EntityBase{
	
	
	private String nome;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_CONTATO")
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
	private List<Contato> contato_id;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoContato other = (TipoContato) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public TipoContato() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Contato> getContato_id() {
		return contato_id;
	}
	public void setContato_id(List<Contato> contato_id) {
		this.contato_id = contato_id;
	}
	
	public TipoContato(String nome, int id, List<Contato> contato_id) {
		super();
		this.nome = nome;
		this.id = id;
		this.contato_id = contato_id;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	
	
}
