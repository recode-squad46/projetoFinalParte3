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
@Table(name = "tb_partida_memoria")
public class PartidaMemoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tempo_partida")
	private int tempoPartida;
	
	@Column(name = "qtd_jogadas")
	private int quantidadeJogadas;

	
	
	public PartidaMemoria() {
		super();
	}
		
	public PartidaMemoria(long id, int tempoPartida, int quantidadeJogadas) {
		super();
		this.id = id;
		this.tempoPartida = tempoPartida;
		this.quantidadeJogadas = quantidadeJogadas;
	}

	
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTempoPartida() {
		return tempoPartida;
	}

	public void setTempoPartida(int tempoPartida) {
		this.tempoPartida = tempoPartida;
	}

	public int getQuantidadeJogadas() {
		return quantidadeJogadas;
	}

	public void setQuantidadeJogadas(int quantidadeJogadas) {
		this.quantidadeJogadas = quantidadeJogadas;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	//muitas partidas para um aluno - quem recebe a FK
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
}
