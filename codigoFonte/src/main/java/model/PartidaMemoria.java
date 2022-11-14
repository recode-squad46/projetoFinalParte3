package model;

public class PartidaMemoria {

	private int id;
	private int tempoPartida;
	private int qtdJogadas;
	private int idAluno;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTempoPartida() {
		return tempoPartida;
	}
	public void setTempoPartida(int tempoPartida) {
		this.tempoPartida = tempoPartida;
	}
	public int getQtdJogadas() {
		return qtdJogadas;
	}
	public void setQtdJogadas(int qtdJogadas) {
		this.qtdJogadas = qtdJogadas;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	@Override
	public String toString() {
		return "PartidaMemoria [id=" + id + ", tempoPartida=" + tempoPartida + ", qtdJogadas=" + qtdJogadas
				+ ", idAluno=" + idAluno + "]";
	}
		
}
