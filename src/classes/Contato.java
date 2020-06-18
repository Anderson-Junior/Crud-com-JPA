package classes;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 

public class Contato {
	
	
	private String nome;
	
	private double valor;
	
	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}

	@ManyToOne()
	@JoinColumn(name = "TIPO") 
	private TipoContato tipo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_contato")
	private List<Email> email_id;
	
	private LocalDate data;
	 
	
	public Contato() {
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Contato other = (Contato) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}


	public Contato(String nome, double valor, TipoContato tipo, int id, List<Email> email_id, LocalDate data) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		this.id = id;
		this.email_id = email_id;
		this.data = data;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public TipoContato getTipo() {
		return tipo;
	}


	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Email> getEmail_id() {
		return email_id;
	}


	public void setEmail_id(List<Email> email_id) {
		this.email_id = email_id;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return nome;
	}


}
