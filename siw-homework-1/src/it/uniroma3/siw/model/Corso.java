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
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private LocalDate dataInizio;
	
	private int durataMesi;
	
	/* Fetch (eager): Se carico un corso posso caricare tutti suoi docenti, essendocene solo uno. */
	/* Cascade: Un corso e' tenuto da un docente; quindi se creo il corso creo a sua volta anche il docente a lui relativo.
	 * 			(se non gia' presente). */
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Docente docente;
	
	/* Fetch (lazy): Se carico un corso devo caricare gli allievi solo se richiesto; altrimenti se volessi, ad esempio, sapere
	 *       		 il nome di un corso dovrei caricare anche tutti gli allievi che fanno parte di quel corso e cio' rallenterebbe il sistema. */
	/* Cascade: Essendo una relazione ManyToMany conviene non inserire un evento a cascata, dato che andrebbe a rallentare il sistema se,
	 * 	 		ad esempio, andassi a fare la PERSIST (mi controllerebbe tutti gli allievi). */
	@ManyToMany
	private List<Allievo> allievi;
	

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

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getDurataMesi() {
		return durataMesi;
	}

	public void setDurataMesi(int durataMesi) {
		this.durataMesi = durataMesi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	
}
