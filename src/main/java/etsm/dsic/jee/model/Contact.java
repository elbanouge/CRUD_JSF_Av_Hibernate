package etsm.dsic.jee.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the contacts database table.
 * 
 */
@Entity
@Table(name = "contacts")
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact")
	private int id_contact;

	private String name;

	private String adresse;

	private String email;

	private String tel;

	public Contact() {
	}

	public int getId_contact() {
		return id_contact;
	}

	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}