package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private LocalDate dataNascita;
	
	private String luogoNascita;
	
	private String matricola;
	
	private String email;
	
	/* Fetch (lazy): Se carico un allievo devo caricare i corsi solo se richiesto; altrimenti se volessi, ad esempio, sapere
	 *       		 il nome di un allievo dovrei caricare anche tutti i corsi a cui fa parte e cio' rallentrebbe il sistema. */
	/* Cascade: Essendo una relazione ManyToMany conviene non inserire un evento a cascata, dato che andrebbe a rallentare il sistema se,
	 * 	 		ad esempio, andassi a fare la PERSIST (mi controllerebbe tutti i corsi). */
	@ManyToMany(mappedBy = "allievi")
	private List<Corso> corsi;
	
	/* Fetch (eager): Se carico un allievo posso caricare tutte le sue societa', essendocene solo una. */
	/* Cascade: Un allievo e' dipendente di una societa'; quindi se creo l'allievo creo a sua volta anche la societa' di cui fa parte
	 * 			(se non gia' presente). */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Societa societa;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	
}
