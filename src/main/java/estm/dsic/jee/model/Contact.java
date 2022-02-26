package estm.dsic.jee.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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

	private int id_us;

	public Contact() {
	}

	public Contact(int id_contact, String name, String adresse, String email, String tel, int id_us) {
		this.id_contact = id_contact;
		this.name = name;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.id_us = id_us;
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

	public int getId_us() {
		return id_us;
	}

	public void setId_us(int id_us) {
		this.id_us = id_us;
	}

	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + ", name=" + name + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", id_us=" + id_us + "]";
	}
}