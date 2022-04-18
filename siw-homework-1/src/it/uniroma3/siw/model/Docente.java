package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private LocalDate dataNascita;
	
	private String luogoNascita;
	
	private int partitaIva;
	
	/* Fetch (lazy): Se carico un docente devo caricare i corsi solo se richiesto; altrimenti se volessi, ad esempio, sapere
	 *       		 il nome di un docente dovrei caricare anche tutti i corsi tenuti dal docente e cio' rallenterebbe il sistema. */
	/* Cascade: Ad un docente sono relativi piu' corsi; quindi quando creo il docente creo a sua volta anche i corsi che tiene (se non gia' presenti).
	 * 			Se cancello il docente, quest'ultimo non terra' piu' i corsi e quindi vanno cancellati anche loro. */
	@OneToMany(mappedBy = "docente", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Corso> corsi;
	
	
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
	
	public int getPartitaIva() {
		return partitaIva;
	}
	
	public void setPartitaIva(int partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
}
