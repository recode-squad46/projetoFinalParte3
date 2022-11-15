package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;

			
	
	public Professor() {
		super();
	}

	public Professor(long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	//Quem envia a FK
		@JsonIgnore
		@OneToMany(mappedBy = "professor")
		private List<Aluno> alunos = new ArrayList<Aluno>();

		public List<Aluno> getAlunos() {
			return alunos;
		}

		public void setAlunos(List<Aluno> alunos) {
			this.alunos = alunos;
		}
	
		
		//Quem envia a FK
		@JsonIgnore
		@OneToMany(mappedBy = "professor")
		private List<Card> cards = new ArrayList<Card>();

		public List<Card> getCards() {
			return cards;
		}

		public void setCards(List<Card> cards) {
			this.cards = cards;
		}
}
