package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;

	
	
	public Aluno() {
		super();
	}

	public Aluno(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	//muitos alunos para um professor - quem recebe a FK
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	//Quem envia a FK
		@JsonIgnore
		@OneToMany(mappedBy = "aluno")
		private List<PartidaMemoria> partidaMemorias = new ArrayList<PartidaMemoria>();

		public List<PartidaMemoria> getPartidaMemorias() {
			return partidaMemorias;
		}

		public void setPartidaMemorias(List<PartidaMemoria> partidaMemorias) {
			this.partidaMemorias = partidaMemorias;
		}
}
