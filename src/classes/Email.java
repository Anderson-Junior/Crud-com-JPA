package classes;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;

@Entity

public class Email {

	private String email;
	
	@ManyToOne()
	@JoinColumn(name="id_tipo_email")
	private TipoEmail tipo_email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="id_contato")
	private Contato id_contato;
	
	private LocalDate data;

	public Email() {

	}


	

	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public TipoEmail getTipo_email() {
		return tipo_email;
	}




	public void setTipo_email(TipoEmail tipo_email) {
		this.tipo_email = tipo_email;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Contato getId_contato() {
		return id_contato;
	}




	public void setId_contato(Contato id_contato) {
		this.id_contato = id_contato;
	}




	public LocalDate getData() {
		return data;
	}




	public void setData(LocalDate data) {
		this.data = data;
	}




	

	public Email(String email, TipoEmail tipo_email, int id, Contato id_contato, LocalDate data) {
		super();
		this.email = email;
		this.tipo_email = tipo_email;
		this.id = id;
		this.id_contato = id_contato;
		this.data = data;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((id_contato == null) ? 0 : id_contato.hashCode());
		result = prime * result + ((tipo_email == null) ? 0 : tipo_email.hashCode());
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
		Email other = (Email) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (id_contato == null) {
			if (other.id_contato != null)
				return false;
		} else if (!id_contato.equals(other.id_contato))
			return false;
		if (tipo_email == null) {
			if (other.tipo_email != null)
				return false;
		} else if (!tipo_email.equals(other.tipo_email))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Email [email=" + email + ", tipo_email=" + tipo_email + ", id=" + id + ", id_contato=" + id_contato
				+ ", data=" + data + "]";
	}


	

}
