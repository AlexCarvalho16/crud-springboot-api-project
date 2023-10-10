package com.formulaOneTeste.formulaOneCrudEtapas.model.entities;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Calendario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String urlCircuito;
	private String urlBandeiraPais;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate data;
	
	public Calendario() {}
	
	public Calendario(String nome, String urlCircuito, String urlBandeiraPais, String data) {
		super();
		this.nome = nome;
		this.urlCircuito = urlCircuito;
		this.urlBandeiraPais = urlBandeiraPais;
		this.data = LocalDate.parse(data);
	}
	
	public Calendario(int id, String nome, String urlCircuito, String urlBandeiraPais, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.urlCircuito = urlCircuito;
		this.urlBandeiraPais = urlBandeiraPais;
		this.data = LocalDate.parse(data);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlCircuito() {
		return urlCircuito;
	}

	public void setUrlCircuito(String urlCircuito) {
		this.urlCircuito = urlCircuito;
	}

	public String getUrlBandeiraPais() {
		return urlBandeiraPais;
	}

	public void setUrlBandeiraPais(String urlBandeiraPais) {
		this.urlBandeiraPais = urlBandeiraPais;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
