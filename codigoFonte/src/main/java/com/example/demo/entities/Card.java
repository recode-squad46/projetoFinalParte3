package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(length = 1200, name = "img_card")
	private String imgCard;

	
	
	public Card() {
		super();
	}

	public Card(long id, String nome, String imgCard) {
		super();
		this.id = id;
		this.nome = nome;
		this.imgCard = imgCard;
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

	public String getImgCard() {
		return imgCard;
	}

	public void setImgCard(String imgCard) {
		this.imgCard = imgCard;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
		
	//muitos cards para um professor - quem recebe a FK
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
}
