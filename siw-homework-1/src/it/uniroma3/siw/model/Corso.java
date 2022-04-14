package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Corso {
	
	@Id
	private Long id;
	
	private String nome;
	
	private LocalDate dataInizio;
	
	private int durataMesi;
	

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
	
}
